package com.yamdeng.reboot.java.basic;

// 연산자
public class Operator {

    public static void main(String[] args) {
        System.out.println("========== 연산자 ==========");
        System.out.println();
        
        // 증감 연산자 : ++, --
        increase();
        System.out.println();

        // 사칙 연산자 : +, -, *, /
        arithmetic();
        System.out.println();

        // 나머지 연산자 : %
        remind();
        System.out.println();

        // 부호 연산자 : -, +
        sign();
        System.out.println();

        // 비교 연산자 : >, <, >=, <=, ==, !=
        compare();
        System.out.println();

        // 논리 연산자 : &&, ||, !
        logic();
        System.out.println();

        // 복합 대입 연산자 : +=, -=, *=, /=, %=, <<=, >>=, &=, ^=, |=
        opSign();
        System.out.println();

        // 비트 연산자 : <<, >>, &, |, ^, ~
         bit();
        System.out.println();

        // 삼항 연산자 : ? :
        threeOp();
        System.out.println();

        System.out.println("========== Operator End ==========");
    }

    public static void increase() {
        System.out.println("증감 연산자 : ++, --");
        int int1 = 10;
        int int2 = int1++;
        System.out.println("int1 : " + int1); // 11
        System.out.println("int2 : " + int2); // 10

        int2 = ++int1;
        System.out.println("int1 : " + int1); // 12
        System.out.println("int2 : " + int2); // 12
    }

    public static void arithmetic() {
        System.out.println("사칙 연산자 : +, -, *, /");
        int int1 = 10;
        int int2 = 20;
        int plusResult = int1 + int2;
        int minusResult = int1 - int2;
        int multiplyResult = int1 * int2;
        int divResult = int1 / int2;
        System.out.println("plusResult : " + plusResult); // 30
        System.out.println("minusResult : " + minusResult); // -10
        System.out.println("multiplyResult : " + multiplyResult); // 200
        System.out.println("divResult : " + divResult); // 0
        double double1 = 10.2;
        double double2 = 20.5;
        double plusResultDouble = double1 + double2;
        double minusResultDouble = double1 - double2;
        double multiplyResultDouble = double1 * double2;
        double divResultDouble = double1 / double2;
        System.out.println("plusResultDouble : " + plusResultDouble); // 30.7
        System.out.println("minusResultDouble : " + minusResultDouble); // -10.3
        System.out.println("multiplyResultDouble : " + multiplyResultDouble); // 209.1
        System.out.println("divResultDouble : " + divResultDouble); // 0.49756097560975604
    }

    public static void remind() {
        System.out.println("나머지 연산자 : %");
        int int1 = 10;
        int int2 = 3;
        int int3 = int1 % int2;
        System.out.println("int1 % int2 : " + int3); // 1

        double double1 = 5;
        double double2 = 1.5;
        double double3 = double1 % double2;
        System.out.println("double1 % double2 : " + 0.5); // 0.5
    }

    public static void sign() {
        System.out.println("부호 연산자 : -, +");
        int int1 = +10;
        int int2 = -3;
        int int3 = int1 + int2;
        System.out.println("int1 + int2 : " + int3); // 7
    }

    public static void compare() {
        System.out.println("비교 연산자 : >, <, >=, <=, ==, !=");
        int int1 = 10;
        int int2 = 11;
        int int3 = 10;
        String str1 = "hi";
        String str2 = "hello";
        String str3 = "hi";
        String str4 = new String("hi");
        if(str1.equals("hi")) {
            System.out.println("str1 equals \"hi\""); // yes
        }
        if(!str1.equals(str2)) {
            System.out.println("str1 not equals str2"); // yes
        }
        if(str1 == "hi") {
            System.out.println("str1 == \"hi\" "); // yes
        }
        if(str1 == str3) {
            System.out.println("str1 == str3"); // yes
        }
        if(str1 != str4) {
            System.out.println("str1 != str4"); // yes
        }
        // >, <, >=, <=
        if(int1 < int2) {
            System.out.println("int1 < int2"); // yes
        }
        if(int1 <= int3) {
            System.out.println("int1 <= int3"); // yes
        }
        if(int1 == int3) {
            System.out.println("int1 == int3"); // yes
        }
        if(int1 != int2) {
            System.out.println("int1 != int2"); // yes
        }

        double double1 = 3.3;
        double double2 = 5.2;
        double double3 = 3.3;
        if(double1 < double2) {
            System.out.println("double1 < double2"); // yes
        }
        if(double1 <= double3) {
            System.out.println("double1 <= double3"); // yes
        }
        if(double1 == double3) {
            System.out.println("double1 == double3"); // yes
        }
        if(double1 != double2) {
            System.out.println("double1 != double2"); // yes
        }
    }

    public static void logic() {
        System.out.println("논리 연산자 : &&, ||, !");
        int int1 = 10;
        int int2 = 20;
        int int3 = 10;
        if(int1 == int3 && int1 == 10 || int3 == 20) {
            System.out.println("int1 == int3 && int1 == 10 || int3 == 20 : " + true);
        }
    }

    public static void opSign() {
        System.out.println("복합 대입 연산자 : +=, -=, *=, /=, %=, <<=, >>=, &=, ^=, |=");
        int int1 = 10;
        int1 += 10;
        System.out.println("int1 += 10 : " + int1); // 20
    }

    public static void bit() {
        System.out.println("비트 연산자 : <<, >>, &, |, ^, ~");
        int int1 = 2;
        int int2 = int1 >> 1;
        System.out.println("int1 >> 1 : " + int2); // 1
        int2 = int1 << 2;
        System.out.println("int1 << 2 : " + int2); // 8
        int2 = int1 & 3;
        System.out.println("int1 & 3 : " + int2); // 2
        int2 = int1 | 3;
        System.out.println("int1 | 3 : " + int2); // 3
        int2 = int1 ^ 3;
        System.out.println("int1 ^ 3 : " + int2); // 1
        int2 = ~int1;
        System.out.println("~int1: " + int2); // -3
    }

    public static void threeOp() {
        System.out.println("삼항 연산자 : ? :");
        int int1 = 10;
        int int2 = int1 == 10 ? 20 : 30;
        System.out.println("int1 == 10 ? 20 : 30 ===> " + int2);
    }

}
