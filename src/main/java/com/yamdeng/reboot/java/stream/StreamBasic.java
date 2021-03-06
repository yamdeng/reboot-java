package com.yamdeng.reboot.java.stream;

import com.yamdeng.reboot.java.util.YamdengCollectionUtil;
import com.yamdeng.reboot.java.vo.BoardVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import static java.util.Comparator.comparing;

// 스트림 기본
public class StreamBasic {

    public static void main(String[] args) {
        System.out.println("========== 스트림 기본 ==========");
        System.out.println();

        // list ---> 스트림
        listToStream();
        System.out.println();

        // array ---> 스트림
        arrayToStream();
        System.out.println();

        // 스트림 중간에 값 확인 : peek
        peek();
        System.out.println();

        System.out.println("========== StreamBasic End ==========");
    }

    // filter, sorted, map, forEach, collect, count, peek
    private static void listToStream() {
        System.out.println("list ---> 스트림");
        List<BoardVo> boardList = new ArrayList<>();
        YamdengCollectionUtil.initBoardVoListStream(boardList);
        System.out.println("before size : " + boardList.size());
        List<BoardVo> resultList = boardList.stream().filter(board -> board.getTitle().equals("자바")).collect(Collectors.toList());
        System.out.println("after size : " + boardList.size());
        System.out.println("resultList : " + resultList);

        List<String> boardTitleList = boardList.stream().sorted(comparing(BoardVo::getSeq).reversed()).map(BoardVo::getTitle).collect(Collectors.toList());
        System.out.println("boardTitleList : " + boardTitleList);
        boardTitleList.stream().forEach(title -> System.out.println("title : " + title));
        List<String> listApplyTitleList = boardTitleList.stream().limit(3).collect(Collectors.toList());
        System.out.println("listApplyTitleList : " + listApplyTitleList);

        // count
        long listApplyTitleListCount = listApplyTitleList.stream().count();
        System.out.println("listApplyTitleListCount : " + listApplyTitleListCount);
    }

    private static void arrayToStream() {
        System.out.println("array ---> 스트림");

        BoardVo[] boardVoArray = new BoardVo[300];
        YamdengCollectionUtil.initBoardVoListArray(boardVoArray);

        System.out.println("before size : " + boardVoArray.length);
        Object[] resultArray = Arrays.stream(boardVoArray).filter(board -> board.getTitle().equals("자바")).toArray();
        System.out.println("after size : " + resultArray.length);
    }

    private static void peek() {
        System.out.println("스트림 중간에 값 확인 : peek");
        List<BoardVo> boardList = new ArrayList<>();
        YamdengCollectionUtil.initBoardVoListStream(boardList);

        // peek 메서드는 다른 스레드에서 실행되므로 언제 실행될지 알 수 없음
        boardList.stream().limit(10).peek(System.out::println).filter(b -> b.getPrice() > 5000).forEach(b -> {
            System.out.println("after b : " + b);
        });
    }

}
