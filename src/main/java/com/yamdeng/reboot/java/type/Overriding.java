package com.yamdeng.reboot.java.type;

import java.io.IOException;

class Parent2 {

    String id;
    String name;
    int age;

    public void display() {
        System.out.println("Parent display()");
    }

    public void display2() throws RuntimeException {
        System.out.println("Parent display2()");
    }

    @Override
    public String toString() {
        return "Parent2{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Child2 extends Parent2 {

    String etc;

    @Override
    public void display() {
        System.out.println("Child display()");
    }

    @Override
    public void display2() throws NullPointerException {
        System.out.println("Child display2()");
    }

    @Override
    public String toString() {
        return "Child2{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", etc=" + etc +
                '}';
    }

}

// 오버라이딩
public class Overriding {

    public static void main(String[] args) {
        System.out.println("========== 오버라이딩 ==========");
        System.out.println();

        // 오버라이딩
        overriding();
        System.out.println();

        System.out.println("========== Overriding End ==========");
    }

    public static void overriding() {
        Parent2 parent = new Parent2();
        Child2 child = new Child2();
        Parent2 child2 = new Child2();
        parent.display(); // Parent display()
        child.display(); // Child display()
        child2.display(); // Child display()
        child.display2(); // Child display2()
        child2.display2(); // Child display2()
    }
}
