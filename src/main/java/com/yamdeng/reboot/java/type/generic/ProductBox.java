package com.yamdeng.reboot.java.type.generic;

public class ProductBox<T extends Product> {

    private T member;

    public ProductBox() {
    }

    public ProductBox(T member) {
        this.member = member;
    }

    public void setMember(T member) {
        this.member = member;
    }

    public T getMember() {
        return this.member;
    }

    public Category getCategory() {
        return member.getCategory();
    }

    public void display() {
        System.out.println("ProductBox display() : " + member.toString());
    }

}
