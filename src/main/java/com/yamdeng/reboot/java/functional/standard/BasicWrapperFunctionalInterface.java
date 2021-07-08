package com.yamdeng.reboot.java.functional.standard;

import java.util.function.*;

// 표준 특화 함수형 인터페이스
public class BasicWrapperFunctionalInterface {

    private static <P1, P2, R> R biFunctionCall(BiFunction<P1, P2, R> biFunction, P1 p1, P2 p2) {
        R result = biFunction.apply(p1, p2);
        return result;
    }

    private static <P1, P2> boolean biPredicateCall(BiPredicate<P1, P2> biPredicate, P1 p1, P2 p2) {
        return biPredicate.test(p1, p2);
    }

    private static <P1, P2> void biConsumerCall(BiConsumer<P1, P2> biConsumer, P1 p1, P2 p2) {
        biConsumer.accept(p1, p2);
    }

    private static <TR> TR binaryOperatorCall(BinaryOperator<TR> binaryOperator, TR t1, TR t2) {
        return binaryOperator.apply(t1, t2);
    }

    public static void main(String[] args) {
        System.out.println("========== 표준 함수형 인터페이스 ==========");
        System.out.println();

        // UnaryOperator 인터페이스
        unaryOperator();
        System.out.println();

        // BiFunction 인터페이스
        biFunction();
        System.out.println();

        // BiPredicate 인터페이스
        biPredicate();
        System.out.println();

        // BiConsumer 인터페이스
        biConsumer();
        System.out.println();

        // BinaryOperator 인터페이스
        binaryOperator();
        System.out.println();

        System.out.println("========== BasicWrapperFunctionalInterface End ==========");
    }

    private static void unaryOperator() {
        System.out.println("UnaryOperator 인터페이스");
//        public interface UnaryOperator<T> extends Function<T, T> {
//            static T identity(T t);
//        }

        UnaryOperator<String> unaryOperator = s -> s;
        String value = unaryOperator.apply("AAA");
        System.out.println("value : " + value);
        value = UnaryOperator.<String>identity().apply("BBB");
        System.out.println("value : " + value);
        Object value2 = UnaryOperator.identity().apply("CCC");
        System.out.println("value2 : " + value2);
        if(value2 instanceof String) {
            System.out.println("value2 is String class");
        }
    }

    private static void biFunction() {
        System.out.println("BiFunction 인터페이스");
//        public interface BiFunction<T, U, R> {
//            R apply(T t, U u);
//        }

        BiFunction<Integer, Integer, Double> biFunction = new BiFunction<Integer, Integer, Double>() {
            @Override
            public Double apply(Integer i1, Integer i2) {
                double result = i1.doubleValue() / i2.doubleValue();
                return result;
            }
        };
        System.out.println("biFunction.apply(10, 20) : " + biFunction.apply(10, 20));

        Integer integerResult = biFunctionCall((p1, p2) -> p1 / p2, 10, 20);
        Number integerResult2 = biFunctionCall((p1, p2) -> p1 / p2, 10.0, 20.0);
        Double doubleResult = biFunctionCall((p1, p2) -> p1 / p2, 10.0, 20.0);
//        Integer integerResult2 = biFunctionCall((p1, p2) -> p1 / p2, 10.0, 20.0); // 오류 : 컴파일러가 자동으로 인식함
        System.out.println("integerResult : " + integerResult);
        System.out.println("integerResult2 : " + integerResult2);
        System.out.println("doubleResult : " + doubleResult);

        // 기본 특화형 함수형 인터페이스
        ToDoubleBiFunction<Integer, Integer> toDoubleBiFunction = new ToDoubleBiFunction<Integer, Integer>() {
            @Override
            public double applyAsDouble(Integer i1, Integer i2) {
                return i1.doubleValue() / i2.doubleValue();
            }
        };
        System.out.println("toDoubleBiFunction.applyAsDouble(10, 3) : " + toDoubleBiFunction.applyAsDouble(10,  3));
    }

    private static void biPredicate() {
        System.out.println("BiPredicate 인터페이스");
//        public interface BiPredicate<T, U> {
//            boolean test(T t, U u);
//        }

        BiPredicate<String, Integer> biPredicate = new BiPredicate<String, Integer>() {
            @Override
            public boolean test(String s, Integer integer) {
                return integer.toString().equals(s);
            }
        };
        System.out.println("biPredicate.test(\"10\", 10) : " + biPredicate.test("10", 10)); // true
        System.out.println("biPredicate.test(\"10\", 11) : " + biPredicate.test("10", 11)); // false

        // 제네릭 메서드
        boolean b1 = biPredicateCall((p1, p2) -> p1.toString().equals(p2.toString()), "10",20);
        boolean b2 = biPredicateCall((p1, p2) -> p1.toString().equals(p2.toString()), "10",10);
        System.out.println("b1 : " + b1);
        System.out.println("b2 : " + b2);
    }

    private static void biConsumer() {
        System.out.println("BiConsumer 인터페이스");
//        public interface BiConsumer<T, U> {
//            void accept(T t, U u);
//        }

        BiConsumer<String, String> biConsumer = new BiConsumer<String, String>() {
            @Override
            public void accept(String s1, String s2) {
                System.out.println(s1 + s2);
            }
        };
        biConsumer.accept("AAA", "BBB");

        // 제네릭 메서드
        biConsumerCall((p1, p2) -> {
            System.out.println(p1 + p2);
        }, "AAA", 10);

        biConsumer = (p1, p2) -> System.out.println(p1 + p2);
        biConsumerCall(biConsumer, "AAA", "BBB");
    }

    private static void binaryOperator() {
        System.out.println("BinaryOperator 인터페이스");
//        public interface BinaryOperator<T> extends BiFunction<T,T,T> {
//            T identity2(T t1, T t2);
//        }

        BinaryOperator<String> binaryOperator = new BinaryOperator<String>() {
            @Override
            public String apply(String s1, String s2) {
                return s1 + s2;
            }
        };
        String result = binaryOperator.apply("AAA", "BBB");
        System.out.println("result : " + result);

        // 제네릭 메서드
        result = binaryOperatorCall((p1, p2) -> p1 + p2, "CCC", "DDD");
        System.out.println("result : " + result);
    }

}
