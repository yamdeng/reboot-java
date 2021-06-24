package com.yamdeng.reboot.java.type;

// 상속
public class Inheritance {

    public static void main(String[] args) {
        System.out.println("========== 상속 ==========");
        System.out.println();
        
        // 상속 기본
        inheritance();
        System.out.println();

        System.out.println("========== Inheritance End ==========");
    }

    public static void inheritance() {
        System.out.println("상속 기본");
        Parent parent1 = new Parent();
        Child child1 = new Child();
        Child child2 = new Child("Child", 30);
        System.out.println("parent1 : " + parent1);
        System.out.println("child1 : " + child1);
        System.out.println("child2 : " + child2);
        child1.displayName();
        child2.displayName();
    }
}
