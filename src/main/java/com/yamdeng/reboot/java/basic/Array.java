package com.yamdeng.reboot.java.basic;

import com.yamdeng.reboot.java.collection.ListFunction;

import java.util.Arrays;

// 배열 : []
public class Array {

    static class ArrayVo {
        String name;
        String key;
        String value;

        public ArrayVo(String name, String key, String value) {
            this.name = name;
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "ArrayVo{" +
                    "name='" + name + '\'' +
                    ", key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("========== 배열 : [] ==========");
        System.out.println();

        // 배열 기본
        basicArray();
        System.out.println();

        // 배열 복사
        copyArray();
        System.out.println();

        // Arrays.copyOf

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

        Integer[] arr5 = {40, 10, 20, 30};
        Arrays.sort(arr5);
        System.out.println("arr5 : " + Arrays.toString(arr5)); // [10, 20, 30, 40]
        Arrays.sort(arr5, (before, after) -> after - before);
        System.out.println("arr5 : " + Arrays.toString(arr5)); // [40, 30, 20, 10]

        ArrayVo vo1 = new ArrayVo("list1", "key1", "value1");
        ArrayVo vo2 = new ArrayVo("list2", "key2", "value2");
        ArrayVo vo3 = new ArrayVo("list3", "key3", "value3");
        ArrayVo[] voArr = {vo1, vo2, vo3};

        // 배열은 공변이므로 clone 메서드 사용시 "캐스팅" 연산자를 사용할 필요가 없음
        ArrayVo[] voArrClone = voArr.clone();
        System.out.println("voArr : " + Arrays.toString(voArr));
        voArr[0] = new ArrayVo("list1", "key1", "value1");
        System.out.println("voArr[0] == voArrClone[0] : " + (voArr[0] == voArrClone[0]));
    }

}
