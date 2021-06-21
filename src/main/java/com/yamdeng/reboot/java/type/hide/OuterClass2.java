package com.yamdeng.reboot.java.type.hide;

public class OuterClass2 implements OuterInterface.InnerInterface2 {

    private static final String name = "OuterClass2";

    private String uuid = "OuterClass2-UUID";

    @Override
    public void innerInterfaceMethod() {}

    interface InnerInterface {

        public static final String INNER_INTERFACE_ID = "INNER_INTERFACE-ID";

        static void staticMethod() {
            System.out.println("name : " + name);
        }

        void method();

        default void defaultMethod() {
            System.out.println("defaultMethod()");
            System.out.println("name : " + name);
        }

    }

}
