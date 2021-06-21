package com.yamdeng.reboot.java.type;

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
