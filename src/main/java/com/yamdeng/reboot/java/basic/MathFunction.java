package com.yamdeng.reboot.java.basic;

// Math 정적 메서드
public class MathFunction {

    public static void main(String[] args) {
        System.out.println("========== Math 정적 메서드 ==========");
        System.out.println();

        // Math 정적 메서드
        mathStaticMethod();
        System.out.println();

        System.out.println("========== MathFunction End ==========");
    }

    private static void mathStaticMethod() {
        System.out.println("Math 정적 메서드");

        int absValue = Math.abs(-20);
        System.out.println("Math.abs : " + absValue);

        long roundValue = Math.round(10.5777);
        System.out.println("roundValue : " + roundValue);

        double rintValue = Math.rint(10.5777);
        System.out.println("rintValue : " + rintValue);
    }
}
