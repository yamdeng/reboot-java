package com.yamdeng.reboot.java.stream;

import com.yamdeng.reboot.java.util.YamdengCollectionUtil;
import com.yamdeng.reboot.java.vo.BoardVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 스트림 매핑
public class StreamMapping {

    public static void main(String[] args) {
        System.out.println("========== 스트림 매핑 ==========");
        System.out.println();

        // map
        map();
        System.out.println();
        
        // flatMap
        faltMap();
        System.out.println();

        System.out.println("========== StreamMapping End ==========");
    }

    // map
    private static void map() {
        System.out.println("map");
        List<BoardVo> boardList = new ArrayList<>();
        YamdengCollectionUtil.initBoardVoListStream(boardList);
        List<String> titleList = boardList.stream().map(b -> b.getTitle()).collect(Collectors.toList());
        System.out.println("titleList " + titleList);
    }

    // faltMap
    private static void faltMap() {
        System.out.println("faltMap");
        List<String> titleList = List.of("Hello", "World");
        List<String[]> unitCharacterArrayList = titleList.stream().map(word -> word.split("")).distinct().collect(Collectors.toList());
        for(String[] arr : unitCharacterArrayList) {
            System.out.println("arr : " + Arrays.toString(arr));
        }
        List<Stream<String>> result = titleList.stream().map(word -> word.split("")).map(Arrays::stream).distinct().collect(Collectors.toList());
        for(Stream<String> s : result) {
            s.forEach(str -> System.out.println("str : " + str));
        }
        List<String> unitCharacterList = titleList.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println("unitCharacterList : " + unitCharacterList);
    }

}
