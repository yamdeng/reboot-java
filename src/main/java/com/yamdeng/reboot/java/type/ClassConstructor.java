package com.yamdeng.reboot.java.type;

class Car2 {
    private int price;
    private String name;
    private String year;
    private boolean isNew;

    Car2() {
        isNew=true;
        year="2021";
    }

    Car2(String name, int price) {
        this();
        this.name = name;
        this.price = price;
    }
    
    // 복사 생성자
    Car2(Car2 car) {
        this.price = car.price;
        this.name = car.name;
        this.year = car.year;
        this.isNew = car.isNew;
    }

    @Override
    public String toString() {
        return "Car2{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", isNew=" + isNew +
                '}';
    }
}

// 생성자
public class ClassConstructor {
    public static void main(String[] args) {
        System.out.println("========== 생성자 ==========");
        System.out.println();

        // 생성자
        constructor();
        System.out.println();

        System.out.println("========== ClassConstructor End ==========");
    }

    public static void constructor() {
        System.out.println("생성자");
        
        // 같은 패키지여서 호출이 가능하다
        Car car = new Car();
        Car2 car2 = new Car2();
        Car2 parameterCar2 = new Car2("그랜져", 1000);
        Car2 copyCar = new Car2(car2);
    }
}
