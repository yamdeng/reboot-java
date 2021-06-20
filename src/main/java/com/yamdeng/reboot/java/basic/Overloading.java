package com.yamdeng.reboot.java.basic;

import java.util.StringTokenizer;

// 메서드 오버로딩
public class Overloading {

    public static void main(String[] args) {
        System.out.println("========== 메서드 오버로딩 ==========");
        System.out.println();

        // 메서드 오버로딩
        method1(10); // method1 int : 10
        method1("test"); // method1 string : test
        method1(new StringTokenizer("aaa")); // method1 object : java.util.StringTokenizer@60addb54
        method1(30.5); // method1 object : 30.5
        method1(true); // method1 object : true
        method1(new Integer("10")); // method1 Integer : 10
        System.out.println();

        System.out.println("========== Overloading End ==========");
    }

    public static void method1(String arg) {
        System.out.println("method1 string : " + arg);
    }
    
    // 반환타입과 오버로딩과는 상관없음 : 에러
//    public static int method1(String arg) {
//        System.out.println("method1 string : " + arg);
//        return 0;
//    }

    public static void method1(Object arg) {
        System.out.println("method1 object : " + arg);
    }

    public static void method1(int arg) {
        System.out.println("method1 int : " + arg);
    }

    public static void method1(Integer arg) {
        System.out.println("method1 Integer : " + arg);
    }
    
}
