package com.yamdeng.reboot.java.basic;

// 반복문 : for, while, do while
public class Repeat {

    public static void main(String[] args) throws Exception {
        System.out.println("========== 반복문 : for, while, do while ==========");
        System.out.println();

        // for 문
        forStatement();
        System.out.println();

        // while 문
        whileStatement();
        System.out.println();

        // doWhile 문
        doWhileStatement();
        System.out.println();

        // goto 문
        gotoLabel();
        System.out.println();

        System.out.println("========== Repeat End ==========");
    }

    public static void forStatement() {
        System.out.println("for 문");
        int index=0;
        for(; index<3; index++) {
            System.out.println("index : " + index);
        }

        for(int index2=0, maxLength=3; index2<maxLength; index2++) {
            System.out.println("index2 : " + index2);
        }

        for(index=0; index<3; index++) {
            if(index == 0){
                continue;
            }
            System.out.println("index : " + index);
        }

        for(index=0; index<3; index++) {
            if(index == 1){
                break;
            }
            System.out.println("index : " + index);
        }
    }

    public static void whileStatement() {
        System.out.println("while 문");
        int index=0;
        while(index<3) {
            System.out.println("index : " + index);
            index = index + 1;
        }

        index=0;
        while(index<3) {
            if(index == 1) {
                index = index + 1;
                continue;
            }
            System.out.println("index continue : " + index);
            index = index + 1;
        }

        index=0;
        while(index<3) {
            if(index == 1) {
                break;
            }
            System.out.println("index break : " + index);
            index = index + 1;
        }
    }

    public static void doWhileStatement() {
        System.out.println("doWhile 문");
        int index=0;
        do {
            System.out.println("index : " + index);
            index = index + 1;
        } while(index<3);
    }

    public static void gotoLabel() {
        System.out.println("goto 문");
        int outerIndex=0;
        int innerIndex=0;
        Outer:
        for(; outerIndex<3; outerIndex++) {
            for(innerIndex=0; innerIndex<3; innerIndex++) {
                if(innerIndex == 1) {
                    break Outer;
                }
                System.out.println("outerIndex : " + outerIndex + " @ innerIndex : " + innerIndex);
            }
        }
    }

}
