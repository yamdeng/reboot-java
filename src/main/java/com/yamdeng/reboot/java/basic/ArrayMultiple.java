package com.yamdeng.reboot.java.basic;


/*

    다차원배열의 선언
     -타입[][] 변수이름;
     -타입 변수이름[][];
     -타입[] 변수이름[];

    다차원배열의 선언과 초기화
     -int[][] arr = new int[5][10];
     -int[][] arr = new int[][]{ {1,2,3,}, {4,5,6} };
     -int[][] arr = { {1,2,3,}, {4,5,6} };

    가변배열 선언방법
     -int[][] arr = new int[5][];

 */

import java.util.Arrays;

// N차원 배열 : [][]
public class ArrayMultiple {

    public static void main(String[] args) throws Exception {
        System.out.println("========== N차원 배열 : [][] ==========");
        System.out.println();

        // 다차원 배열
        basicMultipleArray();
        System.out.println();

        // 가변 다차원 배열
        variableMultipleArray();
        System.out.println();

        System.out.println("========== ArrayMultiple End ==========");
    }

    public static void basicMultipleArray() {
        System.out.println("다차원 배열");
        int[][] arr = new int[2][2];
        for(int outerIndex=0, outerMaxIndex=arr.length; outerIndex<outerMaxIndex; outerIndex++){
            int[] outerArr = arr[outerIndex];
            for(int innerIndex=0, innerMaxIndex=outerArr.length; innerIndex<innerMaxIndex; innerIndex++) {
                outerArr[innerIndex] = 10;
            }
        }
        System.out.println("arr : " + Arrays.deepToString(arr)); // [[10, 10], [10, 10]]

        int[][] arr2 = { {1,2,3,}, {4,5,6} };
        System.out.println("arr2 : " + Arrays.deepToString(arr2)); // [[1, 2, 3], [4, 5, 6]]
    }

    public static void variableMultipleArray() {
        System.out.println("가변 다차원 배열");
        int[][] arr = new int[3][];
        for(int outerIndex=0, outerMaxIndex=arr.length; outerIndex<outerMaxIndex; outerIndex++){
            arr[outerIndex] = new int[3];
            for(int innerIndex=0, innerMaxIndex=arr[outerIndex].length; innerIndex<innerMaxIndex; innerIndex++) {
                arr[outerIndex][innerIndex] = 2;
            }
        }
        System.out.println("arr : " + Arrays.deepToString(arr)); // [[2, 2, 2], [2, 2, 2], [2, 2, 2]]
    }

}
