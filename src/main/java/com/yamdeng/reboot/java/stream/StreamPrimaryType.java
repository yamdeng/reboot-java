package com.yamdeng.reboot.java.stream;

import com.yamdeng.reboot.java.util.YamdengCollectionUtil;
import com.yamdeng.reboot.java.vo.BoardVo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

// 기본형 특화 스트림
public class StreamPrimaryType {

    public static void main(String[] args) {
        System.out.println("========== 기본형 특화 스트림 ==========");
        System.out.println();

        // 기본형 특화 스트림
        primaryStreamMethod();
        System.out.println();

        // range
        range();

        System.out.println("========== StreamPrimaryType End ==========");
    }

    // reduce
    private static void primaryStreamMethod() {
        System.out.println("기본형 특화 스트림");
        List<BoardVo> boardList = new ArrayList<>();
        YamdengCollectionUtil.initBoardVoListStream(boardList);

        // mapToInt 메서드는 Stream<Integer>가 아닌 IntStream을 반환 한다. 기본 특화 스트림을 빠른 최종 연산을 지원한다
        long priceSum = boardList.stream().mapToInt(b -> b.getPrice()).sum();
        double priceAvg = boardList.stream().mapToInt(b -> b.getPrice()).average().getAsDouble();
        long priceMax = boardList.stream().mapToInt(b -> b.getPrice()).max().getAsInt();
        long priceMin = boardList.stream().mapToInt(b -> b.getPrice()).min().getAsInt();
        System.out.println("priceSum : " + priceSum);
        System.out.println("priceAvg : " + priceAvg);
        System.out.println("priceMax : " + priceMax);
        System.out.println("priceMin : " + priceMin);
    }
    
    // range
    private static void range() {

        // rangeClosed
        LongStream longStream = LongStream.rangeClosed(1, 100);
        long sum = longStream.sum();
        System.out.println("sum : " + sum);

        longStream = LongStream.range(1, 100);
        sum = longStream.sum();
        System.out.println("sum : " + sum);
    }

}
