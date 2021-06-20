package com.yamdeng.reboot.java.basic;

import static java.lang.System.out;

// static import
public class StaticImport {

    public static void main(String[] args) {
        System.out.println("========== static import ==========");
        System.out.println();

        // static import
        staticImport();
        System.out.println();

        System.out.println("========== StaticImport End ==========");
    }

    public static void staticImport() {
        System.out.println("static import");
        out.print("out method call");
    }
}
