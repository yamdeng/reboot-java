package com.yamdeng.reboot.java.stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 스트림 생성
public class StreamCreate {

    public static void main(String[] args) {
        System.out.println("========== 스트림 생성 ==========");
        System.out.println();

        // 스트림 생성 기본
        basicCreate();
        System.out.println();

        // Stream.iterate 메서드로 무한 스트림 생성
        iterate();
        System.out.println();

        // Stream.generate 메서드로 무한 스트림 생성
        generate();
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

        // Stream.ofNullable
        Stream<String> ofStream = Stream.ofNullable(System.getenv("AAA"));

        // 배열로 스트림 만들기
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Arrays.stream(numbers).sum() : " + Arrays.stream(numbers).sum());
    }

    private static void iterate() {
        System.out.println("Stream.iterate 메서드로 무한 스트림 생성");

        // Stream.iterate : 기본
        long sum = Stream.iterate(0, n -> n+2)
                    .limit(9)
                .reduce(0, (n1, n2) -> n1+ n2);
        System.out.println("iterate sum : " + sum);

        // Stream.iterate : int[] 예시
        Stream.iterate(new int[]{1, 2}, t -> new int[]{t[1], t[0] + t[1]}).limit(10).forEach(
                t -> System.out.println("int[] sum : " + (t[0] + t[1]))
        );

        // Stream.iterate : predicate 예시
        Stream.iterate(0, n -> n < 10, n -> n+2).forEach(System.out::println);

        // Stream.terate : takeWhile 예시
        Stream.iterate(0, n -> n +2).takeWhile(n -> n < 10)
                .forEach(System.out::println);
    }

    private static void generate() {
        System.out.println("Stream.generate 메서드로 무한 스트림 생성");

        // Stream.generate
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

}
