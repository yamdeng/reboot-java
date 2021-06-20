package com.yamdeng.reboot.java.basic;

import java.util.Arrays;

// call by value, call by reference
public class CallByValueReference {

    public static void main(String[] args) throws Exception {
        System.out.println("========== call by value, call by reference ==========");
        System.out.println();

        // call by value
        int int1 = 10;
        callByValue(int1);
        System.out.println("int1 : " + int1);
        System.out.println();

        // call by reference
        int[] intArr = { 10, 20, 30 };
        callByReferene(intArr);
        System.out.println("intArr : " + Arrays.toString(intArr));
        System.out.println();

        System.out.println("========== CallByValueReference End ==========");
    }

    public static void callByValue(int arg) {
        System.out.println("callByValue");
        System.out.println("arg : " + arg);
        arg = 20;
    }

    public static void callByReferene(int[] arg) {
        System.out.println("callByReferene");
        System.out.println("arg : " + Arrays.toString(arg));
        arg[0] = 1000;
        arg = null;
    }
}
