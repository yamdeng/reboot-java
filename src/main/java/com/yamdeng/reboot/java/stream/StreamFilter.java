package com.yamdeng.reboot.java.stream;

import com.yamdeng.reboot.java.util.YamdengCollectionUtil;
import com.yamdeng.reboot.java.vo.BoardVo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 스트림 필터
public class StreamFilter {

    public static void main(String[] args) {
        System.out.println("========== 스트림 필터 ==========");
        System.out.println();

        // filter
        filter();
        System.out.println();
        
        // distinct
        distinct();
        System.out.println();

        System.out.println("========== StreamFilter End ==========");
    }

    // filter
    private static void filter() {
        System.out.println("filter");

        List<BoardVo> boardList = new ArrayList<>();
        YamdengCollectionUtil.initBoardVoListStream(boardList);
        List<BoardVo> resultList = boardList.stream().filter(b -> b.getPrice() > 15000).collect(Collectors.toList());
        System.out.println("boardList size : " + boardList.size());
        System.out.println("resultList size : " + resultList.size());
    }

    // distinct
    private static void distinct() {
        System.out.println("distinct");

        List<String> titleList = List.of("자바", "자바", "파이썬", "파이썬", "타입스크립트");
        List<String> resultList = titleList.stream().distinct().collect(Collectors.toList());
        System.out.println("titleList size : " + titleList.size());
        System.out.println("resultList size : " + resultList.size());
    }

}
