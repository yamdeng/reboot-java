package com.yamdeng.reboot.java.thread;

// Thread priority(우선 순위)
public class ThreadPriority {

    private static class Runnable1 implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable1 run call : " + Thread.currentThread().getName());
            int maxIndex = 300;
            for(int index=0; index<maxIndex; index++) {
                for(int childIndex=0; childIndex<1000; childIndex++) {
                    System.out.print("-");
                }
            }
        }

    }

    private static class Runnable2 implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable2 run call : " + Thread.currentThread().getName());
            int maxIndex = 300;
            for(int index=0; index<maxIndex; index++) {
                for(int childIndex=0; childIndex<1000; childIndex++) {
                    System.out.print("*");
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("========== Thread priority(우선 순위) ==========");
        System.out.println();

        // 쓰레드 priority
        threadPriority();
        System.out.println();

        System.out.println("========== ThreadPriority End ==========");
    }

    private static void threadPriority() {
        System.out.println("쓰레드 priority");
        
        // setPriority 메서드는 예측할 수 없다
        Runnable runnable1 = new ThreadPriority.Runnable1();
        Thread runnableThread1 = new Thread(runnable1);
        runnableThread1.setPriority(Thread.MAX_PRIORITY);

        Runnable runnable2 = new ThreadPriority.Runnable2();
        Thread runnableThread2 = new Thread(runnable2);
        runnableThread2.setPriority(Thread.MIN_PRIORITY);
        
        runnableThread2.start();
        runnableThread1.start();

    }

}
