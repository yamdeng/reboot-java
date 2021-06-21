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
