package com.yamdeng.reboot.java.type;

interface Execute {

    static void staticMethod() {
        System.out.println("Execute.staticMethod()");
        privateStaticMethod();
    }

    private static void privateStaticMethod() {
        System.out.println("Execute.privateStaticMethod()");
    }

    default void executeDefaultMethod() {
        System.out.println("executeDefaultMethod()");
        // 호출 가능함
        execute();
    }

    public abstract void execute();
}

interface RollBack {

    default void rollBackDefaultMethod() {
        System.out.println("rollBackDefaultMethod()");
    }

    public abstract void undo();
}

class Remocon implements Execute, RollBack {

    @Override
    public void executeDefaultMethod() {
        System.out.println("executeDefaultMethod() Remocon");
        execute();
    }

    @Override
    public void execute() {
        System.out.println("execute() Remocon");
    }

    @Override
    public void undo() {
        System.out.println("undo() Remocon");
    }


}

// interface
public class Interface {

    public static void main(String[] args) {
        System.out.println("========== interface ==========");
        System.out.println();
        
        // 인터페이스 기본
        basicInterface();
        System.out.println();

        System.out.println("========== Interface End ==========");
    }

    public static void basicInterface() {
        System.out.println("인터페이스");
        Execute ex = new Remocon();
        RollBack rb = new Remocon();
        ex.execute();
        ex.executeDefaultMethod();
        rb.undo();
        rb.rollBackDefaultMethod();
        Execute.staticMethod();
    }
}
