package com.yamdeng.reboot.java.type;

// 캐스팅(형변환) 참조 타입
public class CastingReferenceType {

    public static void main(String[] args) {
        System.out.println("========== 캐스팅(형변환) 참조 타입 ==========");
        System.out.println();

        // 기본 타입 캐스팅
        casting();
        System.out.println();

        System.out.println("========== CastingReferenceType End ==========");
    }

    public static void casting() {
        System.out.println("기본 타입 캐스팅");
        Parent parent = new Child("Child1", 30);
        Parent parent2 = new Child("Child2", 30);
        Child child = (Child) parent2;
        System.out.println("parent : " + parent);
        System.out.println("parent2 : " + parent2);
        System.out.println("child : " + child);
    }

}
