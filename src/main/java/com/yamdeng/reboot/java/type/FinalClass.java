package com.yamdeng.reboot.java.type;

class Parent3 {

    public void method1() {
    }

}

// Parent3 가 final 클래스라면 상속(extends) 받을 수 없음
class Child4 extends Parent3 {
    
    // method1 메서드가 final로 정의되어있으면 정의할 수 없음
    @Override
    public void method1() {

    }
}

// final class, method
public class FinalClass {

    public static void main(String[] args) {
        System.out.println("========== final class, method ==========");
        System.out.println();

        System.out.println("========== FinalClass End ==========");
    }
    
}
