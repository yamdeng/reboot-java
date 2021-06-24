package com.yamdeng.reboot.java.type;

abstract class Tv {
    private String name;
    private int type;
    private int amount;

    abstract public void display();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

class SamsungTv extends Tv {

    // display 메서드가 추상 메서드이므로 필수적으로 메서드를 재정의 해야 함
    @Override
    public void display() {
        System.out.println("display Samsung Tv");
    }

}

// 추상 메서드를 오버라이드 하지 않으면 추상 클래스로 선언해야 한다
abstract class LGTv extends Tv {

}

// abstract class, method
public class AbstractClass {

    public static void main(String[] args) {
        System.out.println("========== abstract class, method ==========");
        System.out.println();
        
        // 추상 클래스 / 메서드
        abstractClass();

        System.out.println("========== AbstractClass End ==========");
    }

    public static void abstractClass() {
        System.out.println("추상 클래스 / 메서드");
        // Tv tv = new Tv(); // 추상 클래스는 객체를 생성할 수 없음 // 에러
        Tv tv = new SamsungTv();
        tv.display();
    }
}
