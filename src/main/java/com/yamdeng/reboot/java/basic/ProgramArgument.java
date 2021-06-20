package com.yamdeng.reboot.java.basic;

import java.util.Arrays;

// 프로그램 아규먼트 전달
public class ProgramArgument {

    public static void main(String[] args) throws Exception {
        System.out.println("========== 프로그램 아규먼트 전달 ==========");
        System.out.println();

        // 프로그램 아규먼트
        argument(args);
        System.out.println();

        System.out.println("========== ProgramArgument End ==========");
    }

    public static void argument(String[] programArgument) {
        System.out.println("프로그램 아규먼트");
        System.out.println("programArgument : " + Arrays.toString(programArgument));
    }

}
