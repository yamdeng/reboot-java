package com.yamdeng.reboot.java.collection;

import com.yamdeng.reboot.java.util.YamdengCollectionUtil;

import java.util.*;

// of 팩토리 메서드, Collections static method
public class CollectionsFunction {

    public static void main(String[] args) {
        System.out.println("========== of 팩토리 메서드, Collections static method ==========");
        System.out.println();

        // of 팩토리 메서드
        factoryMethod();
        System.out.println();

        // Collections static method
        collectionsMethod();
        System.out.println();

        System.out.println("========== CollectionsFunction End ==========");
    }

    private static void factoryMethod() {
        System.out.println("of 팩토리 메서드");
        List<Object> objectList = List.of("AAA", new Integer(10));
        System.out.println("objectList : " + objectList);

        List<String> stringList = List.of("AAA", "BBB", "CCC");
        System.out.println("stringList : " + stringList);

        Set<String> stringSet = Set.of("AAA", "BBB");
        System.out.println("stringSet : " + stringSet);

        Map<String, String> stringMap = Map.of("AAA", "AAA-value", "BBB", "BBB-value");
        YamdengCollectionUtil.mapToString(stringMap, "stringMap");
    }

    // addAll, sort, binarySearch,
    private static void collectionsMethod() {
        System.out.println("Collections static method");
        List<String> stringList = new ArrayList<>();
        List<String> stringList2 = new ArrayList<>();
        YamdengCollectionUtil.initStringList(stringList);
        YamdengCollectionUtil.initStringList(stringList2);
        List<Integer> integerList = new ArrayList<>();
        YamdengCollectionUtil.initIntegerList(integerList);

        // addAll
        System.out.println("addAll before stringList " + stringList);
        Collections.addAll(stringList, "AAA", "BBB");
        System.out.println("addAll after stringList " + stringList);

        // sort, reverseOrder
        Collections.sort(stringList);
        System.out.println("sort after stringList " + stringList);
        Collections.sort(stringList, Collections.reverseOrder());
        System.out.println("reverseOrder after stringList " + stringList);

        // binarySearch
        Collections.sort(stringList);
        System.out.println("before binarySearch " + stringList);
        int searchIndex = Collections.binarySearch(stringList, "CCC");
        System.out.println("searchIndex : " + searchIndex);

        // max, min
        String maxValue = Collections.max(stringList);
        System.out.println("maxValue : " + maxValue);
        String minValue = Collections.min(stringList);
        System.out.println("minValue : " + minValue);

        // emptyList
        List<String> emptyList = Collections.emptyList();

        // fill
        Collections.fill(stringList, "KOREA");
        System.out.println("stringList : " + stringList);
    }

}
