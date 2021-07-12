package com.yamdeng.reboot.java.thread;

// Thread.sleep 메서드 : 정적 메서드여도 현재 쓰레드에만 적용함
public class ThreadSleep {

    private static class RunnableSpec implements Runnable {

        @Override
        public void run() {
            System.out.println("RunnableSpec run call : " + Thread.currentThread().getName());
            int maxIndex = 10;
            for(int index=0; index<maxIndex; index++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("ThreadSleep.RunnableSpec index : " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static class RunnableSpec2 implements Runnable {

        @Override
        public void run() {
            System.out.println("RunnableSpec2 run call : " + Thread.currentThread().getName());
            int maxIndex = 10;
            for(int index=0; index<maxIndex; index++) {
                try {
                    Thread.sleep(500);
                    System.out.println("ThreadSleep.RunnableSpec2 index : " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static class RunnableException implements Runnable {

        @Override
        public void run() {
            System.out.println("RunnableException run call : " + Thread.currentThread().getName());
            if(true) {
                throw new RuntimeException("강제 예외 발생");
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("========== Thread.sleep 메서드 ==========");
        System.out.println();

        // 쓰레드 sleep
        threadSleep();
        System.out.println();

        System.out.println("========== ThreadSleep End ==========");
    }

    private static void threadSleep() {
        System.out.println("쓰레드 sleep");

        Runnable runnableSpec = new ThreadSleep.RunnableSpec();
        Thread runnableThread = new Thread(runnableSpec);
        runnableThread.start();

        Runnable runnableSpec2 = new ThreadSleep.RunnableSpec2();
        Thread runnableThread2 = new Thread(runnableSpec2);
        runnableThread2.start();

        Runnable exceptionRunnable = new ThreadSleep.RunnableException();
        Thread runnableExceptionThread = new Thread(exceptionRunnable);
        runnableExceptionThread.start();
    }

}
