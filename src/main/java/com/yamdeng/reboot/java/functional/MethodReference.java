package com.yamdeng.reboot.java.functional;


import com.yamdeng.reboot.java.vo.BoardVo;

import java.util.function.Function;
import java.util.function.Supplier;

// 메서드 참조
public class MethodReference {

    public static void functionInterface(Function<String, Integer> function, String parameter) {
        Integer integer = function.apply(parameter);
        System.out.println("integer : " + integer);
    }

    public static Integer staticCompareTo(String str) {
        return 0;
    }

    public Integer compareTo(String str) {
        return 0;
    }

    public void test() {
        functionInterface(""::compareTo, "20");
        functionInterface(this::compareTo, "20");
        functionInterface(String::length, "20");
    }

    public static void main(String[] args) {
        System.out.println("========== 함수형 인터페이스 커스텀 ==========");
        System.out.println();
        
        // 메서드 참조 예시
        methodReference();
        System.out.println();

        System.out.println("========== MethodReference End ==========");
    }

    private static void methodReference() {
        System.out.println("메서드 참조 예시");

        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String str) {
                return Integer.parseInt(str);
            }
        };
        // 익명 객체를 생성해서 전달
        functionInterface(function, "10");
        
        // 람다식으로 전달
        functionInterface((s) -> Integer.parseInt(s), "10");
        
        // 메서드 참조로 전달 : 정적 메서드로 전달
        functionInterface(Integer::parseInt, "20");
        functionInterface(MethodReference::staticCompareTo, "20");
        
        // 메서드 참조 전달 : 인스턴스 메서드로 전달
        MethodReference methodReference = new MethodReference();
        functionInterface(""::compareTo, "20");
        functionInterface(methodReference::compareTo, "20");
        functionInterface(String::length, "20");
        
        // new 연산자를 메서드 참조로 이용
        // 인자가 없는 생성자 호출
        Supplier<BoardVo> supplier1 = BoardVo::new;
        System.out.println("board : " + supplier1.get());
        
        // 인자가 하나 있는 생성사 호출
        Function<String, BoardVo> supplier2 = BoardVo::new;
        System.out.println("board : " + supplier2.apply("자바"));
    }
    
}
