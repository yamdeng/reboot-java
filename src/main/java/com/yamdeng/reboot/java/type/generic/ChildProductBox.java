package com.yamdeng.reboot.java.type.generic;

public class ChildProductBox<T extends Product> extends ProductBox<T> {

    private T childMember;

    public T getChild() {
        return childMember;
    }

    public void display() {
        System.out.println("ChildProductBox display() : " + getMember().toString());
    }

}
