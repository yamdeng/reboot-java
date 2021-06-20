package com.yamdeng.reboot.java.basic;

import java.util.Arrays;

// 배열 : []
public class Array {

    public static void main(String[] args) throws Exception {
        System.out.println("========== 배열 : [] ==========");
        System.out.println();

        // 배열 기본
        basicArray();
        System.out.println();

        // 배열 복사
        copyArray();
        System.out.println();

        System.out.println("========== Array End ==========");
    }

    public static void basicArray() {
        System.out.println("배열 기본");
        int[] arr = new int[3];
        int arrIndex=0;
        for(;arrIndex<arr.length;arrIndex++) {
            int arrValue = arr[arrIndex];
            System.out.println("arr[" + arrIndex + "] : " + arrValue); // 0
        }

        arrIndex=0;
        for(;arrIndex<arr.length;arrIndex++) {
            arr[arrIndex] = 10;
        }

        // for each
        for(int arrValue : arr) {
            System.out.println("arrValue : " + arrValue); // 10
        }

        int[] arr2 ={100, 100};
        for(int arrValue : arr2) {
            System.out.println("arrValue2 : " + arrValue); // 100
        }
        arrIndex=0;
        for(; arrIndex<arr2.length; arrIndex++){
            int arrValue = arr2[arrIndex];
            System.out.println("arr2[" + arrIndex + "] : " + arrValue); // 100
        }

        System.out.println("arr : " + arr); // [I@54a097cc
        System.out.println(Arrays.toString(arr)); // [10, 10, 10]

        char[] charArr = {'a', 'b', 'c'};
        System.out.println("charArr : " + charArr.toString()); // [I@54a097cc
        System.out.println(Arrays.toString(charArr)); // [a, b, c]
    }

    public static void copyArray() {
        System.out.println("배열 복사");
        int[] arr ={1, 2, 3, 4, 5};
        int[] arr2 = Arrays.copyOf(arr, 3);
        for(int index=0, maxLength=arr2.length; index<maxLength; index++) {
            System.out.println("arr2[" + index + "] : " + arr2[index]);
        }
        System.out.println("arr2 : " + Arrays.toString(arr2)); // [1, 2, 3]
        int[] arr3 = new int[arr.length];
        System.arraycopy(arr, 0, arr3, 0, arr.length);
        System.out.println("arr3 : " + Arrays.toString(arr3)); // [1, 2, 3, 4, 5]

        int[] arr4 ={3, 2, 1};
        Arrays.sort(arr4);
        System.out.println("arr4 : " + Arrays.toString(arr4)); // [1, 2, 3]
    }

}
