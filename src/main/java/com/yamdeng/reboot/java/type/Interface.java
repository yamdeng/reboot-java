package com.yamdeng.reboot.java.type;

class Remocon implements Execute, RollBack {

    private int remoconType;
    private String name;

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

    @Override
    public String toString() {
        return "Remocon{" +
                "remoconType=" + remoconType +
                ", name='" + name + '\'' +
                '}';
    }
}

class Remocon2 implements Execute2 {

    @Override
    public void execute() {}

    @Override
    public void execute2() {}

    @Override
    public int compareTo(String str) {
        return 0;
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

        // 인터페이스 상속


        System.out.println("========== Interface End ==========");
    }

    // Execute, RollBack
    public static void basicInterface() {
        System.out.println("인터페이스");
        Execute ex = new Remocon();
        RollBack rb = new Remocon();
        ex.execute();
        ex.executeDefaultMethod();
        rb.undo();
        rb.rollBackDefaultMethod();
        Execute.staticMethod();
        System.out.println("ex : " + ex);
        System.out.println("rb : " + rb);
    }
}
