package com.yamdeng.reboot.java.type.generic;

import com.yamdeng.reboot.java.type.Execute;
import com.yamdeng.reboot.java.type.RollBack;

public class ProductExecuteBox<T extends Product & Execute> {

    private T member;

    public ProductExecuteBox() {
    }

    public ProductExecuteBox(T member) {
        this.member = member;
    }

    public void setMember(T member) {
        this.member = member;
    }

    public T getMember() {
        return this.member;
    }

    public void display() {
        System.out.println("ProductExecuteBox display() : " + member.toString());
    }

}
