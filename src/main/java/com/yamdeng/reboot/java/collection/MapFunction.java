package com.yamdeng.reboot.java.collection;

import com.yamdeng.reboot.java.util.YamdengCollectionUtil;
import com.yamdeng.reboot.java.vo.BoardVo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

// Map 인터페이스
public class MapFunction {

    public static void main(String[] args) {
        System.out.println("========== Map 인터페이스 ==========");
        System.out.println();

        // hashMapFunction
        hashMapFunction();
        System.out.println();

        // 신규 Map 메서드
        newMapFunction();
        System.out.println();

        // TreeMap
        treeMap();
        System.out.println();

        // 맵 정렬
        mapSort();
        System.out.println();

        // ConcurrentHashMap
        concurrentHashMap();
        System.out.println();

        System.out.println("========== MapFunction End ==========");
    }

    // put, get, entrySet, keySet, values, containsKey, containsValue
    private static void hashMapFunction() {
        System.out.println("hashMapFunction");

        // put, get
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("AAA", "AAA-value");
        stringMap.put("BBB", "BBB-value");
        stringMap.put("CCC", "CCC-value");

        System.out.println("stringMap.get(\"BBB\") : " + stringMap.get("BBB"));
        System.out.println("stringMap.get(\"BBB2\") : " + stringMap.get("BBB2"));

        // iterator
        Set<Map.Entry<String, String>> entrySet = stringMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key : " + key + ", value: " + value);
        }
        YamdengCollectionUtil.iteratorToString(entrySet, "stringMap");

        // keySet
        Set<String> keySet = stringMap.keySet();
        for(String key : keySet) {
            System.out.println("key : " + key + ", value: " + stringMap.get(key));
        }
        YamdengCollectionUtil.iteratorToString(keySet, "keySet");

        // values
        Collection<String> valueList = stringMap.values();
        YamdengCollectionUtil.iteratorToString(valueList, "valueList");

        // containsKey, containsValue
        System.out.println("stringMap.containsKey(\"AAA\") : " + stringMap.containsKey("AAA"));
        System.out.println("stringMap.containsValue(\"AAA\") : " + stringMap.containsValue("AAA"));
    }

    // forEach, getOrDefault, replace, replaceAll, compute, computeIfAbsent, computeIfPresent, merge
    private static void newMapFunction() {
        System.out.println("신규 Map 메서드");
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("AAA", "AAA-value");
        stringMap.put("AAA-1", "AAA-value1");
        stringMap.put("AAA-2", "AAA-value2");
        stringMap.put("BBB", "BBB-value");
        stringMap.put("BBB1", "BBB-value1");
        stringMap.put("CCC", "CCC-value");
        stringMap.put("ZZZ", "ZZZ-value");
        stringMap.put("REMOVE", "REMOVE-value");
        stringMap.remove("REMOVE");

        // forEach
        System.out.println("map.forEach");
        stringMap.forEach((key, value) -> {
            System.out.println("key : " + key + ", value : " + value);
        });

        // getOrDefault
        String defaultValue = stringMap.getOrDefault("AAA222", "Default-AAA");
        System.out.println("defaultValue : " + defaultValue);

        // replace
        YamdengCollectionUtil.mapToString(stringMap, "stringMap");
        stringMap.replace("000", "000-value");
        stringMap.put("AAA", "AAA-value aaaa");
        stringMap.replace("AAA", "AAA-value bbb");
        YamdengCollectionUtil.mapToString(stringMap, "replace after stringMap");

        // replaceAll
        stringMap.replaceAll((key, oldValue) -> {
            if(key.startsWith("A")) {
                return "GOOD";
            }
            return oldValue;
        });
        YamdengCollectionUtil.mapToString(stringMap, "replaceAll after stringMap");

        // compute
        stringMap.compute("DDD", (key, value) -> {
            return "GoodJob";
        });
        YamdengCollectionUtil.mapToString(stringMap, "compute after stringMap");

        // computeIfPresent
        stringMap.computeIfPresent("HHH", (key, value) -> {
            return "GoodJob";
        });
        YamdengCollectionUtil.mapToString(stringMap, "compute after stringMap");

        // computeIfAbsent
        stringMap.computeIfAbsent("HHH", (key) -> {
            return "GoodJob";
        });
        YamdengCollectionUtil.mapToString(stringMap, "compute after stringMap");

        // merge
        stringMap.clear();
        stringMap.put("AAA", "AAA-V");
        System.out.println("merge before : " + stringMap);
        stringMap.merge("AAA-1", "CHANGE", (key, value) -> value + " : merge");
        stringMap.merge("AAA", "CHANGE", (key, value) -> value + " : merge");
        System.out.println("merge after : " + stringMap);
    }

    private static void treeMap() {
        System.out.println("TreeMap");
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("AA", "AA-value");
        hashMap.put("ZZ", "ZZ-value");
        hashMap.put("FF", "FF-value");
        hashMap.put("BB", "BB-value");
        hashMap.put("CC", "CC-value");
        hashMap.put("DD", "DD-value");
        hashMap.put("OO", "OO-value");
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("AA", "AA-value");
        treeMap.put("ZZ", "ZZ-value");
        treeMap.put("FF", "FF-value");
        treeMap.put("BB", "BB-value");
        treeMap.put("CC", "CC-value");
        treeMap.put("DD", "DD-value");
        treeMap.put("OO", "OO-value");
        YamdengCollectionUtil.iteratorToString(hashMap.keySet(), "hashMap-keySet");
        YamdengCollectionUtil.iteratorToString(treeMap.keySet(), "treeMap-keySet");
    }

    private static void mapSort() {
        System.out.println("맵 정렬");
        Map<String, Integer> stringIntegerMap = Map.of("AAA", 30, "BBB", 20, "CCC", 10);
        System.out.println("stringIntegerMap : " + stringIntegerMap);
        Map<String, Integer> stringIntegerMap2 = stringIntegerMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap((entry) -> entry.getKey(), (entry) -> entry.getValue())); // 정렬이 되지는 않음
        System.out.println("stringIntegerMap2 : " + stringIntegerMap2);
        stringIntegerMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        System.out.println();
        stringIntegerMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        List<Map.Entry<String, Integer>> entryList = stringIntegerMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        Map<String, Integer> keySortMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            keySortMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println("keySortMap : " + keySortMap);
        System.out.println();

        List<Map.Entry<String, Integer>> entryList2 = stringIntegerMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        Map<String, Integer> valueSortMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : entryList2) {
            valueSortMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println("valueSortMap : " + valueSortMap);
    }

    private static void concurrentHashMap() {
        System.out.println("ConcurrentHashMap");
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        YamdengCollectionUtil.initStringMap(concurrentHashMap);
        System.out.println("concurrentHashMap : " + concurrentHashMap);

        Map<String, String> stringMap = new HashMap<>();
        System.out.println();

        // forEach
        concurrentHashMap.forEach((key, value) -> {
            System.out.print("키["+ key + "] : " + value + ", ");
        });
        System.out.println();

        concurrentHashMap.forEach(10, (key, value) -> {
            System.out.print("키["+ key + "] : " + value + ", ");
        });
        System.out.println();

        concurrentHashMap.forEach(10, (key, value) -> {
            return value;
        }, (transferResult) -> {
            System.out.print("transferResult : " + transferResult + ", ");
        });
        System.out.println();

        // mappingCount : size()는 int 반환, mappingCount()는 long 반환
        long mappingCount= concurrentHashMap.mappingCount();
        System.out.println("mappingCount : " + mappingCount);

        // reduceValues, reduce, reduceEntriesToLong

        // reduceValues
        String maxString = concurrentHashMap.reduceValues(3, (v1, v2) -> v1.compareTo(v2) > 0 ? v1 : v2);
        System.out.println("maxString : " + maxString);

        // reduce
        int lengthSum = concurrentHashMap.reduce(3, (v1, v2) -> v1.length(), (v1, v2) -> v1 + v2);
        System.out.println("lengthSum : " + lengthSum);

        // reduceEntriesToLong
        concurrentHashMap.reduceEntriesToLong(3, (entry) -> entry.getValue().length(), 0, (r1, r2) -> r1 + r2);

        // search
        BoardVo boardVo = concurrentHashMap.search(3, (key, value) -> {
            if(key.equals("key3")) {
                BoardVo b1 = new BoardVo();
                b1.setTitle("key3");
                return b1;
            } else {
                return null;
            }
        });
        System.out.println("boardVo : " + boardVo);
    }
}
