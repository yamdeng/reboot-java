package com.yamdeng.reboot.java.type.generic;

// 제네릭 타입 캐스팅
public class GenericCasting {

    // Product
    public static <T> T method1(T item) {
        return item;
    }

    // Box, Product
    public static <T extends Product> T method2(Box<T> box) {
        // 제네릭 타입/메서드 내부에서 사용될때 타입<T>에 제한을 걸었으면 자동 형변환이 된다
        Product prodcut = box.getMember();
//        return prodcut; // 오류 : <T extends Product> 제한을 걸었어도 반환 타입이 T라면 형변환은 필수로 해줘야 한다
        return (T) prodcut;
    }


    // Box, Product
    public static <T extends Product> T method3(Box<? extends Product> box) {
        Product product = box.getMember();
        return (T) product;
    }

    // Box, Product
    public static <T extends Product> T method4(Box<? super Product> box) {
        Object product = box.getMember();
        return (T) box.getMember();
    }

    // Box, Product
    public static <T extends Product> Product method5(Box<? super T> box) {
        Object product = box.getMember();
        return (T) product;
    }

    public static void main(String[] args) {
        System.out.println("========== 제네릭 타입 캐스팅 ==========");
        System.out.println();

        // 제네릭 타입 캐스팅 기본, instanceof
        basicCasting();
        System.out.println();

        // 제네릭 메서드 내부에서 <T> 사용시 캐스팅
        methodCastingCase();
        System.out.println();

        System.out.println("========== GenericCasting End ==========");
    }

    private static void basicCasting() {
        System.out.println("제네릭 타입 캐스팅 기본");

        // raw 타입은 모든 제네릭 타입의 상위 타입이다
        Object obj = null;
        Box rawBox = null;
        Box<Object> objectBox = null;
        Box<Product> productBox = null;
        Box<? extends Object> allBox = null;
        Box<? extends Product> extendBox = null;
        Box<? super Product> superBox = new Box<Object>();
        rawBox = allBox;
        rawBox = objectBox;
        rawBox = extendBox;
        rawBox = superBox;
        
        // raw 타입의 하위 제네릭 타입은 캐스팅을 하지 않아도 raw 타입을 받을 수 있다
        allBox = rawBox;
        objectBox = rawBox;
        productBox = rawBox;
        extendBox = rawBox;
        superBox = rawBox;

        // <?> 타입은 raw 타입처럼 모든 타입을 받을 수 있다
        allBox = objectBox;
        allBox = productBox;
        allBox = extendBox;
        allBox = superBox;


        // 대입 받는 쪽이 와일드 카드 아닌 고정된 제네릭 타입이고 대입을 하는 쪽이 와일드 카드 타입이라면 자동 캐스팅이 되지 않는다(대입 받는 타입 = 대입 하는 타입 : Box<Object> obj = Box<? extends ?>)
        // (Box<Object>) Box<?> : <?>는 무엇도 대체할 수 있으니 캐스팅을 허용한다
        // (Box<Object)) Box<Product> : 명시된 타입끼리는 형변환이 되지 않는다
        // (Box<Object>) Box<? extends Product> : 타입 범위에 맞지 않으면 캐스팅 자체가 되지 않는다
        // (Box<Product>) Box<? extends Product> : 타입 범위에 맞으면 캐스팅 허용
        // (Box<Tv>) Box<? super Product> : 타입 범위에 맞지 않으면 캐스팅 자체가 되지 않는다
        // (Box<Object>) Box<? super Product> : 타입 범위에 맞으면 캐스팅 허용
        // (Box<? super Object>) Box<? extends Product> : 타입 범위에 맞지 않으면 캐스팅 자체가 되지 않는다

//        objectBox = allBox; // 오류
//        objectBox = productBox; // 오류
//        objectBox = extendBox; // 오류
//        objectBox = superBox; // 오류

        objectBox = (Box<Object>)allBox;
//        objectBox = (Box<Object>)productBox; // 오류 : 명시된 타입끼리는 형변환이 되지 않는다
//        objectBox = (Box<Object>)extendBox; // 오류 : 타입 범위에 맞지 않으면 캐스팅 자체가 되지 않는다
        objectBox = (Box<Object>)superBox;
//        obj = (Box<Tv>) superBox; // 오류 : 타입 범위에 맞지 않으면 캐스팅 자체가 되지 않는다


//        productBox = allBox; // 오류
//        productBox = objectBox; // 오류
//        productBox = extendBox; // 오류
//        productBox = superBox; // 오류

        productBox = (Box<Product>) allBox;
//        productBox = (Box<Product>) objectBox; // 오류 : 명시된 타입끼리는 형변환이 되지 않는다
        productBox = (Box<Product>) extendBox;
        productBox = (Box<Product>) superBox;


//        extendBox = allBox; // 오류
//        extendBox = objectBox; // 오류
        extendBox = productBox;
//        extendBox = superBox; // 오류

        extendBox = (Box<? extends Product>) allBox;
//        extendBox = (Box<? extends Product>) objectBox; // 오류 : 타입 범위에 맞지 않으면 캐스팅 자체가 되지 않는다
        extendBox = (Box<? extends Product>) productBox;
        extendBox = (Box<? extends Product>) superBox;
//        extendBox = (Box<? super Product>) superBox; // 오류

        superBox = (Box<? super Product>) allBox;
        superBox = objectBox;
        superBox = productBox;
        superBox = (Box<? super Product>) extendBox;
//        superBox = (Box<? extends Product>) extendBox; // 오류

        // instanceof
        boolean b1 = rawBox instanceof Box;
        boolean b2 = rawBox instanceof Box<?>;
        // boolean b3 = rawBox instanceof Box<? extends Object>; // 오류 : Box<?>와 Box<? extends Object>는 동일하지만 캐스팅 연산은 <?> 만 허용한다
        // boolean b4 = rawBox instanceof Box<Object>; // 오류
    }

    private static void methodCastingCase() {
        System.out.println("제네릭 메서드 내부에서 <T> 사용시 캐스팅");
        Tv tv = new Tv("Samsung", 100, false);
        Product product = GenericCasting.method1(tv);
        System.out.println("method1 : " + product);

        tv = new Tv("Lg", 100, true);
        Box<Product> productBox = new Box<>();
        productBox.setMember(tv);
        product = GenericCasting.method2(productBox);
        System.out.println("method2 : " + product);

        tv = new Tv("Sony", 100, true);
        productBox.setMember(tv);
        product = GenericCasting.method3(productBox);
        System.out.println("method3 : " + product);

        tv = new Tv("Apple", 100, true);
        productBox.setMember(tv);
        product = GenericCasting.method4(productBox);
        System.out.println("method4 : " + product);

        tv = new Tv("Google", 100, true);
        productBox.setMember(tv);
        product = GenericCasting.method5(productBox);
        System.out.println("method5 : " + product);
    }

}
