package com.yamdeng.reboot.java.collection;

import com.yamdeng.reboot.java.vo.BoardCategory;
import com.yamdeng.reboot.java.vo.BoardVo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Map.*;

// 컬렉션 팩토리 메서드
public class CollectionFactory {

    public static void main(String[] args) {
        System.out.println("========== 컬렉션 팩토리 메서드 ==========");
        System.out.println();
        
        // List 팩토리 메서드
        listFactoryMethod();
        System.out.println();
        
        // Set, Map 팩토리 메서드
        SetAndMapFactoryMethod();
        System.out.println();

        System.out.println("========== CollectionFactory End ==========");
    }

    private static void listFactoryMethod() {
        System.out.println("List 팩토리 메서드");

        // Arrays.asList
        List<String> stringList1 = Arrays.asList("AAA", "BBB");
        List<BoardVo> boardList1 = Arrays.asList(new BoardVo(), new BoardVo());
        Set<String> stringSet1 = new HashSet<>(Arrays.asList("AAA", "BBB"));
        Set<String> stringSet2 = Stream.of("AAA", "BBB").collect(Collectors.toSet());
        System.out.println("stringSet1 : " + stringSet1);
        System.out.println("stringSet2 : " + stringSet2);
//        stringList1.add("CCC"); // 오류 : UnsupportedOperationException 예외 발생
        stringSet2.add("CCC"); // 허용

        // List.of
        List<String> stringList2 = List.of("AAA", "BBB");
//        stringList2.add("DDD"); // 오류 : UnsupportedOperationException 예외 발생
        System.out.println("stringList2 : " + stringList2);
    }

    private static void SetAndMapFactoryMethod() {
        System.out.println("Set, Map 팩토리 메서드");

        // Set
        Set<String> stringSet1 = Set.of("AAA", "BBB");
//        stringSet1.add("CCC"); // 오류 : UnsupportedOperationException 예외 발생
        Set<BoardVo> boardVoSet1 = Set.of(new BoardVo());

        // Map
        Map<String, Integer> stringIntegerMap = Map.of("AAA", 10, "BBB", 20);
        Map<BoardCategory, BoardVo> boardCategoryBoardVoMap = Map.of(BoardCategory.MATH, new BoardVo(), BoardCategory.FOOD, new BoardVo());

        // Map.entry 사용
        Map<String, Integer> stringIntegerMap2 = Map.ofEntries(entry("AAA", 10), entry("BBB", 20));

    }

}
