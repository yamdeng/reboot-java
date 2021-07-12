package com.yamdeng.reboot.java.thread;

// 쓰레드 interrupt : Thread.sleep 시에 interrupt() 메서드 실행시 InterruptedException 예외 발생함. interrupt 는 잠자는 쓰레드를 깨우는 역할도 함
public class ThreadInterrupt {

    private static class Runnable1 implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable1 run call : " + Thread.currentThread().getName());
            Thread currentThread = Thread.currentThread();
            try {
                while(true) {
                    if(currentThread.isInterrupted()) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Runnable1 run end");
        }

    }

    private static class Runnable2 implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable2 run call : " + Thread.currentThread().getName());
            Thread currentThread = Thread.currentThread();
            boolean sleepCall = true;
            while(true) {
                try {
//                    if(sleepCall) {
//                        Thread.sleep(1000);  // 1초 지연
//                        sleepCall = false;
//                    }
                    Thread.sleep(1000);  // 1초 지연
                    System.out.println("Runnable2 run while inner call");
                } catch(InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                if(currentThread.isInterrupted()) {
                    break;
                }
            }
            System.out.println("Runnable2 run end");
        }

    }

    public static void main(String[] args) {
        System.out.println("========== 쓰레드 interrupt ==========");
        System.out.println();

        // interrupt() ---> isInterrupted()
        interrupt();
        System.out.println();

        // interrupt() ---> isInterrupted() + Thread.sleep
        interruptSleep();
        System.out.println();

        System.out.println("========== ThreadInterrupt End ==========");
    }

    private static void interrupt() {
        System.out.println("interrupt() ---> isInterrupted()");

        Runnable runnable1 = new ThreadInterrupt.Runnable1();
        Thread runnableThread1 = new Thread(runnable1);
        runnableThread1.start();

        try {
            Thread.sleep(2000);
            runnableThread1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void interruptSleep() {
        System.out.println("interrupt() ---> isInterrupted() + Thread.sleep");

        Runnable runnable2 = new ThreadInterrupt.Runnable2();
        Thread runnableThread2 = new Thread(runnable2);
        runnableThread2.start();

        try {
            Thread.sleep(5000);
            runnableThread2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
