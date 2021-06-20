package com.yamdeng.reboot.java.type;

class Child3 {
    Parent parent;

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public void displayName() {
        System.out.println("name : " + this.parent.getName());
    }
}

// 합성
public class Composition {

    public static void main(String[] args) {
        System.out.println("========== 합성 ==========");
        System.out.println();

        // 합성
        composition();
        System.out.println();

        System.out.println("========== Composition End ==========");
    }

    public static void composition() {
        System.out.println("합성");
        Child3 child = new Child3();
        Parent parent = new Parent();
        parent.setName("Parent custom");
        child.setParent(parent);
        child.displayName();
    }
}
