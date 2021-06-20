package com.yamdeng.reboot.java.type;

// 다형성
public class PolyMorphism {

    public static void main(String[] args) {
        System.out.println("========== 다형성 ==========");
        System.out.println();

        // 클래스 다형성
        classPolyMor();

        // 인터페이스 다형성
        interfacePolyMor();
        
        // 메서드 매개변수, 반환타입 다형성
        RollBack rb = methodParameterReturnPolyMor(new Child("Child test", 30));
        rb.undo();

        // 배열 다형성
        arrayPolyMor();

        System.out.println("========== PolyMorphism End ==========");
    }

    public static void classPolyMor() {
        System.out.println("클래스 다형성");
        Parent parent = new Child();
        parent.display();
    }

    public static void interfacePolyMor() {
        System.out.println("인터페이스 다형성");
        Execute ex = new Remocon();
        ex.execute();
    }

    public static RollBack methodParameterReturnPolyMor(Parent parent) {
        System.out.println("메서드 매개변수, 반환타입 다형성");
        parent.display();
        return new Remocon();
    }

    public static void arrayPolyMor() {
        System.out.println("배열 다형성");
        Parent[] parentArr = {new Child(), new Child(), new Child("test", 30)};
        Execute[] executeArr = {new Remocon(), new Remocon(), new Remocon()};
        for (Parent parent : parentArr) {
            System.out.println("parent : " + parent);
        }
        for (Execute execute : executeArr) {
            System.out.println("execute : " + execute);
        }
    }
}
