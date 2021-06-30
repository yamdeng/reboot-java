package com.yamdeng.reboot.java.collection;

import com.yamdeng.reboot.java.util.YamdengCollectionUtil;

import java.util.TreeSet;

// TreeSet : 자동으로 sort됨
public class TreeSetFunction {

    public static void main(String[] args) {
        System.out.println("========== TreeSet ==========");
        System.out.println();

        // treeSet api
        treeSetFunction();
        System.out.println();

        System.out.println("========== TreeSetFunction End ==========");
    }

    // subSet, headSet, tailSet
    private static void treeSetFunction() {
        System.out.println("treeSet api");
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("AAA");
        treeSet.add("AAAb");
        treeSet.add("ZZZ");
        treeSet.add("FFF");
        treeSet.add("BBB");
        treeSet.add("BBBc");
        treeSet.add("BBBd");
        treeSet.add("AAAC");
        treeSet.add("AAAd");
        treeSet.add("AAA");
        YamdengCollectionUtil.iteratorToString(treeSet, "treeSet");

        // subSEt
        YamdengCollectionUtil.iteratorToString(treeSet.subSet("A", "B"), "subSet");
        YamdengCollectionUtil.iteratorToString(treeSet.subSet("A", "C"), "subSet");

        // headSet, tailSet
        YamdengCollectionUtil.iteratorToString(treeSet.headSet("B"), "headSet");
        YamdengCollectionUtil.iteratorToString(treeSet.tailSet("B"), "tailSet");
        YamdengCollectionUtil.iteratorToString(treeSet, "after treeSet");

        // first, last, higher, lower
        System.out.println("treeSet.first() : " + treeSet.first());
        System.out.println("treeSet.last() : " + treeSet.last());
        System.out.println("treeSet.higher(\"A\") : " + treeSet.higher("A"));
        System.out.println("treeSet.lower(\"B\") : " + treeSet.lower("B"));
    }
}
