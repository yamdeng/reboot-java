package com.yamdeng.reboot.java.stream;

import com.yamdeng.reboot.java.util.YamdengCollectionUtil;
import com.yamdeng.reboot.java.vo.BoardCategory;
import com.yamdeng.reboot.java.vo.BoardPublish;
import com.yamdeng.reboot.java.vo.BoardVo;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;


// 스트림 Collector
public class StreamCollector {

    public static void main(String[] args) {
        System.out.println("========== 스트림 Collector ==========");
        System.out.println();

        // 리듀싱과 요약
        reducingAndSummarize();
        System.out.println();

        // 문자열 연결
        stringJoin();
        System.out.println();

        // 리듀싱 요약 연산
        reducingCollector();
        System.out.println();

        // 그룹화
        grouping();
        System.out.println();

        // 분할
        partition();
        System.out.println();

        System.out.println("========== StreamCollector End ==========");
    }

    private static void reducingAndSummarize() {
        System.out.println("리듀싱과 요약");

        List<String> stringList = List.of("AAA", "BBB", "CCC");

        // count
        System.out.println("stringList.stream().count() : " + stringList.stream().count());
        System.out.println("stringList.stream().collect(Collectors.counting()) : " + stringList.stream().collect(Collectors.counting()));

        // maxBy, minBy
        List<BoardVo> boardList = new ArrayList<>();
        YamdengCollectionUtil.initBoardVoListStream(boardList);
        Optional<BoardVo> maxBoardOptional = boardList.stream().collect(Collectors.maxBy(comparing(BoardVo::getPrice)));
        System.out.println("maxBoardOptional : " + maxBoardOptional.get());
        Optional<BoardVo> minBoardOptional = boardList.stream().collect(Collectors.minBy((b1, b2) -> b1.getPrice().compareTo(b2.getPrice())));
        System.out.println("minBoardOptional : " + minBoardOptional.get());

        // summingInt : Int, Long, Doube
        long priceSum = boardList.stream().collect(Collectors.summingLong(BoardVo::getPrice));
        System.out.println("priceSum : " + priceSum);

        // averagingLong : Int, Long, Double
        double priceAvg = boardList.stream().collect(Collectors.averagingLong(BoardVo::getPrice));
        System.out.println("priceAvg : " + priceAvg);

        // summarizingInt : Int, Long, Double ===> count, sum, min, max, average 종합적으로 추출해 줌
        IntSummaryStatistics intSummaryStatistics = boardList.stream().collect(Collectors.summarizingInt(BoardVo::getPrice));
        System.out.println("intSummaryStatistics : " + intSummaryStatistics);
    }

    private static void stringJoin() {
        System.out.println("문자열 연결");

        List<BoardVo> boardList = new ArrayList<>();
        YamdengCollectionUtil.initBoardVoListStream(boardList);

        String joinStr1 = boardList.stream().limit(5).map(BoardVo::getTitle).collect(Collectors.joining(" : "));
        System.out.println("joinStr1 : " + joinStr1);

//        String joinStr2 = boardList.stream().limit(5).map(BoardVo::getPrice).collect(Collectors.joining()); // 오류 : Stream<String>만 joining 메서드를 사용할 수 있음
    }

    private static void reducingCollector() {
        System.out.println("리듀싱 요약 연산");
        List<BoardVo> boardList = new ArrayList<>();
        YamdengCollectionUtil.initBoardVoListStream(boardList);

        // sum
        int reducingSum = boardList.stream().limit(5).map(BoardVo::getPrice)
                .collect(Collectors.reducing(1, (b1, b2) -> b1 + b2));
        System.out.println("reducingSum : " + reducingSum);

        int reducingSum2 = boardList.stream().collect(Collectors.reducing(0, BoardVo::getPrice, (b1, b2) -> b1 + b2));
        System.out.println("reducingSum2 : " + reducingSum2);

        int reducingSum3 = boardList.stream().collect(Collectors.reducing(0, BoardVo::getPrice, Integer::sum));
        System.out.println("reducingSum3 : " + reducingSum3);

        // max price
        Optional<Integer> maxOptInt = boardList.stream().map(BoardVo::getPrice)
                .collect(Collectors.reducing((b1, b2) -> b1 > b2 ? b1 : b2));
        System.out.println("reducing max : " + maxOptInt.get());

        Optional<Integer> maxOptInt2 = boardList.stream().map(BoardVo::getPrice)
                .collect(Collectors.reducing((b1, b2) -> b1.compareTo(b2) > 0 ? b1.intValue() : b2.intValue()));
        System.out.println("reducing max2 : " + maxOptInt2.get());

        // min price
        Optional<Integer> minOptInt = boardList.stream().map(BoardVo::getPrice)
                .collect(Collectors.reducing((b1, b2) -> b1 < b2 ? b1 : b2));
        System.out.println("reducing min : " + minOptInt.get());

        // max BoardVo
        Optional<BoardVo> maxBoardOptional = boardList.stream()
                .collect(Collectors.reducing((b1, b2) -> b1.getPrice().compareTo(b2.getPrice()) > 0 ? b1 : b2));
        System.out.println("maxBoardOptional : " + maxBoardOptional.get());
    }

    private static void grouping() {
        System.out.println("그룹화");

        List<BoardVo> boardList = new ArrayList<>();
        YamdengCollectionUtil.initBoardVoListStream(boardList);
        
        // BoardCategory로 그룹핑
        Map<BoardCategory, List<BoardVo>> groupingMap = boardList.stream().collect(Collectors.groupingBy(BoardVo::getBoardCategory));
        System.out.println("groupingMap : " + groupingMap);
        List<BoardVo> mathBoardList = groupingMap.get(BoardCategory.MATH);
        System.out.println("mathBoardList : " + mathBoardList);
        
        // Integer로 그룹핑
        Map<Integer, List<BoardVo>> integerGroupingMap = boardList.stream().limit(10)
                .collect(Collectors.groupingBy((boardVo) -> {
            if(boardVo.getPrice() > 10000) {
                return 1;
            } else {
                return 0;
            }
        }));
        System.out.println("integerGroupingMap.get(1) : " + integerGroupingMap.get(1));
        System.out.println("integerGroupingMap.get(Integer.valueOf(0)) : " + integerGroupingMap.get(Integer.valueOf(0)));

        // groupingBy 안에서 filtering 사용
        Map<BoardCategory, List<BoardVo>> filterVoMap = boardList.stream()
                .collect(Collectors.groupingBy(BoardVo::getBoardCategory, Collectors.filtering(b1 -> b1.getPrice() > 25000, Collectors.toList())));
        List<BoardVo> filterVoList = filterVoMap.get(BoardCategory.FOOD);
        System.out.println("filterVoList : " + filterVoList);

        // groupingBy 안에서 mapping 사용
        Map<BoardCategory, List<String>> mappingVoMap =
                boardList.stream()
                        .collect(Collectors.groupingBy(BoardVo::getBoardCategory, mapping(BoardVo::getTitle, Collectors.toList())));
        List<String> titleList = mappingVoMap.get(BoardCategory.FOOD);
        System.out.println("titleList : " + titleList);

        // groupingBy 안에서 커스텀 mapping 사용
        Map<BoardCategory, Set<Boolean>> boardBooleanMap = boardList.stream().collect(groupingBy(BoardVo::getBoardCategory,
                mapping(b -> {
                    if(b.getPrice() > 2000) {
                        return true;
                    } else {
                        return false;
                    }
                }, toSet())));
        System.out.println("boardBooleanMap : " + boardBooleanMap);

        Map<BoardCategory, Set<Boolean>> boardBooleanMap2 = boardList.stream().collect(groupingBy(BoardVo::getBoardCategory,
                mapping(b -> {
                    if(b.getPrice() > 2000) {
                        return true;
                    } else {
                        return false;
                    }
                }, Collectors.toCollection(HashSet::new))));
        System.out.println("boardBooleanMap2 : " + boardBooleanMap2);

        // groupingBy 안에서 flatMapping 사용 : TODO
//        boardList.stream().collect(groupingBy(BoardVo::getBoardCategory, flatMapping(boardVo -> boardVo.getTitle(). ));

        // 중첩 groupingBy
        Map<BoardCategory, Map<BoardPublish, List<BoardVo>>> map = boardList.stream().limit(1000)
                .collect(groupingBy(BoardVo::getBoardCategory, groupingBy(BoardVo::getBoardPublish)));
        Map<BoardPublish, List<BoardVo>> publishMap = map.get(BoardCategory.FOOD);
        List<BoardVo> publishBoardList = publishMap.get(BoardPublish.MAJOR);
        System.out.println("publishBoardList : " + publishBoardList);

        // groupingBy + counting
        Map<BoardCategory, Long> categoryGroupingCount = boardList.stream().collect(groupingBy(BoardVo::getBoardCategory, counting()));
        System.out.println("categoryGroupingCount : " + categoryGroupingCount);

        // groupingBy + maxBy
        Map<BoardCategory, Optional<BoardVo>> maxBoardVoMap = boardList.stream()
                .collect(groupingBy(BoardVo::getBoardCategory, maxBy(comparingInt(BoardVo::getPrice))));
        Set<BoardCategory> boardCategorySet = maxBoardVoMap.keySet();
        for (BoardCategory boardCategory : boardCategorySet) {
            System.out.println("maxBoardVoMap.get(boardCategory).get() : " + maxBoardVoMap.get(boardCategory).get());
        }

        // groupingBy + maxBy + collectingAndThen + comparingInt
        Map<BoardCategory, BoardVo> minBoardVoMap = boardList.stream()
                .collect(groupingBy(BoardVo::getBoardCategory, collectingAndThen(minBy(comparingInt(BoardVo::getPrice)), Optional::get)));
        Set<BoardCategory> minBoardCategorySet = minBoardVoMap.keySet();
        for (BoardCategory boardCategory : minBoardCategorySet) {
            System.out.println("minBoardVoMap.get(boardCategory).get() : " + minBoardVoMap.get(boardCategory));
        }

        // groupingBy + summingInt
        Map<BoardCategory, Integer> categorySumMap = boardList.stream()
                .collect(groupingBy(BoardVo::getBoardCategory, Collectors.summingInt(BoardVo::getPrice)));
        System.out.println("categorySumMap : " + categorySumMap);
    }

    private static void partition() {
        System.out.println("분할");

        List<BoardVo> boardList = new ArrayList<>();
        YamdengCollectionUtil.initBoardVoListStream(boardList);
        Map<Boolean, List<BoardVo>> partitionBasicMap = boardList.stream().limit(10)
                .collect(partitioningBy(BoardVo::getNew));

        List<BoardVo> trueList = partitionBasicMap.get(true);
        List<BoardVo> falseList = partitionBasicMap.get(false);
        System.out.println("tureList : " + trueList);
        System.out.println("falseList : " + falseList);
        
        // filter로도 같은 결과를 추출할 수 있음
        List<BoardVo> sameTrueList = boardList.stream().limit(10).filter(b -> b.getNew()).collect(toList());
        System.out.println("sameTrueList : " + sameTrueList);

        // groupBy도 똑같게 할 수 있음
        Map<Boolean, List<BoardVo>> groupByBooleanMap = boardList.stream().limit(10)
                .collect(groupingBy(BoardVo::getNew));
        System.out.println("tureList : " + groupByBooleanMap.get(true));
        System.out.println("falseList : " + groupByBooleanMap.get(false));

        // 중첩 partitioningBy
        Map<Boolean, Map<Boolean, List<BoardVo>>> partitionBasicMap2 = boardList.stream().limit(30)
                .collect(partitioningBy(BoardVo::getNew, partitioningBy(b -> b.getPrice() > 20000)));
        System.out.println("partitionBasicMap2 : " + partitionBasicMap2);

    }

}
