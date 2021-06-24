package com.yamdeng.reboot.java.basic;

// 변수
public class Variable {

    public static void main(String[] args) throws Exception {
        System.out.println("========== 변수 ==========");
        System.out.println();

        // 변수 할당 및 swap
        variable();
        System.out.println();

        System.out.println("========== Variable End ==========");
    }

    public static void variable() {
        System.out.println("변수 할당 및 swap");
        int inta = 10;
        int intb = 20;
        int intc = 30;
        System.out.println("inta : " + inta); // 10
        System.out.println("intb : " + intb); // 20
        System.out.println("intc : " + intc); // 30
        intb = inta;
        intc = intb;
        System.out.println("inta : " + inta); // 10
        System.out.println("intb : " + intb); // 10
        System.out.println("intc : " + intc); // 10
    }
}
