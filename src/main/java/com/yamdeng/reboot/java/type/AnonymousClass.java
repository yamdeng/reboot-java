package com.yamdeng.reboot.java.type;

// 익명 클래스
public class AnonymousClass {

    public static void main(String[] args) {
        System.out.println("========== 익명 클래스 ==========");
        System.out.println();

        // 익명 클래스
        anonymousClass();
        System.out.println();

        System.out.println("========== AnonymousClass End ==========");
    }

    public static void anonymousClass() {
        System.out.println("익명 클래스");
        Parent parent = new Parent() {
            @Override
            public void display() {
                System.out.println("name : " + name);
                System.out.println("Parent anonymousClass display()");
            }
        };
        System.out.println("parent : " + parent);
        parent.display();

        Execute execute = new Execute() {
            @Override
            public void execute() {
                System.out.println("Execute execute()");
            }
        };
        execute.execute();

        ExecuteMultiple executeMultiple = new ExecuteMultiple() {
            @Override
            public void execute1() {
                System.out.println("ExecuteMultiple execute1()");
            }

            @Override
            public void execute2() {
                System.out.println("ExecuteMultiple execute2()");
            }
        };

        executeMultiple.execute1();
        executeMultiple.execute2();

    }

}
