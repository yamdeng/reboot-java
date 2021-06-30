package com.yamdeng.reboot.java.type.generic;

import java.lang.reflect.WildcardType;
import java.util.*;
import java.util.concurrent.ScheduledFuture;

// 제네릭 와일드 카드
public class GenericWildcard {

    private static class WildcardVo1 {
        private String name;
    }

    private static class WildcardVo2 implements Comparable<String> {
        private String name;

        @Override
        public int compareTo(String obj) {
            return 0;
        }
    }

    private static class WildcardVo3 implements Comparable<WildcardVo3> {
        private String name;

        @Override
        public int compareTo(WildcardVo3 obj) {
            return 0;
        }
    }

    private static class ChildWildcardVo extends WildcardVo3 {

        @Override
        public int compareTo(WildcardVo3 obj) {
            return 0;
        }

    }

    public static <T extends Comparable<? super T>> T max2(List<? extends T> list) {
        Iterator<? extends T> i = list.iterator();
        T result = i.next();
        while(i.hasNext()) {
            T t = i.next();
            if(t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;
    }

    public static <T extends Comparable<T>> T max(List<T> list) {
        Iterator<T> i = list.iterator();
        T result = i.next();
        while(i.hasNext()) {
            T t = i.next();
            if(t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;
    }

    // Box, Product
    public static <T extends Product> Box<? extends T> method2() {
        return null;
    }

    // Box, Product
    public static <T extends Product> void method1(T item, Box<? extends T> extendsBox, Box<? super T> superBox) {
        // 1.<? extends T> 에서 반환 타입 메서드 호출시 타입<T>를 <T extends Product> 처럼 제한을 걸어놓으면 타입의 최상위를 고정시키는 것이므로 아래의 문법 모두 허용함
        Product p1 = extendsBox.getMember();
        T p2 = extendsBox.getMember();
        System.out.println("p1 : " + p1);
        System.out.println("p2 : " + p2);

        // 2.<? super T> 에서 파라미터 타입 메서드 호출시 타입<T>를 <T extends Product> 처럼 제한을 걸어놓아도 오로지 T 타입의 변수만 전달 가능함
        // superBox.setMember(p1); // 오류 : T 타입만 허용
        superBox.setMember(item);
        Object superMember = superBox.getMember();
        System.out.println("superMember : " + superMember);
    }

    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        return null;
    }

    public static <E> void swapE(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void swap(List<?> list, int i, int j) {
        // list.set(i, list.set(j, list.get(i))); // 오류 : 타입<T>를 파리미터로 정의하고 있는 메서드 호출은 허용하지 않음
        swapHelper(list, i, j);
    }

    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void main(String[] args) {
        System.out.println("========== 와일드 카드 ==========");
        System.out.println();

        // 기본 와일드 카드
        basicWildcard();
        System.out.println();

        // 와일드 카드 메서드 case
        methodWithWildcard();
        System.out.println();

        // 재귀 한정 타입
        recursiveSelfType();
        System.out.println();

        System.out.println("========== GenericWildcard End ==========");
    }

    // Box, Product, Tv
    private static void basicWildcard() {
        System.out.println("와일드 카드 메서드 case");

        // Box<Object> objectBox = new Box<String>(); // 오류 : 제네릭은 불공변임. Box<Object> 타입인 실체화 요소로는 모든 타입을 허용하지만 제네릭 타입끼리 대입시에는 정확히 new Box<Object>(); 처럼 일치해야 한다
        Box<?> allBox = new Box<String>("aaa");
        // Box<? extends Object> allBox = new Box<String>(); // <?>와 <? extends Object>은 완전 동일함
        Box<Object> objectBox = new Box<Object>();
//        allBox.setMember(""); // <?> 같은 제네릭 타입끼리 <T>타입에 대해서 모든 타입을 허용하는 의미이고 실제로 타입을 사용하는 메서드 호출시 null 전달만 가능하다
//        allBox.setMember(new Object());
        objectBox.setMember("");
        objectBox.setMember(new Object());
        String allBoxString = (String) allBox.getMember();
        System.out.println("allBoxString.toUpperCase() : " + allBoxString.toUpperCase());

        // Object 타입을 상속하는 하위 타입을 받을 수 있다
        Box<? extends String> stringBox = new Box<String>();
//        Box<? extends String> stringBox = new Box<Object>(); // 오류 : String의 하위 클래스 타입만 받을 수 있다
//        Box<? super Object> stringBox2 = new Box<String>(); // 오류 : Object가 상속한 상위 타입을 받을 수 있다

        Box<? extends List> extendListBox = new Box<ArrayList>();
//        Box<? extends List> extendListBox = new Box<Collection>(); // 오류 : Collection은 List의 하위 타입이 아니다

        Box<? super List> superListBox = new Box<Collection>();
//        Box<? super List> superListBox = new Box<ArrayList>(); // 오류 : ArrayList는 List의 상위 타입이 아니다

        List extendList = extendListBox.getMember(); // 선언한 <T> 타입 반환은 허용
//        extendListBox.setMember(new Object()); // 오류 : null 외에 허용 X
//        extendListBox.setMember(new ArrayList()); // 오류 : null 외에 허용 X

        Object superList = superListBox.getMember(); // Object 반환은 허용
//        List superList = superListBox.getMember(); // 오류 : 오로지 Object 반환만 허용
        superListBox.setMember(new ArrayList()); // 선언한 <T> 타입의 자식 타입까지 허용
//        superListBox.setMember(new Object()); // 오류 : <T> 타입의 자식 타입만 허용

        // Collection 타입에 와일드 카드 예시
        List<Tv> tvList = List.of(
                new Tv("Samsung", 100, false),
                new Tv("Lg", 100, false),
                new Tv("Sonly", 100, false)
        );
        List<Object> objectList = List.of(
                new Object()
        );

        // extends 예시
//        List<? extends Product> genericProductList = new ArrayList<Product>(objectList); // 오류 : ArrayList<Product> Product의 하위 타입의 Collection<T>만 허용
        List<? extends Product> genericProductList = new ArrayList<Product>(tvList);
//        genericProductList.add(new Tv("Samsung", 100, false)) // 오류 : <? extends T> 이므로 파라미터에 <T>가 정의된 메서드 호출시 null만 전달 가능
        Product firstInfo = genericProductList.get(0);
        System.out.println("firstInfo : " + firstInfo);

        // super 예시
        List<? super Product> genericProductList2 = new ArrayList<Product>(tvList);
//        Product firstInfo2 = genericProductList2.get(0); // 오류 : <? super T> 이므로 반환타입에 <T>가 정의된 메서드 호출시 Object만 반환 받음
        Object firstInfo2 = (Object) genericProductList2.get(0);
        System.out.println("firstInfo2 : " + firstInfo);
        genericProductList2.set(0, new Tv("Samsung2", 200, true));
        firstInfo2 = (Object) genericProductList2.get(0);
        System.out.println("firstInfo2 after : " + firstInfo2);
    }

    private static void methodWithWildcard() {
        System.out.println("와일드 카드 메서드 case");

        // 제네릭 메서드 내부에서 <T> 사용 case 확인
        Box<Computer> extendsBox = new Box<>();
        extendsBox.setMember(new Computer("알라딘", 100, CpuType.AMD));
        Box<Product> superBox = new Box<>();
        superBox.setMember(new Tv("Samsung", 100, false));
        GenericWildcard.method1(new Tv("Lg", 200, true), extendsBox, superBox);

        // 메서드에서 wildcard 제네릭 타입을 반환시 호출하는 부분에서 어떻게 받아야 할지
        // public static <T extends Product> Box<? extends T> method2()
        Box<? extends Product> result1 = GenericWildcard.method2();
        Box<? extends Object> result2 = GenericWildcard.<Product>method2();
        
        // 와일드 카드 호출 예시 : 계층 타입으로 호출
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Set<Integer> integerSet = union(s1, s1);
        Set<Number> numberSet = GenericWildcard.union(s1, s1);
        Set<List> s3 = new HashSet<>();
        Set<List> s4 = new HashSet<>();
        Set<Collection> collectionSet = GenericWildcard.union(s3, s4);

        // 제네릭에 <E>에 <?>를 전달할 수 있음
        // static <E> void swapHelper(List<E> list, int i, int j)
        // List<?> list; swapHelper(list, 1, 2);
        List<String> stringList = new ArrayList<>();
        List<Integer> integerListList = new ArrayList<>();
        swapE(stringList, 1, 3);
        swapE(integerListList, 1, 3);
        swap(stringList, 1, 3);
        swap(integerListList, 1, 3);
    }

    private static void recursiveSelfType() {
        System.out.println("재귀 한정 타입");
//        public static <T extends Comparable<? super T>> T max2(List<? extends T> list) {
//        public static <T extends Comparable<T>> T max(List<T> list) {
        List<Integer> integerList = new ArrayList<>();
        max(integerList);
        max2(integerList);

        List<ChildWildcardVo> voList = new ArrayList<>();
        // max(voList); // 오류 : ChildWildcardVo 클래스는 Comparable 인터페이스를 구현하지 않았기 때문에 컴파일 에러
        max2(voList); // 허용

        List<ScheduledFuture<?>> sfList = new ArrayList<>();
        // max(sfList); // 오류 : ScheduledFuture 인터페이스는 Comparable 인터페이스를 구현하지 않았기 때문에 컴파일 에러
        max2(sfList); // 허용

    }

}
