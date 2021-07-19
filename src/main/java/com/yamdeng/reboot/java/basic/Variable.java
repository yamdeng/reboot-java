package com.yamdeng.reboot.java.basic;

// 변수
public class Variable {

    public static void main(String[] args) throws Exception {
        System.out.println("========== 변수 ==========");
        System.out.println();

        // 변수 할당 및 swap
        variable();
        System.out.println();

        // block 문에서 변수 범위 체크
        blockStatementVariable();
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

    private static void blockStatementVariable() {
        System.out.println("block 문에서 변수 범위 체크");

        int out1 = 10;
        {
            int inner1 = 20;
            {
                int inner2 = 30;
            }
//            System.out.println("inner2 : " + inner2); // 오류
            System.out.println("out1 : " + out1);
            System.out.println("inner1 : " + inner1);
        }
    }
}
