package com.yamdeng.reboot.java.thread.sync;

import com.yamdeng.reboot.java.util.YamdengThreadUtil;

// 동기화 기본
public class BasicSynchronized {

    public static int intValue = 0;
    public static long longValue = 0;
    public static double doubleValue = 0.0;
    public static Integer integerValue = 0;

    private static void clear() {
        intValue = 0;
        longValue = 0;
        doubleValue = 0.0;
        integerValue = 0;
    }

    public static void plusStaticField() {
        intValue = intValue + 1;
        longValue = longValue + 1;
        doubleValue = doubleValue + 1;
        integerValue = integerValue + 1;
    }

    public static synchronized void plusStaticFieldSync() {
        intValue++;
        longValue++;
        doubleValue++;
        integerValue++;
    }

    private static class Runnable1 implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable1 run call : " + Thread.currentThread().getName());
            int maxIndex = 1000;
            for(int index=0; index<maxIndex; index++) {
                intValue = intValue + 1;
                longValue = longValue + 1;
                doubleValue = doubleValue + 1;
                integerValue = integerValue + 1;
//                synchronized (integerValue) {
//                    intValue = intValue + 1;
//                    longValue = longValue + 1;
//                    doubleValue = doubleValue + 1;
//                    integerValue = integerValue + 1;
//                }
//                intValue++;
//                longValue++;
//                doubleValue++;
//                integerValue++;
            }
            System.out.println();
        }

    }

    private static class Runnable2 implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable2 run call : " + Thread.currentThread().getName());
            int maxIndex = 1000;
            for(int index=0; index<maxIndex; index++) {
                intValue = intValue + 1;
                longValue = longValue + 1;
                doubleValue = doubleValue + 1;
                integerValue = integerValue + 1;
//                synchronized (integerValue) {
//                    intValue = intValue + 1;
//                    longValue = longValue + 1;
//                    doubleValue = doubleValue + 1;
//                    integerValue = integerValue + 1;
//                }
//                intValue++;
//                longValue++;
//                doubleValue++;
//                integerValue++;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        System.out.println("========== 동기화 기본 ==========");
        System.out.println();

        // 정적 필드의 값을 바로 사용
        directStaticField();
        System.out.println();
        
        // 정적 메서드를 통해 값을 변경
        staticMethodCall();
        System.out.println();

        System.out.println("========== BasicSynchronized End ==========");
    }

    private static void directStaticField() {
        System.out.println("정적 필드의 값을 바로 사용");
        clear();

        Runnable runnable1 = new BasicSynchronized.Runnable1();
        Thread runnableThread1 = new Thread(runnable1);

        Runnable runnable2 = new BasicSynchronized.Runnable2();
        Thread runnableThread2 = new Thread(runnable2);
        runnableThread1.start();
        runnableThread2.start();
        try {
            runnableThread1.join();
            runnableThread2.join();
            System.out.println("intValue : " + intValue);
            System.out.println("longValue : " + longValue);
            System.out.println("doubleValue : " + doubleValue);
            System.out.println("integerValue : " + integerValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void staticMethodCall() {
        System.out.println("정적 메서드를 통해 값을 변경");
        clear();
        
        // synchronized 아닌 메서드 호출
        Thread t1 = YamdengThreadUtil.runThread(() -> {
            for(int index=0; index<10000; index++) {
                plusStaticField();
            }
        });
        Thread t2 = YamdengThreadUtil.runThread(() -> {
            for(int index=0; index<10000; index++) {
                plusStaticField();
            }
        });

        try {
            t1.join();
            t2.join();
            System.out.println("intValue : " + intValue);
            System.out.println("longValue : " + longValue);
            System.out.println("doubleValue : " + doubleValue);
            System.out.println("integerValue : " + integerValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // synchronized 메서드 호출
        clear();
        t1 = YamdengThreadUtil.runThread(() -> {
            for(int index=0; index<10000; index++) {
                plusStaticFieldSync();
            }
        });
        t2 = YamdengThreadUtil.runThread(() -> {
            for(int index=0; index<10000; index++) {
                plusStaticFieldSync();
            }
        });

        try {
            t1.join();
            t2.join();
            System.out.println("intValue : " + intValue);
            System.out.println("longValue : " + longValue);
            System.out.println("doubleValue : " + doubleValue);
            System.out.println("integerValue : " + integerValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
