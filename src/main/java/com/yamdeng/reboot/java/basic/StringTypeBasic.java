package com.yamdeng.reboot.java.basic;


// String 타입 기본
public class StringTypeBasic {

    public static void main(String[] args) {
        System.out.println("========== Sting 타입 기본 ==========");
        System.out.println();

        // String 타입 기본
        basicString();
        System.out.println();
        
        // 문자열 더하기
        plusString();
        System.out.println();

        System.out.println("========== StringTypeBasic End ==========");
    }

    public static void basicString() {
        System.out.println("String 타입 기본");
        String string1 = "hello";
        String string2 = "안녕하세요";
        String string3 = "";
        String string4 = null;
        String string5;
        System.out.println("string1 : " + string1); // hello
        System.out.println("string2 : " + string2); // 안녕하세요
        System.out.println("string3 : " + string3); //
        System.out.println("string4 : " + string4); // null
        // System.out.println("string5 : " + string5); // 에러
    }

    public static void plusString() {
        System.out.println("문자열 더하기");
        String string1 = "안녕";
        String string2 = string1 + "하세요";
        String string3 = string2 + 1 + 2;
        String string4 = string2 + (1+2);
        System.out.println("string1 : " + string1); // 안녕
        System.out.println("string2 : " + string2); // 안녕하세요
        System.out.println("string3 : " + string3); // 안녕하세요12
        System.out.println("string4 : " + string4); // 안녕하세요3
    }
}
