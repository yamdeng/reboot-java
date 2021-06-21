package com.yamdeng.reboot.java.basic;

/*

    1.Boolean
    2.Character
    3.Number
     -Float, BigDecimal, AtomicLong, Long, Double, AtomicInteger, Short, BigInteger, Byte, Striped64, Integer

    WrapperClass.valueOf로 객채 생성
    수가 측정 가능한 값인지 여부, MAX/MIN 값 제공

 */

// 래퍼 클래스
public class Wrapper {

    public static void main(String[] args) {
        System.out.println("========== 래퍼 클래스 ==========");
        System.out.println();

        // 래퍼 클래스 기본
        basicWrapper();
        System.out.println();
        
        // 오토박싱 / 언박싱
        autoBoxing();
        System.out.println();

        System.out.println("========== Wrapper End ==========");
    }

    private static void basicWrapper() {
        System.out.println("래퍼 클래스 기본");

        Boolean boolean1 = new Boolean(true);
        Boolean boolean2 = new Boolean("true");
        Boolean boolean3 = Boolean.valueOf(true);
        Boolean boolean4 = Boolean.valueOf("true");
        System.out.println("boolean1 : " + boolean1);
        System.out.println("boolean2 : " + boolean2.booleanValue());
        System.out.println("boolean3 : " + boolean3);
        System.out.println("boolean4 : " + boolean4);

        Character character = Character.valueOf('a');
        System.out.println("character : " + character.charValue());

        Integer integer1 = Integer.parseInt("100");
        Integer integer2 = Integer.valueOf("100");
        Integer integer3 = Integer.valueOf(100);
        System.out.println("integer1 : " + integer1);
        System.out.println("integer2 : " + integer2);
        System.out.println("integer3 : " + integer3);

        System.out.println("Integer.MAX_VALUE : " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE : " + Integer.MIN_VALUE);

        System.out.println("Double.NEGATIVE_INFINITY : " + Double.NEGATIVE_INFINITY);
        System.out.println("Double.POSITIVE_INFINITY : " + Double.POSITIVE_INFINITY);

        System.out.println("Double.isFinite() : " + Double.isFinite(10));
        System.out.println("Double.isInfinite() : " + Double.isInfinite(10));

    }

    private static void autoBoxing() {
        System.out.println("오토박싱 / 언박싱");
        
        // 오토박싱
        Integer int1 = 10;
        
        // 언박싱
        int int2 = Integer.valueOf(20);

        System.out.println("int1 : " + int1);
        System.out.println("int2 : " + int2);
    }
}
