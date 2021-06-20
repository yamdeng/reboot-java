package com.yamdeng.reboot.java.basic;

// 조건문 : if, switch
public class Condition {

    public static void main(String[] args) throws Exception {
        System.out.println("========== 조건문 : if, switch ==========");
        System.out.println();

        // if, else if, else
        ifelse();
        System.out.println();

        // switch
        switchCase();

        System.out.println("========== Condition End ==========");
    }

    public static void ifelse() {
        System.out.println("if, else if, else");
        if(true) {
            System.out.println("if");
        }

        if(false) {
        } else {
            System.out.println("else");
        }

        if(false) {
        } else if(true) {
            System.out.println("else if");
        } else {
        }

        if(false) {
            System.out.println("all if");
        } else if(true) {
            System.out.println("all else if");
        } else {
            System.out.println("all else");
        }
    }

    public static void switchCase() {
        System.out.println("switch");
        int int1 = 10;
        switch(int1) {
            case 20:
                System.out.println("int1 : " + 20);
                break;
            case 10:
                System.out.println("int1 : " + 10);
                break;
            case 30:
                System.out.println("int1 : " + 30);
                break;
            default:
                System.out.println("int1 default");
        }
        char char1 = 'a';
        switch(char1) {
            case 'a':
                System.out.println("char1 : " + "a");
                break;
            case 'b':
                System.out.println("char1 : " + "d");
                break;
            case 'c':
                System.out.println("char1 : " + "c");
                break;
            default:
                System.out.println("char1 default");
        }
        String str1 = "hihi";
        switch(str1) {
            case "hihi":
                System.out.println("str1 : " + "hihi");
                break;
            case "hihi2":
                System.out.println("str1 : " + "hihi2");
                break;
            case "hihi3":
                System.out.println("str1 : " + "hihi3");
                break;
            default:
                System.out.println("str1 default");
        }
    }
}
