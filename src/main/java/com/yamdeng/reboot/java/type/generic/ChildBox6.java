package com.yamdeng.reboot.java.type.generic;

public class ChildBox6<T> extends Box<Product> {

    private T childMember;

    public T getChild() {
        return childMember;
    }

}
