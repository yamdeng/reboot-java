package com.yamdeng.reboot.java.functional;


import java.util.function.Function;
import java.util.function.Predicate;

// 함수형 인터페이스 조합하기
public class FunctionalCompose {

    public static void main(String[] args) {
        System.out.println("========== 함수형 인터페이스 조합하기 ==========");
        System.out.println();

        // Predicate 조합
        predicateCompose();
        System.out.println();

        // Function 조합
        functionCompose();
        System.out.println();

        System.out.println("========== FunctionalCompose End ==========");
    }

    private static void predicateCompose() {
        System.out.println("Predicate 조합");
        Predicate<String> stringPredicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return true;
            }
        };
        boolean b1 = stringPredicate.test("aa");
        System.out.println("b1 : " + b1);

        Predicate<String> composeAndPredicate = stringPredicate.and((s) -> s.indexOf("a") != -1);
        System.out.println("composePredicate.test(\"aa\") : " + composeAndPredicate.test("aa"));
        System.out.println("composePredicate.test(\"bb\") : " + composeAndPredicate.test("bb"));
        System.out.println("composePredicate.test(\"bb\") or : " + composeAndPredicate.or(s -> true).test("bb"));
        
        // Predicate.not은 결과의 반대를 반환함
        boolean b2 = Predicate.not(composeAndPredicate).test("cc");
        System.out.println("b2 : " + b2);

        // negate : Predicate.not과 동일하지만 코드를 좀 더 단축시킬 수 있음
        boolean b3 = composeAndPredicate.negate().test("cc");
        System.out.println("b3 : " + b3);

        // Predicate.isEqual은 Predicate<Type>을 반환함. 내부적으로는 객체를 equals 메서드로 비교
        Predicate<String> stringPredicate2 = Predicate.isEqual("aa");
        stringPredicate2.test("aa"); // true
        stringPredicate2.test("bb"); // false
    }

    private static void functionCompose() {
        System.out.println("Function 조합");

        // String 타입으로만 조합
        Function<String, String> sf1  = (s) -> s.toUpperCase();
        Function<String, String> sf2  = (s) -> s.toLowerCase();
        Function<String, String> sfAndThen  = sf1.andThen(sf2);
        Function<String, String> sfCompose = sf1.compose(sf2);

        String andThenString = sfAndThen.apply("AbCdE");
        String composeString = sfCompose.apply("AbCdE");
        System.out.println("andThenString : " + andThenString); // aaa
        System.out.println("composeString : " + composeString); // AAA

        // 다른 타입끼리 조합 : Integer, String
        Function<String, Integer> if1  = (s) -> Integer.parseInt(s);
        Function<Integer, String> if2  = (i) ->  { int sum = Integer.valueOf(10) + Integer.valueOf(i); return Integer.toString(sum); } ;
        Function<String, String> ifAndThen= if1.andThen(if2);
        Function<Integer, Integer> ifCompose = if1.compose(if2);
        String result1 = ifAndThen.apply("10");
        Integer result2 = ifCompose.apply(10);
        System.out.println("ifAndThen : " + result1); // 20
        System.out.println("ifCompose : " + result2); // 20

    }
}
