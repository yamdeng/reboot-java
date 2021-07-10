package com.yamdeng.reboot.java.stream;

import com.yamdeng.reboot.java.util.YamdengCollectionUtil;
import com.yamdeng.reboot.java.vo.BoardVo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 스트림 슬라이스
public class StreamSlice {

    public static void main(String[] args) {
        System.out.println("========== 스트림 슬라이스 ==========");
        System.out.println();

        // takeWhile : 정렬이 되어있다고 가정(정렬된 속성을 이용해야 함)
        takeWhile();
        System.out.println();
        
        // dropWhile : 정렬이 되어있다고 가정(정렬된 속성을 이용해야 함)
        dropWhile();
        System.out.println();

        // skip, limit
        skipAndLimit();
        System.out.println();


        System.out.println("========== StreamSlice End ==========");
    }

    // takeWhile : 조건에 맞을때까지만 연산 수행
    private static void takeWhile() {
        System.out.println("takeWhile");

        List<BoardVo> boardList = new ArrayList<>();
        YamdengCollectionUtil.initBoardVoListStream(boardList);
        List<String> titleList = boardList.stream().map(b -> b.getTitle()).collect(Collectors.toList());
        System.out.println("titleList all" + titleList);
//        boardList.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
//        titleList = boardList.stream().map(b -> b.getTitle()).collect(Collectors.toList());
        boardList.sort((b1, b2) -> b1.getPrice().compareTo(b2.getPrice()));
        titleList = boardList.stream().map(b -> b.getTitle()).collect(Collectors.toList());
        System.out.println("titleList price sort" + titleList);
        titleList = boardList.stream().takeWhile(b -> b.getPrice() > 1500).map(b -> b.getTitle()).collect(Collectors.toList());
        System.out.println("titleList " + titleList);
    }

    // dropWhile : 조건에 맞을때까지만 연산 수행
    private static void dropWhile() {
        System.out.println("dropWhile");

        List<BoardVo> boardList = new ArrayList<>();
        YamdengCollectionUtil.initBoardVoListStream(boardList);
        boardList.sort((b1, b2) -> b1.getPrice().compareTo(b2.getPrice()));
        List<String> titleList = boardList.stream().dropWhile(b -> b.getPrice() > 1500).map(b -> b.getTitle()).collect(Collectors.toList());
        System.out.println("titleList " + titleList);
    }

    // skip, limit : 건너띄기, 반복을 멈추기
    private static void skipAndLimit() {
        System.out.println("skipAndLimit");

        List<String> titleList = List.of("자바", "파이썬", "루비", "C#", "C++", "C", "PHP", "코틀린", "타입스크립트", "Oracle", "리눅스", "MySql", "JPA", "MyBatis", "Spring", "스칼라");
        List<String> skipTitleList = titleList.stream().skip(3).collect(Collectors.toList());
        System.out.println("skipTitleList : " + skipTitleList);
        List<String> limitTitleList = titleList.stream().limit(3).collect(Collectors.toList());
        System.out.println("limitTitleList : " + limitTitleList);
    }

}
