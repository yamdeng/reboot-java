package com.yamdeng.reboot.java.type.generic;

import com.yamdeng.reboot.java.type.generic.custom.CustomBiFunction;
import com.yamdeng.reboot.java.type.generic.custom.CustomBiFunctionUse;
import com.yamdeng.reboot.java.type.generic.custom.CustomBiFunctionUse2;
import com.yamdeng.reboot.java.util.YamdengCollectionUtil;

import java.util.HashMap;
import java.util.Map;

// 제네릭 인터페이스
public class GenericInterface {

    public static void main(String[] args) {
        System.out.println("========== 제네릭 인터페이스 ==========");
        System.out.println();

        // 제네릭 인터페이스
        genericInterface();
        System.out.println();

        System.out.println("========== GenericInterface End ==========");
    }

    // CustomBiFunction, CustomBiFunctionUse, CustomBiFunctionUse2
    private static void genericInterface() {
        System.out.println("제네릭 인터페이스");

        // 인터페이스 제네릭 타입을 구현한 클래스를 이용
        CustomBiFunction<String, Integer, Map<String, Integer>> ccf = new CustomBiFunctionUse<>();
        Map<String, Integer> map = ccf.apply("key", 10);
        YamdengCollectionUtil.mapToString(map, "map");
        System.out.println("map.get(\"key\").toString() : " + map.get("key").toString());
        
        // 인터페이스 제네릭 타입을 익명 객체로 바로 사용
        CustomBiFunction<String, Integer, Map<String, Integer>> applyInterface = new CustomBiFunction<>() {
            @Override
            public Map<String, Integer> apply(String key, Integer value) {
                Map<String, Integer> map = new HashMap<>();
                map.put(key, value);
                return map;
            }
        };
        Map<String, Integer> map2 = ccf.apply("key", 100);
        YamdengCollectionUtil.mapToString(map2, "map2");
        System.out.println("map2.get(\"key\").toString() : " + map2.get("key").toString());
        
        // 새로운 타입으로 익명 객체로 바로 사용
        CustomBiFunction<Integer, Integer, String> applyInterface2 = new CustomBiFunction<>() {
            @Override
            public String apply(Integer integer, Integer integer2) {
                int sum = integer.intValue() + integer2.intValue();
                return "" + sum;
            }
        };
        String sumString = applyInterface2.apply(10, 20);
        System.out.println("sumString : " + sumString);

        // 클래스 안에서 제네릭 인터페이스 타입을 정의해서 사용할 수 있음(일반적으로는 이방법을 사용함)
        CustomBiFunctionUse2 customBiFunctionUse2 = new CustomBiFunctionUse2();
        sumString = customBiFunctionUse2.apply(10, 10);
        System.out.println("sumString : " + sumString);
    }

}
