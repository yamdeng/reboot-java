package com.yamdeng.reboot.java.type.generic;

import java.util.List;

public class Box<T> {

    public static <S extends String> S staticGenericMethod(S item) {
        return (S) item.toString();
    }

    public <S extends String> S instanceGenericMethod(S item) {
        return (S) item.toString();
    }

    private T member;

    private Object[] objectArray;

    private T[] typeArray;

    private List<T> list;

    public Box() {
    }

    public Box(T member) {
        this.member = member;
    }

    public T getMember() {
        return member;
    }

    public void setMember(T member) {
        this.member = member;
    }

    public void display() {
        System.out.println("Box display() : " + member.toString());
    }

}
