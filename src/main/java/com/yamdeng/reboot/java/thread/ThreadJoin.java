package com.yamdeng.reboot.java.thread;

import java.util.HashMap;
import java.util.Map;

// 쓰레드 join() 메서드
public class ThreadJoin {

    private static final HashMap<String, Thread> threadMap = new HashMap<>();

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
            System.out.println("@@@ Runnable1 end @@@");
        }

    }

    private static class Runnable2 implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable2 run call : " + Thread.currentThread().getName());
            int maxIndex = 5;
            for(int index=0; index<maxIndex; index++) {
                try{
                    Thread.sleep(1000);
                    System.out.println("Runnable2 index : " + (index+1));
//                    try {
//                        threadMap.get("thread1").join();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                // Runnable2가 Runnable1 보다 나중에 종료됨
                threadMap.get("thread1").join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("@@@ Runnable2 end @@@");
        }

    }

    public static void main(String[] args) {
        System.out.println("========== 쓰레드 join() 메서드 ==========");
        System.out.println();

        // thread.join()
        join();
        System.out.println();

        System.out.println("========== ThreadJoin End ==========");
    }

    private static void join() {
        System.out.println("thread.join()");

        Runnable runnable1 = new ThreadJoin.Runnable1();
        Thread runnableThread1 = new Thread(runnable1);

        Runnable runnable2 = new ThreadJoin.Runnable2();
        Thread runnableThread2 = new Thread(runnable2);
        threadMap.put("thread1", runnableThread1);
        threadMap.put("thread2", runnableThread2);

        runnableThread1.start();
        runnableThread2.start();
        try {
//            runnableThread1.join(); // 10초 기다리고 종료함
            runnableThread2.join(); // 5초 기다리고 종료함
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
