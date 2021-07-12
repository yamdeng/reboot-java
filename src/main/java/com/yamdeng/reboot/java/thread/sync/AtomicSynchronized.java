package com.yamdeng.reboot.java.thread.sync;

import com.yamdeng.reboot.java.util.YamdengThreadUtil;

import java.util.concurrent.atomic.AtomicInteger;

// 동기화 기본 : Atomic 사용
public class AtomicSynchronized {
    private static AtomicInteger intValue = new AtomicInteger(0);

    private static void clear() {
        intValue.set(0);
    }

    private static void increment() {
        intValue.incrementAndGet();
    }

    private static void decrement() {
        intValue.decrementAndGet();
    }

    public static void plusStaticField() {
        intValue.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println("========== 동기화 기본 : Atomic 사용 ==========");
        System.out.println();

        // AtomicInteger 타입 동기화 테스트
        atomicInteger();
        System.out.println();

        System.out.println("========== BasicSynchronized End ==========");
    }

    private static void atomicInteger() {
        System.out.println("AtomicInteger 타입 동기화 테스트");

        clear();

        // synchronized 아닌 메서드 호출
        Thread t1 = YamdengThreadUtil.runThread(() -> {
            for(int index=0; index<100000; index++) {
                plusStaticField();
            }
        });
        Thread t2 = YamdengThreadUtil.runThread(() -> {
            for(int index=0; index<100000; index++) {
                plusStaticField();
            }
        });

        try {
            t1.join();
            t2.join();
            System.out.println("intValue : " + intValue.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clear();
        YamdengThreadUtil.runThread(() -> {
            for(int index=0; index<100000; index++) {
                increment();
            }
        });
        YamdengThreadUtil.runThread(() -> {
            for(int index=0; index<100000; index++) {
                decrement();
            }
        });

        try {
            t1.join();
            t2.join();
            System.out.println("intValue : " + intValue.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
