package com.yamdeng.reboot.java.functional.standard;

import com.yamdeng.reboot.java.util.YamdengCollectionUtil;
import com.yamdeng.reboot.java.vo.BoardVo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

// 표준 함수형 인터페이스
public class BasicFunctionalInterface {

    private static <T> void consumerFunctionCall(Consumer<? super T> consumer, T parameter) {
        consumer.accept(parameter);
    }

    private static <T, R> void functionFunctionCall(Function<T, R> function, Collection<T> list ) {
        List<R> resultList = list.stream().map(function).collect(Collectors.toList());
        System.out.println("functionFunctionCall resultList : " + resultList);
    }

    private static <T> T supplierFunctionCall(Supplier<? extends T> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {

        System.out.println("========== 표준 함수형 인터페이스 ==========");
        System.out.println();

        // Predicate 함수형 인터페이스
        predicateInterface();
        System.out.println();

        // Consumer 함수형 인터페이스
        consumerInterface();
        System.out.println();

        // Function 함수형 인터페이스
        functionInterface();
        System.out.println();

        // Supplier 함수형 인터페이스
        supplierInterface();
        System.out.println();

        // 기본 특화형 인터페이스 : 오토박싱 / 언박싱을 방지함
        typeFixFunctionInterface();
        System.out.println();

        // Collection에서 사용되는 @FunctionalInterface 인터페이스
        collectionUseFunctionalInterface();
        System.out.println();

        System.out.println("========== BasicFunctionalInterface End ==========");
    }

    private static void predicateInterface() {
        System.out.println("Predicate 인터페이스");
//        public interface Predicate<T> {
//            boolean test(T t);
//        }

        List<String> stringList = new ArrayList<String>();
        YamdengCollectionUtil.initStringList(stringList);

        System.out.println("before stringList : " + stringList);
        stringList = stringList.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                // AAA가 아닌 것만 필터
                return !s.equals("AAA");
            }
        }).collect(Collectors.toList());
        System.out.println("after stringList : " + stringList);

        // 람다식으로
        YamdengCollectionUtil.initStringList(stringList);
        System.out.println("before stringList : " + stringList);
        stringList = stringList.stream().filter(s -> s.equals("AAA")).collect(Collectors.toList());
        System.out.println("after stringList : " + stringList);
    }

    private static void supplierInterface() {
        System.out.println("Supplier 인터페이스");
//        @FunctionalInterface
//        public interface Supplier<T> {
//            T get();
//        }

        BoardVo resultVo = new Supplier<BoardVo>() {
            @Override
            public BoardVo get() {
                return new BoardVo();
            }
        }.get();
        System.out.println("resultVo : " + resultVo);

        resultVo = supplierFunctionCall(() -> new BoardVo());
        System.out.println("제네릭 메서드 resultVo : " + resultVo);
    }

    private static void consumerInterface() {
        System.out.println("Consumer 인터페이스");
//        @FunctionalInterface
//        public interface Consumer<T> {
//            void accept(T t);
//        }

        Consumer consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Display : " + s);
            }
        };
        consumer.accept("AAA");
        
        // 메서드를 제네릭 메서드로 정의
        // 람다식으로 전달
        consumerFunctionCall((parameter) -> System.out.println("Display : " + parameter), "BBB");
        
        // 익명 객체로 전달 
        consumerFunctionCall(new Consumer<String>() {
            @Override
            public void accept(String parameter) {
                System.out.println("Display2 : " + parameter);
            }
        }, "BBB");

        List<String> stringList = new ArrayList<String>();
        YamdengCollectionUtil.initStringList(stringList);
        
        // 제네릭 메서드로 정의해서 타입이 자동으로 추론됨
        consumerFunctionCall((parameter) -> System.out.println("Display3 : " + parameter), stringList);
    }

    private static void functionInterface() {
        System.out.println("Function 함수형 인터페이스");
//        @FunctionalInterface
//        public interface Function<T, R> {
//            R apply(T t);
//        }

        List<BoardVo> boardList = new ArrayList<BoardVo>();
        YamdengCollectionUtil.initBoardVoList(boardList);
        System.out.println("boardList : " + boardList);

        // 람다식으로 전달
        List<String> boardToStringList = boardList.stream().map(boardVo -> boardVo.toString()).collect(Collectors.toList());
        System.out.println("람다식 boardToStringList : " + boardToStringList);

        // 익명 객체로 전달
        boardToStringList = boardList.stream().map(new Function<BoardVo, String>() {
            @Override
            public String apply(BoardVo boardVo) {
                return boardVo.toString();
            }
        }).collect(Collectors.toList());
        System.out.println("익명 객체 boardToStringList : " + boardToStringList);

        // 제네릭 메서드
        functionFunctionCall(boardVo -> boardVo.toString(), boardList);
        System.out.println("제네릭 메서드 boardToStringList : " + boardToStringList);
    }

    private static void typeFixFunctionInterface() {
        System.out.println("");
        IntToDoubleFunction intToDoubleFunction = new IntToDoubleFunction() {
            @Override
            public double applyAsDouble(int value) {
                return Double.valueOf(value) * 0.1;
            }
        };
        System.out.println("intToDoubleFunction.applyAsDouble(10) : " + intToDoubleFunction.applyAsDouble(10));
    }

    private static void collectionUseFunctionalInterface() {
        System.out.println("Collection에서 사용되는 @FunctionalInterface 인터페이스");
        List<String> stringList = new ArrayList<>();
        stringList.removeIf((stringInfo) -> stringInfo != null);
        List<String> newStringList1 = stringList.stream().filter((stringInfo) -> stringInfo != null).collect(Collectors.toList());
    }

}
