package com.yamdeng.reboot.java.util;

public class YamdengThreadUtil {

    public static Thread runThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
        return thread;
    }
}
