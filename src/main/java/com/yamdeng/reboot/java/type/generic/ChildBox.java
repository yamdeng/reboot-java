package com.yamdeng.reboot.java.type.generic;

public class ChildBox<T extends Product> extends Box<T> {

    public static <T extends Number, R extends String> R staticGenericMethod(T item) {
        return (R) item.toString();
    }

    public <T extends Number, R extends String> R instanceGenericMethod(T item) {
        return (R) item.toString();
    }

    private T childMember;

    public T getChild() {
        return childMember;
    }

}
