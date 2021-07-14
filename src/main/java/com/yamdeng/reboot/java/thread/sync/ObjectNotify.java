package com.yamdeng.reboot.java.thread.sync;

import com.yamdeng.reboot.java.util.YamdengThreadUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

// object.notify, object.notifyAll, object.wait
public class ObjectNotify {

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

        public synchronized void incrementValueAll() {
            intValue++;
            atomicInt.incrementAndGet();
            String currentThreadName = Thread.currentThread().getName();
            System.out.println("currentThreadName : " + currentThreadName);
            threadNameList.add(currentThreadName);
            try {
                Thread.sleep(200);
                // 3번 이상 메서드를 호출하였을 경우
                if(threadNameList.size() > 2) {
                    String lastThreadName = threadNameList.get(threadNameList.size() - 2);
                    if(currentThreadName.equals(lastThreadName)) {
                        // 현재 쓰레드와 바로 직전 쓰레드가 같으면 wait를 해서 다른 스레드에게 호출할 수 있는 기회를 줌
                        notifyAll();
                        if(intValue < 29) {
                            wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("========== object.notify, object.notifyAll, object.wait ==========");
        System.out.println();

        // wait, notify, notifyAll
        objectNotifyMethod();
        System.out.println();

        System.out.println("========== ObjectNotify End ==========");
    }

    private static void objectNotifyMethod() {
        System.out.println("wait, notify, notifyAll");

        ShareData shareData = new ShareData();

        YamdengThreadUtil.runThread(() -> {
            for(int index=0; index<10; index++) {
                shareData.incrementValueAll();
            }
            System.out.println("thread1 shareData intValue : " + shareData.getIntValue());
            System.out.println("thread1 shareData atomicInt : " + shareData.getAtomicInt().get());
        });

        YamdengThreadUtil.runThread(() -> {
            for(int index=0; index<10; index++) {
                shareData.incrementValueAll();
            }
            System.out.println("thread2 shareData intValue : " + shareData.getIntValue());
            System.out.println("thread2 shareData atomicInt : " + shareData.getAtomicInt().get());
        });

        YamdengThreadUtil.runThread(() -> {
            for(int index=0; index<10; index++) {
                shareData.incrementValueAll();
            }
            System.out.println("thread3 shareData intValue : " + shareData.getIntValue());
            System.out.println("thread3 shareData atomicInt : " + shareData.getAtomicInt().get());
        });

    }

}
