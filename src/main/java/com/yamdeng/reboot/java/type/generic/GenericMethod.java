package com.yamdeng.reboot.java.type.generic;

// 제네릭 메서드
public class GenericMethod {

    public static void main(String[] args) {
        System.out.println("========== 제네릭 메서드 ==========");
        System.out.println();

        // 제네릭 static 메서드
        genericStaticMethod();
        System.out.println();

        // 제네릭 instance 메서드
        genericInstanceMethod();
        System.out.println();

        System.out.println("========== GenericMethod End ==========");
    }

    // Box, ChildBox
    private static void genericStaticMethod() {
        System.out.println("제네릭 static 메서드");

        // Box.staticGenericMethod : <String>
        String boxResult = Box.staticGenericMethod("AAA");
        String boxResult2 = Box.<String>staticGenericMethod("BBB");
        System.out.println("boxResult : " + boxResult);
        System.out.println("boxResult2 : " + boxResult2);

        // ChildBox.staticGenericMethod : <Number, String>
        String childBoxResult = ChildBox.staticGenericMethod(10);
        String childBoxResult2 = ChildBox.<Number, String>staticGenericMethod(Double.valueOf(10.5));
        String childBoxResult3 = ChildBox.<Double, String>staticGenericMethod(Double.valueOf(66.6));
        System.out.println("childBoxResult : " + childBoxResult);
        System.out.println("childBoxResult2 : " + childBoxResult2);
        System.out.println("childBoxResult3 : " + childBoxResult3);
    }

    // Box, ChildBox
    private static void genericInstanceMethod() {
        System.out.println("제네릭 instance 메서드");
        // new Box().instanceGenericMethod : <String>
        Box box = new Box();
        String boxResult = box.instanceGenericMethod("AAA");
        String boxResult2 = box.<String>staticGenericMethod("BBB");
        System.out.println("boxResult : " + boxResult);
        System.out.println("boxResult2 : " + boxResult2);

        // new ChildBox().instanceGenericMethod : <Number, String>
        ChildBox childBox = new ChildBox();
        String childBoxResult = childBox.instanceGenericMethod(10);
        String childBoxResult2 = childBox.<Number, String>instanceGenericMethod(Double.valueOf(10.5));
        String childBoxResult3 = childBox.<Double, String>instanceGenericMethod(Double.valueOf(66.6));
        System.out.println("childBoxResult : " + childBoxResult);
        System.out.println("childBoxResult2 : " + childBoxResult2);
        System.out.println("childBoxResult3 : " + childBoxResult3);
    }

}
