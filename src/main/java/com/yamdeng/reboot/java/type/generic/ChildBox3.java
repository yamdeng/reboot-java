package com.yamdeng.reboot.java.type.generic;

public class ChildBox3<T> extends Box<T> {

    private T childMember;

    public T getChild() {
        return childMember;
    }

}
