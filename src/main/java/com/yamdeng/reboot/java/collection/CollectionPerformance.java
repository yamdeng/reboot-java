package com.yamdeng.reboot.java.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Collection 성능 측정
public class CollectionPerformance {

    public static void main(String[] args) {
        System.out.println("========== Collection 성능 측정 ==========");
        System.out.println();

        // performanceCheck
        performanceCheck();
        System.out.println();
        
        // 오토박싱 / 언박싱 성능
        autoBoxingCheck();
        System.out.println();

        System.out.println("========== CollectionPerformance End ==========");
    }

    private static void performanceCheck() {
        System.out.println("performanceCheck");
        
        List arrayList = new ArrayList();

        // int
        long startTime = System.nanoTime();
        for(int index=0; index<100000000; index++) {
            arrayList.add(index);
        }
        long endTime = System.nanoTime();
        long resultSecond = TimeUnit.SECONDS.convert(endTime, TimeUnit.NANOSECONDS) - TimeUnit.SECONDS.convert(startTime, TimeUnit.NANOSECONDS);
        System.out.println("arrayList size : " + arrayList.size());
        System.out.println("resultSecond(int) : " + resultSecond);

        // double
        arrayList.clear();
        startTime = System.nanoTime();
        for(int index=0; index<100000000; index++) {
            arrayList.add(1.5d);
        }
        endTime = System.nanoTime();
        resultSecond = TimeUnit.SECONDS.convert(endTime, TimeUnit.NANOSECONDS) - TimeUnit.SECONDS.convert(startTime, TimeUnit.NANOSECONDS);
        System.out.println("arrayList size : " + arrayList.size());
        System.out.println("resultSecond(double) : " + resultSecond);

        // string
        arrayList.clear();
        startTime = System.nanoTime();
        for(int index=0; index<30000000; index++) {
            arrayList.add("index" + index);
        }
        endTime = System.nanoTime();
        resultSecond = TimeUnit.SECONDS.convert(endTime, TimeUnit.NANOSECONDS) - TimeUnit.SECONDS.convert(startTime, TimeUnit.NANOSECONDS);
        System.out.println("arrayList size : " + arrayList.size());
        System.out.println("resultSecond(String) : " + resultSecond);
    }

    private static void autoBoxingCheck() {
        System.out.println("오토박싱 / 언박싱 성능");
        List<Integer> integerList = new ArrayList();
        long startTime = System.nanoTime();
        for(int index=0; index<100000000; index++) {
            integerList.add(index);
        }
        long endTime = System.nanoTime();
        long resultSecond = TimeUnit.SECONDS.convert(endTime, TimeUnit.NANOSECONDS) - TimeUnit.SECONDS.convert(startTime, TimeUnit.NANOSECONDS);
        System.out.println("arrayList size : " + integerList.size());
        System.out.println("resultSecond(Integer) : " + resultSecond);

        // sum
        Long sum = 0L;
        startTime = System.nanoTime();
        for(int index=0; index<100000000; index++) {
            sum = sum + integerList.get(index);
        }
        endTime = System.nanoTime();
        resultSecond = TimeUnit.SECONDS.convert(endTime, TimeUnit.NANOSECONDS) - TimeUnit.SECONDS.convert(startTime, TimeUnit.NANOSECONDS);
        System.out.println("int sum : " + sum);
        System.out.println("resultSecond(int sum) : " + resultSecond);
    }

}
