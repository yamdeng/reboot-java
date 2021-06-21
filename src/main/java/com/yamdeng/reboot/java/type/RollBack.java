package com.yamdeng.reboot.java.type;

interface RollBack {

    default void rollBackDefaultMethod() {
        System.out.println("rollBackDefaultMethod()");
    }

    public abstract void undo();
}
