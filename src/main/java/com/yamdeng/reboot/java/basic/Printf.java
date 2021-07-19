package com.yamdeng.reboot.java.basic;


/*

    %b : boolean
    %d : 10진수
    %o : 8진수
    %x, %X : 16진수
    %f : 10진수(float)
    %e, %E : 지수형태표현
    %c : 문자
    %s : 문자열

 */

// Printf
public class Printf {

    public static void main(String[] args) {
        System.out.println("========== Printf ==========");
        System.out.println();

        // printf
        printf();
        System.out.println();

        System.out.println("========== Printf End ==========");
    }

    public static void printf() {
        System.out.println("printf");
        boolean boolean1 = false;
        byte byte1 = 10;
        short short1 = 20;
        int int1 = 65;
        char char1 = 65;
        long long1 = 40L;
        float float1 = 10.123f;
        double double1 = 100.456;
        String string1 = "hihi";
        System.out.printf("boolean1 %b %b", boolean1, boolean1); // false, false
        System.out.println();
        System.out.printf("byte1 %d, %b", byte1, byte1); // 10, true
        System.out.println();
        System.out.printf("short1 %d, %o", short1, short1); // 20, 24
        System.out.println();
        System.out.printf("int1 %x, %X, %c, %s", int1, int1, int1, int1); // 41, 41, A, 65
        System.out.println();
        System.out.printf("char1 %c, %s", char1, char1); // A, A
        System.out.println();
        System.out.printf("long1 %d, %s", long1, long1); // 40, 40
        System.out.println();
        System.out.printf("float1 %f, %e, %E, %s", float1, float1, float1, float1); // 10.123000, 1.012300e+01, 1.012300E+01, 10.123
        System.out.println();
        System.out.printf("double1 %f, %e, %E, %s", double1, double1, double1, double1); // 100.456000, 1.004560e+02, 1.004560E+02, 100.456
        System.out.println();
        System.out.printf("string1 %s", string1); // hihi
        System.out.println();
        Object obj = new Object();
        System.out.printf("object %s", obj); // 오류 X
        System.out.println();
        System.out.printf("object %d", obj); // 오류 O

    }

}
