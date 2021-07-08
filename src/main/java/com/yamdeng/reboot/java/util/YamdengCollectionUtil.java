package com.yamdeng.reboot.java.util;

import com.yamdeng.reboot.java.vo.BoardVo;

import java.time.LocalDate;
import java.util.*;

public class YamdengCollectionUtil {

    public static void repeatIterator(Collection collection, String variableName) {
        System.out.println("========== Collection Iterator Class Display [" + variableName + "] ==========");
        System.out.println("variableName Collection Size: [" + collection.size() +"]");
        Iterator iterator = collection.iterator();
        while(iterator.hasNext()) {
            Object value = iterator.next();
            Class cls = value.getClass();
            System.out.println("value : " + value.toString() + ", className : " + cls.getName() + ", packageName : " + cls.getPackageName() + ", typeName : " + cls.getTypeName() + ", simpleName : " + cls.getSimpleName() + ", canonicalName : " + cls.getCanonicalName());
        }
        System.out.println("========== Collection Iterator Class Display End ==========");
    }

    public static void repeatListIterator(List list, String variableName) {
        System.out.println("========== List ListIterator Class Display [" + variableName + "] ==========");
        System.out.println("variableName List Size: [" + list.size() +"]");
        ListIterator listIterator = list.listIterator();
        while(listIterator.hasNext()) {
            Object value = listIterator.next();
            Class cls = value.getClass();
            System.out.println("value : " + value.toString() + ", className : " + cls.getName() + ", packageName : " + cls.getPackageName() + ", typeName : " + cls.getTypeName() + ", simpleName : " + cls.getSimpleName() + ", canonicalName : " + cls.getCanonicalName());
        }
        System.out.println("========== List ListIterator Class Display End ==========");
    }

    public static String iteratorToString(Collection collection, String variableName) {
        String result = "";
        Iterator iterator = collection.iterator();
        while(iterator.hasNext()) {
            Object value = iterator.next();
            if(result.equals("")) {
                result = result + variableName + " : " + value;
            } else {
                result = result + ", " + value;
            }
        }
        System.out.println(result);
        return result;
    }

    public static String mapToString(Map map, String variableName) {
        String result = "";
        Set<String> keySet = map.keySet();
        for(String key : keySet) {
            String value = map.get(key).toString();
            if(result.equals("")) {
                result = result + variableName + " : " + "(" + key + ":" + value + ")";
            } else {
                result = result + ", " + "(" + key + ":" + value + ")";
            }
        }
        System.out.println(result);
        return result;
    }

    public static void initStringList(Collection<String> stringList) {
        if(stringList.size() > 0) {
            stringList.clear();
        }
        stringList.add("AAA");
        stringList.add("AAA");
        stringList.add("BBB");
        stringList.add("CCC");
        stringList.add("ZZZ");
        stringList.add("AAA");
        stringList.add("DDD");
        stringList.add("AAA");
        stringList.add("FFF");
        stringList.add("BBB");
    }

    public static void initIntegerList(Collection<Integer> integerList) {
        if(integerList.size() > 0) {
            integerList.clear();
        }
        integerList.add(10);
        integerList.add(2);
        integerList.add(20);
        integerList.add(11);
        integerList.add(30);
        integerList.add(100);
        integerList.add(50);
        integerList.add(10);
        integerList.add(0);
    }

    public static void initBoardVoList(Collection<BoardVo> boardVoCList) {
        if(boardVoCList.size() > 0) {
            boardVoCList.clear();
        }
        int maxIndex = 10;
        for(int index=0; index<maxIndex; index++) {
            BoardVo boardVo = new BoardVo();
            boardVo.setTitle("제목" + (index+1));
            boardVo.setContent("내용" + (index+1));
            boardVo.setCreatedDate(LocalDate.now());
            boardVoCList.add(boardVo);
        }
    }

}
