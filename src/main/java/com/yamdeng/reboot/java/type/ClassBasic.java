package com.yamdeng.reboot.java.type;

class Car{
    int price;
    String name;
    String year;
    boolean isNew;

    static int CarNumber = 100;

    Car() {
        System.out.println("Car constructor call");
    }

    static {
        System.out.println("Car static init block call");
        CarNumber = 200;
    }

    {
        System.out.println("Car instancel init block call");
    }

    public static void carStaticMethod() {
        System.out.println("CarNumber : " + CarNumber);
    }

    private void privateMethod() {
        System.out.println("call privateMethod");
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", isNew=" + isNew +
                '}';
    }
}

// 클래스 기본
public class ClassBasic {
    public static void main(String[] args) {
        System.out.println("========== 클래스 기본 ==========");
        System.out.println();

        // 객체 생성
        carClass();
        System.out.println();

        // 객체 배열
        carArray();
        System.out.println();

        System.out.println("========== ClassBasic End ==========");
    }

    public static void carClass() {
        System.out.println("객체 생성");
        Car car = new Car();
        Car car1 = new Car();
        System.out.println("car : " + car);
        System.out.println("car1 : " + car1);
        car.price = 100;
        car.name = "그랜져";
        car.year = "2021";
        car.isNew = true;
        System.out.println("car : " + car);
        // car.privateMethod(); // private 메서드는 자기 자신에서만 호출 허용 // 에러
        System.out.println("car price : " + car.getPrice());
        car.setPrice(200);
        System.out.println("car : " + car);
        Car.carStaticMethod();
    }

    public static void carArray() {
        System.out.println("객체 배열");
        Car[] carArr = new Car[5];
        for (Car car : carArr) {
            System.out.println("car : " + car);
        }
    }
}
