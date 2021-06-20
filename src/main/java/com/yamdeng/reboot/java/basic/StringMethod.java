package com.yamdeng.reboot.java.basic;

import java.util.StringTokenizer;

// String 메서드
public class StringMethod {

    public static void main(String[] args) {
        System.out.println("========== Sting 메서드 ==========");
        System.out.println();

        // String 메서드
        stringMethod();
        System.out.println();
        
        // 문자열 토큰
        stringTokenizer();
        System.out.println();

        System.out.println("========== StringMethod End ==========");
    }

    public static void stringMethod() {
        System.out.println("String 메서드");
    }

    public static void stringTokenizer() {
        System.out.println("문자열 토큰");
//        new StringTokenizer()
    }
}
