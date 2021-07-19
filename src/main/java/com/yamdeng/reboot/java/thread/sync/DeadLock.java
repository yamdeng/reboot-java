package com.yamdeng.reboot.java.thread.sync;

import com.google.common.collect.ForwardingSet;
import com.yamdeng.reboot.java.util.YamdengThreadUtil;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// 교착 상태 : 데드 락
public class DeadLock {

    private static final String SNAME = "";

    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.println("bower.name : " + bower.name);
//            String name = bower.name;
//            System.out.println("bower.name : " + name);
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    private static class ShareData {

        private int intValue = 0;
        private AtomicInteger atomicInt = new AtomicInteger(0);
        List<String> threadNameList = new ArrayList<>();

        public int getIntValue() {
            return intValue;
        }

        public void setIntValue(int intValue) {
            this.intValue = intValue;
        }

        public AtomicInteger getAtomicInt() {
            return atomicInt;
        }

        public void setAtomicInt(AtomicInteger atomicInt) {
            this.atomicInt = atomicInt;
        }

        public synchronized void criticalArea1() {
            String currentThreadName = Thread.currentThread().getName();
            System.out.println("criticalArea1 currentThreadName : " + currentThreadName);
            try {
                Thread.sleep(1000);
                criticalArea2();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void criticalArea2() {
            String currentThreadName = Thread.currentThread().getName();
            System.out.println("criticalArea2 currentThreadName : " + currentThreadName);
            try {
                Thread.sleep(500);
                criticalArea1();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("========== 동기화 기본 ==========");
        System.out.println();

        // dead lock oracle document
        oracleDocumentExample();


        // dead lock case
//        deadLockCase();

//        basicDeadLockCase();
        System.out.println();

//        basicDeadLockCase2();

        System.out.println("========== DeadLock End ==========");
    }

    private static void oracleDocumentExample() {
        System.out.println("dead lock oracle document");

        // 첫번재 Friend 인스턴스 생성
        final Friend alphonse =
                new Friend("Alphonse");

        // 2번째 Friend 인스턴스 생성
        final Friend gaston =
                new Friend("Gaston");

        new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                gaston.bow(alphonse);
             }
        }).start();
    }
//
//    private static void basicDeadLockCase() {
//        final String resource1 = "ratan jaiswal";
//        final String resource2 = "vimal jaiswal";
//
//        // run 메서드 : 실행하자 마자 resource1을 바로 잠금(먼저 실행되므로) 그 상태에서 0.1초 뒤에 resource2에 접근
//        Thread t1 = new Thread() {
//            public void run() {
//                synchronized (resource1) {
//                    System.out.println("Thread 1: locked resource 1");
//
//                    try { Thread.sleep(100);} catch (Exception e) {}
//
//                    synchronized (resource2) {
//                        System.out.println("Thread 1: locked resource 2");
//                    }
//                }
//            }
//        };
//
//        // run 메서드 : 실행하자 마자 resource2를 바로 잠금(먼저 실행되므로) 그 상태에서 0.1초 뒤에 resource1에 접근
//        Thread t2 = new Thread() {
//            public void run() {
//                synchronized (resource2) {
//                    System.out.println("Thread 2: locked resource 2");
//
//                    try { Thread.sleep(100);} catch (Exception e) {}
//
//                    synchronized (resource1) {
//                        System.out.println("Thread 2: locked resource 1");
//                    }
//                }
//            }
//        };
//
//
//        t1.start();
//        t2.start();
//    }
//
//    private static void deadLockCase() {
//        System.out.println("dead lock case");
//
//        ShareData shareData = new ShareData();
//
//        YamdengThreadUtil.runThread(() -> {
//            System.out.println("start thread1");
//            shareData.criticalArea1();
//            System.out.println("====== Thread 1 end ======");
//        });
//
//        YamdengThreadUtil.runThread(() -> {
//            System.out.println("start thread2");
//            shareData.criticalArea2();
//            System.out.println("====== Thread 2 end ======");
//        });
//
//    }

}
