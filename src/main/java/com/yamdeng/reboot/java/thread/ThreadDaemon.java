package com.yamdeng.reboot.java.thread;

// 쓰레드 데몬
public class ThreadDaemon {

    private static class Runnable1 implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable1 run call : " + Thread.currentThread().getName());
            int maxIndex = 10;
            for(int index=0; index<maxIndex; index++) {
                try{
                    Thread.sleep(1000);
                    System.out.println("Runnable1 index : " + (index+1));
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }

    }

    private static class Runnable2 implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable2 run call : " + Thread.currentThread().getName());
            int maxIndex = 3;
            for(int index=0; index<maxIndex; index++) {
                try{
                    Thread.sleep(1000);
                    System.out.println("Runnable2 index : " + (index+1));
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        System.out.println("========== 쓰레드 데몬 ==========");
        System.out.println();

        // 데몬 쓰레드
        damonThread();
        System.out.println();

        System.out.println("========== ThreadDeamon End ==========");
    }

    private static void damonThread() {
        System.out.println("데몬 쓰레드");

        Runnable runnable1 = new ThreadDaemon.Runnable1();
        Thread runnableThread1 = new Thread(runnable1);
        runnableThread1.setDaemon(true);

        Runnable runnable2 = new ThreadDaemon.Runnable2();
        Thread runnableThread2 = new Thread(runnable2);
        runnableThread2.setDaemon(false);

        runnableThread1.start();
        runnableThread2.start();
    }

}
