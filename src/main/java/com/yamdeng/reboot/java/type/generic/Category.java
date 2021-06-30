package com.yamdeng.reboot.java.type.generic;

public enum Category {

    TV("TV", 1), COMPUTER("COMPUTER", 2), NONE("NONE", -1);

    private final int order;
    private final String name;

    // 생성자
    Category(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
