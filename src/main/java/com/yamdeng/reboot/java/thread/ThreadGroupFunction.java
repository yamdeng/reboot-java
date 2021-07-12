package com.yamdeng.reboot.java.thread;

// 쓰레드 그룹
public class ThreadGroupFunction {

    private static class Runnable1 implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable1 run call : " + Thread.currentThread().getName());
            int maxIndex = 300;
            for(int index=0; index<maxIndex; index++) {
                for(int childIndex=0; childIndex<1000; childIndex++) {
                    System.out.print("-");
                    if(Thread.currentThread().getState() == Thread.State.RUNNABLE) {
//                        Thread.currentThread().getThreadGroup().destroy();
                    }
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
                    if(Thread.currentThread().getState() == Thread.State.RUNNABLE) {
//                        Thread.currentThread().getThreadGroup().destroy();
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("========== 쓰레드 그룹 ==========");
        System.out.println();

        // 쓰레드 group
        threadGroup();
        System.out.println();

        System.out.println("========== ThreadGroupFunction End ==========");
    }

    private static void threadGroup() {
        System.out.println("쓰레드 group");

        ThreadGroup main = Thread.currentThread().getThreadGroup();
        System.out.println("main group thread name : " + main.getName());
        ThreadGroup grp1 = new ThreadGroup("Group1");
        ThreadGroup grp2 = new ThreadGroup(grp1, "Group2");

        Runnable runnable1 = new ThreadGroupFunction.Runnable1();
        Thread runnableThread1 = new Thread(grp1, runnable1);

        Runnable runnable2 = new ThreadGroupFunction.Runnable2();
        Thread runnableThread2 = new Thread(grp2, runnable2);

        runnableThread2.start();
        runnableThread1.start();
    }

}
