package com.yamdeng.reboot.java.stream;

import com.yamdeng.reboot.java.util.YamdengCollectionUtil;
import com.yamdeng.reboot.java.vo.BoardVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 스트림 리듀싱
public class StreamReduce {

    public static void main(String[] args) {
        System.out.println("========== 스트림 리듀싱 ==========");
        System.out.println();

        // reduce
        reduce();
        System.out.println();

        System.out.println("========== StreamReduce End ==========");
    }

    // reduce
    private static void reduce() {
        System.out.println("reduce");
        List<BoardVo> boardList = new ArrayList<>();
        YamdengCollectionUtil.initBoardVoListStream(boardList);
        List<Integer> priceList = boardList.stream().map(b -> b.getPrice()).collect(Collectors.toList());
        int sum = priceList.stream().reduce(0, (i1, i2) -> i1.intValue() + i2.intValue());
        System.out.println("sum : " + sum);
        sum = priceList.stream().reduce((i1, i2) -> i1.intValue() + i2.intValue()).get();
        System.out.println("sum : " + sum);

        int max = priceList.stream().reduce((a, b) -> a >= b ? a : b).get();
        int min = priceList.stream().reduce((a, b) -> a <= b ? a : b).get();
        System.out.println("max : " + max);
        System.out.println("min : " + min);
    }

}
