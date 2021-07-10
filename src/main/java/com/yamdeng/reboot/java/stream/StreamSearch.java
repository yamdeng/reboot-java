package com.yamdeng.reboot.java.stream;

import com.yamdeng.reboot.java.util.YamdengCollectionUtil;
import com.yamdeng.reboot.java.vo.BoardVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 스트림 검색과 매칭
public class StreamSearch {

    public static void main(String[] args) {
        System.out.println("========== 스트림 검색과 매칭 ==========");
        System.out.println();

        // anyMatch, allMatch, noneMatch
        match();
        System.out.println();

        // findFirst, findAny
        search();
        System.out.println();

        System.out.println("========== StreamSearch ==========");
    }

    // match
    private static void match() {
        System.out.println("anyMatch, allMatch, noneMatch");
        List<BoardVo> boardList = new ArrayList<>();
        YamdengCollectionUtil.initBoardVoListStream(boardList);

        // anyMatch
        boolean anyMatchResult = boardList.stream().anyMatch((b) -> b.getTitle().equals("자바"));
        System.out.println("anyMatchResult : " + anyMatchResult);

        // allMatch
        boolean allMatchResult = boardList.stream().allMatch((b) -> !b.getTitle().equals("자바1"));
        System.out.println("allMatchResult : " + allMatchResult);

        // noneMatch
        boolean noneMatchResult = boardList.stream().noneMatch((b) -> b.getTitle().equals("자바1"));
        System.out.println("noneMatchResult : " + noneMatchResult);
    }

    // search
    private static void search() {
        System.out.println("findFirst, findAny");
        List<BoardVo> boardList = new ArrayList<>();
        YamdengCollectionUtil.initBoardVoListStream(boardList);

        // findFirst
        BoardVo firstVo = boardList.stream().findFirst().get();
        System.out.println("firstVo : " + firstVo);

        // findAny
        BoardVo anyVo = boardList.stream().findAny().get();
        System.out.println("anyVo : " + anyVo);
    }

}
