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

// 숫자 연산
public class NumberOverflow {

    public static void main(String[] args) throws Exception {
        System.out.println("========== 숫자 연산 ==========");
        System.out.println();

        // 오버플로우 / 언더플로우
        overflow();
        System.out.println();

        System.out.println("========== NumberTypeOperator End ==========");
    }

    public static void overflow() {
        /*

            정수관련 연산시 범위를 벗어나면 순환되게 된다(overflow시) : char 타입은 음수가 없기때문에 최대치가 넘어가면 0부터 다시 시작하게 된다
            실수형 언더플로우시 변수의 값은 0이 된다(0.0)
            실수형은 오버플로우시 무한대(Infinity)가 된다. 각각 Float.isInfinite, Double.isInfinite 로 무한대 여부를 체크한다

         */

        System.out.println("오버플로우 / 언더플로우");
        byte byte1 = 127;
        int int1 = 2147483647;
        char char1 = 65535;
        long long1 = 9223372036854775807L;
        System.out.println("byte1 : " + byte1); // 127
        System.out.println("int1 : " + int1); // 2147483647
        System.out.println("char1 : " + char1); // ￿
        System.out.println("long1 : " + long1); // 9223372036854775807
        
        // byte1 최대치 넘어가게
        byte1++;
        byte1++;
        byte1++;
        
        // int1 최대치 넘어가게
        int1 = int1 + 10;

        // char1 최대치 넘어가게 +66
        for(int index=0; index<66; index++) {
            char1++;
        }
        
        // long1 최대치 넘어가게
        long1++;
        System.out.println("byte1 : " + byte1); // -126
        System.out.println("int1 : " + int1); // -2147483639
        System.out.println("char1 : " + char1); // A
        System.out.println("long1 : " + long1); // -9223372036854775808
        
        // 실수형 오버플로우, 언더플로우
        float float1 = Float.MAX_VALUE + Float.MAX_VALUE;
        float float2 = Float.MIN_VALUE - Float.MIN_VALUE;
        System.out.println("float1 : " + float1); // Infinity
        System.out.println("float1 isInfinite : " + Float.isInfinite(float1)); // true
        System.out.println("float2 isInfinite : " + Float.isInfinite(float2)); // false
        System.out.println("float2 : " + float2); // 0.0

        double double1 = Double.MAX_VALUE + Double.MAX_VALUE;
        double double2 = Double.MIN_VALUE - Double.MIN_VALUE;
        System.out.println("double1 : " + double1); // Infinity
        System.out.println("double2 : " + double2); // 0.0
        System.out.println("double1 isInfinite : " + Double.isInfinite(double1)); // true
        System.out.println("double2 isInfinite : " + Double.isInfinite(double2)); // false
    }



}
