package com.yamdeng.reboot.java.vo;

public enum BoardPublish {

    MAJOR("MAJOR", 1), MINOR("MINOR", 2);

    private final String publishName;
    private final int orderNo;

    BoardPublish(String publishName, int orderNo) {
        this.publishName = publishName;
        this.orderNo = orderNo;
    }

    public String getPublishName() {
        return publishName;
    }

    public int getOrderNo() {
        return orderNo;
    }
}
