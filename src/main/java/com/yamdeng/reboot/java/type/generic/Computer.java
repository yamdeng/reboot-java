package com.yamdeng.reboot.java.type.generic;

public class Computer extends Product  {
    CpuType cpuType;

    Computer(String name, int price, CpuType cpuType) {
        super(name, Category.COMPUTER, price);
        this.cpuType = cpuType;
    }

    public void displayComputer() {
        System.out.println("displayComputer : " + getCategory() + "@" + getName());
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpuType=" + cpuType +
                "}  " + super.toString();
    }
}
