package com.yamdeng.reboot.java.type.generic;

import com.yamdeng.reboot.java.type.Execute;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

// 제네릭 기본
public class GenericBasic {

    public static void main(String[] args) {
        System.out.println("========== 제네릭 기본 ==========");
        System.out.println();

        // genericBasic
        genericBasic();
        System.out.println();

        // custom <T extends Product>
        customTypeGeneric();
        System.out.println();

        // List<T> collection : Reflection
        listTypeReflection();
        System.out.println();

        System.out.println("========== GenericBasic End ==========");
    }

    // Box
    private static void genericBasic() {
        System.out.println("genericBasic");
        
        // 제네릭 타입 생성 방법 3가지 모두 허용하고 제네릭이 적용한다
        Box<String> boxString = new Box<String>();
        Box<String> boxString2 = new Box<>();
        Box<String> boxString3 = new Box();
        boxString.setMember("boxString");
        boxString2.setMember("boxString2");
        boxString3.setMember("boxString3");
        System.out.println("boxString.getMember() : " + boxString.getMember());
        System.out.println("boxString2.getMember() : " + boxString2.getMember());
        System.out.println("boxString3.getMember() : " + boxString3.getMember());
        System.out.println();
        
        // Box 타입도 <T>를 제외하면 일반 클래스와 동일하다. 제네릭은 파라미터와 반환 타입을 교체 가능하게 해주는 문법이다
        boxString = new Box<String>("boxString-1");
        boxString2 = new Box<>("boxString2-1");
        boxString3 = new Box("boxString3-1");
        System.out.println("boxString.getMember() : " + boxString.getMember());
        System.out.println("boxString2.getMember() : " + boxString2.getMember());
        System.out.println("boxString3.getMember() : " + boxString3.getMember());

        // <Object> 타입으로 제네릭 타입 정의시 인터페이스 타입 인스턴스를 포함한 모든 타입이 사용할 수 있다
        Execute execute = new Execute() {
            @Override
            public void execute() {
                System.out.println("Execute execute()");
            }
        };
        Comparable<String> comparable = new Comparable<String>() {
            @Override
            public int compareTo(String value) {
                return 0;
            }
        };
        Box<Object> objectBox = new Box<>();
        objectBox.setMember("aaa");
        objectBox.setMember(10);
        objectBox.setMember(new Thread());
        objectBox.setMember(new Object());
        objectBox.setMember(comparable);
        objectBox.setMember(execute);

        // 제네릭 타입을 원시 타입으로 사용할 수 있다
        Box rawType = new Box<>();
        rawType = new Box<String>();
        rawType = new Box<Object>();
        rawType = new Box<Comparable>();
        
        // 제네릭 타입도 Object 하위 클래스이다
        Object object = new Box<>();
        object = new Box<String>();
        object = new Box<Object>();
        object = new Box<Comparable>();

        // 제네릭 상속 기본
        Box<Integer> integerBox = new Box<>();
        integerBox.setMember(10);
//        integerBox.setMember(10.5); // 오류 : 허용하지 않음
        
        // 제네릭 타입 <T> 타입의 요소로 하위 클래스도 허용한다
        Box<Number> numberBox = new Box<Number>();
        numberBox.setMember(10);
        numberBox.setMember(10.5); // 허용
        
        // 제네릭을 불공변이므로 제네릭 <T> 정의 자체는 계층 구조의 타입도 허용하지 않는다
//        Box<Number> numberBox = new Box<Integer>(); // 오류 : 허용하지 않음

        System.out.println("genericBasic End");
    }

    // Box, ProductBox, ProductExecuteBox, ChildBox, ChildBox2 ~ 6, ChildProductBox, Product, Tv, Computer
    private static void customTypeGeneric() {
        System.out.println("custom <T extends Product>");

        ProductBox<Product> productBox = new ProductBox<Product>();
        ProductBox<Tv> tvBox = new ProductBox<Tv>();
        ProductBox<Computer> computerBox = new ProductBox<Computer>();
//        ProductBox<Object> objectBox = new ProductBox<Object>(); // 오류 : Product 포함 하위 클래스까지 <T>로 선언할 수 있음
//        ProductBox<Product> productBox2 = new ProductBox<Tv>(); // 오류 : 제네릭은 불공변이므로 허용하지 않음

        // 제한 범위를 2개 이상 정의할 수 있다
        ProductExecuteBox<ProductExecute> productExecuteBox = new ProductExecuteBox<ProductExecute>();
        
        // Box<T> 제네릭 타입을 상속해서 T를 재정의 가능하다
        ChildBox<Product> childBox = new ChildBox<Product>();
        ChildBox2<Number> childNumberBox = new ChildBox2<Number>();

        // ProductBox<T extends Product> 제네릭 타입을 상속해서 T를 재정의 가능하다. 단, 상위 제네릭 타입이 <T extends Product> 처럼 타입에 제한을 걸었으면 하위 클래스도 class ChildProductBox<T extends Product> extends ProductBox<T> 처럼 제한을 걸어야 한다
        ChildProductBox<Product> childProductBox = new ChildProductBox<Product>();

        // ChildBox5 : class ChildBox5 extends Box<Product>
        ChildBox5 childBox5 = new ChildBox5();
        Product childBox5Prodcut = childBox5.getMember();

        // ChildBox6 : class ChildBox6<T> extends Box<Product>
        ChildBox6<String> childBox6 = new ChildBox6<>();
        Product childBox6Prodcut = childBox6.getMember();
        String str1 = childBox5.getChild();
        ChildBox6<Integer> childBox6_1 = new ChildBox6<>();
        Product childBox6_1Prodcut = childBox6_1.getMember();
        Number number1 = childBox6_1.getChild();
    }

    // ListBox
    private static void listTypeReflection() {
        System.out.println("List<T> collection : Reflection");
        // List = ArrayList
        ListBox<String> listArrayBox = new ListBox<String>(ArrayList.class);
        listArrayBox.add("AAA");
        System.out.println(listArrayBox.get(0));

        // List = LinkedList
        ListBox<String> listLinkedBox = new ListBox<String>(LinkedList.class);
        listLinkedBox.add("BBB");
        System.out.println(listLinkedBox.get(0));

        // List = Vector
        ListBox<String> listVectorBox = new ListBox<String>(Vector.class);
        listVectorBox.add("CCC");
        System.out.println(listVectorBox.get(0));
    }

}
