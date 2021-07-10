package com.yamdeng.reboot.java.type;

public interface Execute {

    public static class StaticInnerClass {

        StaticInnerClass() {

        }

    }

    class StaticInnerClass2 {

    }

    public static final String UUID = "Excute-ID";

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

    default void executeDefaultMethod2() {
        System.out.println("executeDefaultMethod()");
        // 호출 가능함
        execute();
    }

    // public은 생략 가능 하다
    public default void dfMethod() {
    }

    public abstract void execute();
}
