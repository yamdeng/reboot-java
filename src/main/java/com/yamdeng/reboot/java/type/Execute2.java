package com.yamdeng.reboot.java.type;

public interface Execute2 extends Comparable<String>, Execute {

    public abstract void execute2();

    @Override
    default void executeDefaultMethod() {
        System.out.println("Execute2 executeDefaultMethod()");
    }

}
