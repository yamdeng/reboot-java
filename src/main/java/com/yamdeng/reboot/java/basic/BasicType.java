package com.yamdeng.reboot.java.basic;

/*

    기본 타입의 범위
     -boolean : 1byte (false, true)
     -char : 2byte ( 0 ~ 65535) : 2(16)
     -byte : 1byte ( -128 ~ 127) : 2(7)
     -short : 2byte ( -32,768 ~ 32,767) : 2(15)
     -int : 4byte ( -2147483648 ~ 2147483647) : 2(31) 약 20억
     -long : 8byte ( -9223372036854775808 ~ 9223372036854775807) : 2(63)
     -float : 4byte (1.4E-45~3.4E38)
     -double : 8byte (4.9E-324~1.8E308)

 */

/*

    숫자 리터럴
     -0b01010 : 이진수
     -077 : 8진수
     -0xFF : 16진수
     -100_000L, 100000L : long
     -1.4f, 1.4F: float
     -1.4d, 1.4D : double(생략시 기본 double)

 */

// 변수 : 기본 타입
public class BasicType {

    public static void main(String[] args) throws Exception {
        System.out.println("========== 변수 : 기본 타입 ==========");
        System.out.println();

        // boolean 타입
        boolType();
        System.out.println();

        // 정수 타입
        naturalNumberType();
        System.out.println();

        // 문자 타입
        charType();
        System.out.println();

        // 실수 타입
        realNumberType();
        System.out.println();

        // 상수 : final
        constant();
        System.out.println();

        // 숫자 타입별 리터럴 정의 방법
        literalPrefix();
        System.out.println();

        // int 이하의 타입끼리 연산시
        intBottomTypeOperator();
        System.out.println();

        // 10진수를 2, 8, 16 진법 문자열로 변환
        toBinaryString();
        System.out.println();

        System.out.println("========== BasicType End ==========");
    }

    public static void boolType() {
        System.out.println("boolean 타입");
        boolean b1 = false;
        boolean b2 = true;
        System.out.println("b1 : " + b1); // false
        System.out.println("b2 : " + b2); // true
        System.out.println("!b1 : " + !b1); // true
        System.out.println("!b2 : " + !b2); // false
        System.out.println("!!b1 : " + !!b1); // false
        System.out.println("!!b2 : " + !!b2); // true
        System.out.println("b1+b2 : " + b1 + b2); // faletrue
    }

    public static void naturalNumberType() {
        System.out.println("정수 타입");
        byte byte1 = 10;
        short short1 = 1000;
        int int1 = 10000;
        long long1 = 100000L;

        System.out.println("byte1 : " + byte1); // 10
        System.out.println("short1 : " + short1); // 1000
        System.out.println("int1 : " + int1); // 10000
        System.out.println("long1 : " + long1); // 100000
    }

    public static void charType() {
        System.out.println("문자 타입");
        char char1 = 'a';
        char char2 = 'b';
        char char3 = '안';
        System.out.println("char1 : " + char1); // a
        System.out.println("char2 : " + char2); // b
        System.out.println("char3 : " + char3); // 안
        // char 타입끼리 더하면 숫자가 된다
        System.out.println("char1 + char2: " + (char1 + char2)); // 195

        char charga1 = '가';
        char charga2 = 0xAC00;
        char charga3 = '\uAC00';
        System.out.println("charga1 : " + charga1); // 가
        System.out.println("charga2 : " + charga2); // 가
        System.out.println("charga3 : " + charga3); // 가
        // char char11 = ''; // 에러
        // char char12 = null; // 에러
    }

    public static void realNumberType() {
        System.out.println("실수 타입");
        float float1 = 1.00f;
        double double1 = 10.00;
        System.out.println("float1 : " + float1); // 1.0
        System.out.println("double1 : " + double1); // 10.0
    }

    public static void constant() {
        System.out.println("상수");
        final int const1 = 10;
        System.out.println("const1 : " + const1);
        // const1 = 20; // 에러

    }

    public static void literalPrefix() {
        System.out.println("숫자 타입별 리터럴 정의 방법");
        int prefixBit = 0b11; // 3
        int prefix8 = 011; // 9
        int prefix16 = 0x11; // 17
        int int1 = 100_100; // 100100
        long long1 = 100_100_100L; // 100100100
        float float1 = 1.1F; // 1.1;
        double double1 = 10.11; // 10.11 === 10.11D

        System.out.println("prefixBit : " + prefixBit); // 3
        System.out.println("prefix8 : " + prefix8); // 9
        System.out.println("prefix16 : " + prefix16); // 17
        System.out.println("int1 : " + int1); // 100100
        System.out.println("long1 : " + long1); // 100100100
        System.out.println("float1 : " + float1); // 1.1
        System.out.println("double1 : " + double1); // 10.11
    }

    public static void intBottomTypeOperator() {
        System.out.println("int 이하의 타입끼리 연산시");
        byte byte1 = 10; // 10 + 127 에러
        byte byte2 = 20;
        // byte byte3 = byte1 + byte2; // int 이하의 타입끼리 연산시 자동으로 int 타입이 됨 // 에러
        short short1 = 10 + 10;
        // short short2 = 10 + byte1; // int 이하의 타입끼리 연산시 자동으로 int 타입이 됨 // 에러
        int int1 = 10 + byte1;
        long long1 = 10 + byte1; // long 타입은 int 타입을 포함하고 있음

        // float float1 = 10 + 20.0; // double 이하의 타입끼리 연산시 자동으로 double 타입이 됨(단, 10.0f와 같이 리터럴에 float 타입을 명시하면 에러가 나지 않음 // 에러
        // float float2 = float1 + 10.0;
        float float3 = 10.f + 20.f;
    }

    private static void toBinaryString() {
        System.out.println("10진수를 2, 8, 16 진법 문자열로 변환");
        int intValue = 17;
        System.out.println("Integer.toBinaryString(intValue) : " + Integer.toBinaryString(intValue));
        System.out.println("Integer.toOctalString(intValue) : " + Integer.toOctalString(intValue));
        System.out.println("Integer.toHexString(intValue) : " + Integer.toHexString(intValue));
        System.out.println("Double.toHexString(intValue) : " + Integer.toHexString(intValue));
    }

}
