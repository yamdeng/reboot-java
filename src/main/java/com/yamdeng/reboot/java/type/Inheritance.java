package com.yamdeng.reboot.java.type;


class Parent {

    String id;
    String name;
    int age;

    Parent() {
        this.name = "Parent";
        System.out.println("Parent() call");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("Parent display()");
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Child extends Parent {

    String etc;

    Child() {
        System.out.println("Child() call");
    }

    Child(String name, int age) {
        super();
        this.name = name;
    }

    public void displayName() {
        System.out.println("this.name : " + this.name);
        System.out.println("super.name : " + super.name);
    }

    @Override
    public String toString() {
        return "Child{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", etc=" + etc +
                '}';
    }
}

// 상속
public class Inheritance {

    public static void main(String[] args) {
        System.out.println("========== 상속 ==========");
        System.out.println();
        
        // 상속 기본
        basicInheritance();
        System.out.println();

        System.out.println("========== Inheritance End ==========");

    }

    public static void basicInheritance() {
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
