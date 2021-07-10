package com.yamdeng.reboot.java.stream;

import java.util.Arrays;
import java.util.stream.Stream;

// 스트림 생성
public class StreamCreate {

    public static void main(String[] args) {
        System.out.println("========== 스트림 생성 ==========");
        System.out.println();

        // 스트림 생성 기본
        basicCreate();
        System.out.println();

        System.out.println("========== StreamCreate End ==========");
    }

    private static void basicCreate() {
        System.out.println("스트림 생성 기본");

        // Stream.of
        Stream<String> stream = Stream.of("AAA", "BBB", "CCC", "DDD", "EEE", "FFF", "AAA", "BBB");
        stream.map(String::toLowerCase).forEach(System.out::println);

        // Stream.empty
        Stream<String> emptyStream = Stream.empty();

        // Stream.of
        Stream<String> ofStream = Stream.ofNullable(System.getenv("AAA"));

        // 배열로 스트림 만들기
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Arrays.stream(numbers).sum() : " + Arrays.stream(numbers).sum());
    }

}
