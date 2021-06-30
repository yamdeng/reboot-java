package com.yamdeng.reboot.java.type.generic;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class ListBox<T> {
    List<T> list = new ArrayList<T>();

    public ListBox() {}

    public ListBox(Class listSpecClass) {
        try {
            Constructor<?> oCon = listSpecClass.getDeclaredConstructor();
            list = (List<T>) oCon.newInstance(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void add(T item) {
        list.add(item);
    }

    T get(int index) {
        return list.get(index);
    }

    int size() {
        return list.size();
    }

    public void display() {
        System.out.println("ListBox<T> : " + list.toString());
    }

}
