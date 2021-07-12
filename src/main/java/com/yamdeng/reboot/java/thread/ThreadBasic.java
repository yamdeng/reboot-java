package com.yamdeng.reboot.java.thread;

import java.util.Iterator;
import java.util.Map;

// 쓰레드 기본 : 실행 방법 2가지, 예외 발생
public class ThreadBasic {

    private static class ThreadChild extends Thread {
        @Override
        public void run() {
            System.out.println("ThreadChild run call : " + Thread.currentThread().getName());
        }
    }

    private static class RunnableSpec implements Runnable {

        boolean isException = false;

        RunnableSpec() {}

        RunnableSpec(boolean isException) {
            this.isException = isException;
        }

        @Override
        public void run() {
            System.out.println("RunnableSpec run call : " + Thread.currentThread().getName());
            if(this.isException) {
                this.testException();
            }
        }

        private void testException() {
            try {
                throw new Exception("RunnableSpec throw new Exception");
            } catch (Exception e) {
                e.printStackTrace();
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

    private static class RunnableAllStackTrace implements Runnable {

        @Override
        public void run() {
            System.out.println("RunnableAllStackTrace run call : " + Thread.currentThread().getName());
            Thread currentThread = Thread.currentThread();
            StackTraceElement[] stackTraceArray = currentThread.getStackTrace();
            for(StackTraceElement stackTraceElement : stackTraceArray) {
                System.out.println("stackTraceElement.toString() : " + stackTraceElement.toString());
            }
            Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
            Iterator<Thread> it = map.keySet().iterator();

            while(it.hasNext()) {
                Thread thread = it.next();
                StackTraceElement[] ste = (StackTraceElement[])(map.get(thread));
                for(StackTraceElement stackTraceElement : ste) {
                    System.out.println("stackTraceElement.toString() iterator : " + stackTraceElement.toString());
                }
                System.out.println();
            }

        }

    }

    private static class RunnableTimeCheck implements Runnable {
        @Override
        public void run() {
            int maxIndex = 100000;
            System.out.println("RunnableTimeCheck run for start");
//            long startTime = System.currentTimeMillis();
            long startTime = System.nanoTime();
            for(int index=0; index<maxIndex; index++) {
                System.out.print("");
            }
//            long endTime = System.currentTimeMillis();
            long endTime = System.nanoTime();
            System.out.println("RunnableTimeCheck run for end : " + (endTime - startTime));
        }
    }

    public static void main(String[] args) {
        System.out.println("========== 스트림 기본 ==========");
        System.out.println();

        // 쓰레드 기본
        basicThread();
        System.out.println();

        // 예외 발생
        exceptionThread();
        System.out.println();

        // getAllStackTraces
        getAllStackTracesCheck();
        System.out.println();

        // 같은 Runnable 객체를 동시에 start
        sameRunnableStart();
        System.out.println();

        // 쓰레드 시간 체크
        threadTimeCheck();
        System.out.println();

        System.out.println("========== ThreadBasic End ==========");
    }

    private static void basicThread() {
        System.out.println("쓰레드 기본");

        String beforeThreadName = Thread.currentThread().getName();
        System.out.println("beforeThreadName : " + beforeThreadName);

        // Thread 상속한 클래를 사용
        ThreadChild threadChild = new ThreadChild();
        threadChild.start();

        // Runnable 구현한 클래스를 사용
        Runnable runnableSpec = new RunnableSpec();
        Thread runnableThread = new Thread(runnableSpec);
        runnableThread.start();

        // 람다를 사용하여 바로 생성
        Thread ramdaRunnable = new Thread(() -> System.out.println("ramda run call : " + Thread.currentThread().getName()));
        ramdaRunnable.start();
    }

    private static void exceptionThread() {
        System.out.println("예외 발생");

        Runnable runnable = new RunnableSpec(true);
        Thread runnableThread = new Thread(runnable);
        runnableThread.start();

        Runnable runnable2 = new RunnableException();
        Thread runnableThread2 = new Thread(runnable2);

        // 쓰레드의 외부에서 예외처리하는 방법
        runnableThread2.setUncaughtExceptionHandler((thread, exception) -> {
            exception.printStackTrace();
        });
        try {
            runnableThread2.start();
//            runnableThread2.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void threadTimeCheck() {
        System.out.println("쓰레드 시간 체크");

        int maxIndex = 100000;
        System.out.println("threadTimeCheck method for start");
//        long startTime = System.currentTimeMillis();
        long startTime = System.nanoTime();
        for(int index=0; index<maxIndex; index++) {
            System.out.print("");
        }
//        long endTime = System.currentTimeMillis();
        long endTime = System.nanoTime();
        System.out.println("threadTimeCheck method for end : " + (endTime - startTime));

        Runnable runnable = new RunnableTimeCheck();
        Thread runnableThread = new Thread(runnable);
        runnableThread.start();
    }

    private static void sameRunnableStart() {
        System.out.println("같은 Runnable 객체를 동시에 start");

        Runnable runnableSpec = new RunnableSpec();
        Thread runnableThread = new Thread(runnableSpec);
        Thread runnableThread2 = new Thread(runnableSpec);
        runnableThread.start();
        runnableThread2.start();
    }

    private static void getAllStackTracesCheck() {
        System.out.println("getAllStackTraces()");

        Runnable runnable = new ThreadBasic.RunnableAllStackTrace();
        Thread runnableThread = new Thread(runnable);
        runnableThread.start();

        System.out.println("display : Thread.getAllStackTraces()");

        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        Iterator<Thread> it = map.keySet().iterator();

        while(it.hasNext()) {
            Thread thread = it.next();
            StackTraceElement[] ste = (StackTraceElement[])(map.get(thread));
            for(StackTraceElement stackTraceElement : ste) {
                System.out.println("stackTraceElement.toString() iterator(display) : " + stackTraceElement.toString());
            }
            System.out.println();
        }
    }

}
