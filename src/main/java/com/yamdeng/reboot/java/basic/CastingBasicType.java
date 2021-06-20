package com.yamdeng.reboot.java.basic;

// 캐스팅(형변환) 기본 타입
public class CastingBasicType {

    public static void main(String[] args) throws Exception {
        System.out.println("========== 캐스팅(형변환) 기본 타입 ==========");
        System.out.println();

        // 기본 타입 캐스팅
        casting();
        System.out.println();

        System.out.println("========== CastingBasicType End ==========");
    }

    public static void casting() {
        System.out.println("기본 타입 캐스팅");
        int int1 = 130;
        byte byte1 = (byte) int1; // byte의 범위를 넘어서도 순환한다
        System.out.println("byte1 : " + byte1);
        float float1 = int1 + 0.1f; // float 타입이 int 타입보다 큰 타입이다
        byte1 = (byte) float1; // 형변환시 실수형, 정수형 타입을 가리지 않는다. 실수에서 정수로 변환시 소수점 부분은 자동적으로 버려지게 된다
        System.out.println("byte1 : " + byte1);
    }
}
