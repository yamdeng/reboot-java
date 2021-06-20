package com.yamdeng.reboot.java.basic;

import java.util.Arrays;

// 가변 변수 : 메서드
public class VariableArgument {

    public static void main(String[] args) {
        System.out.println("========== 가변 변수 : 메서드 ==========");
        System.out.println();

        // 가변 변수(배열) : int
        int[] arr ={1, 2, 3, 4, 5};
        variableArgumentTypeInt(arr);
        variableArgumentTypeInt(6, 7, 8, 9, 10);
        variableArgumentTypeInt();
        System.out.println();

        // 가변 변수(배열) : string
        variableArgumentTypeObject("안녕하세요", "hihi");

        // 가변 변수(배열) : object
        variableArgumentTypeObject(new Integer(3), new Integer(4));

        System.out.println("========== VariableArgument End ==========");
    }

    public static void variableArgumentTypeInt(int... arg) {
        System.out.println("가변 변수(배열) : int");
        System.out.println("arg : " + Arrays.toString(arg));
    }

    public static void variableArgumentTypeObject(String... arg) {
        System.out.println("가변 변수(배열) : string");
        System.out.println("arg : " + Arrays.toString(arg));
    }

    public static void variableArgumentTypeObject(Object... arg) {
        System.out.println("가변 변수(배열) : object");
        System.out.println("arg : " + Arrays.toString(arg));
    }

}
