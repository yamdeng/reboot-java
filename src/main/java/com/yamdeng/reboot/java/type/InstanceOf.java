package com.yamdeng.reboot.java.type;

// instanceOf 연산자
public class InstanceOf {

    public static void main(String[] args) {
        System.out.println("========== instanceOf 연산자 ==========");
        System.out.println();

        // instanceOf 연산자
        instanceOf();
        System.out.println();

        System.out.println("========== InstanceOf End ==========");
    }

    public static void instanceOf() {
        System.out.println("instanceOf 연산자");
        Parent parent = new Child("Child1", 30);
        Parent parent2 = new Child("Child2", 30);
        Parent parent3 = new Parent();
        System.out.println("parent instanceof Parent : " +(parent instanceof Parent)); // true
        System.out.println("parent2 instanceof Child : " +(parent2 instanceof Child)); // true
        System.out.println("parent3 instanceof Parent : " +(parent3 instanceof Child)); // false
    }

}
