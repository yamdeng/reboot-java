package com.yamdeng.reboot.java.type.generic;

public class Tv extends Product {

    boolean isIpTv = false;

    Tv(String name, int price, boolean isIpTv) {
      super(name, Category.TV, price);
      this.isIpTv = isIpTv;
    }

    public Tv get() {
        return this;
    }


    public void displayTv() {
        System.out.println("displayTv : " + getCategory() + "@" + getName());
    }

    @Override
    public String toString() {
        return "Tv{" +
                "isIpTv=" + isIpTv +
                "}  " + super.toString();
    }
}
