package com.yamdeng.reboot.java.type.generic;

public enum CpuType {

    AMD("AMD", 1), INTEL("INTEL", 2);

    private final int order;
    private final String name;

    // 생성자
    CpuType(String name, int order) {
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
