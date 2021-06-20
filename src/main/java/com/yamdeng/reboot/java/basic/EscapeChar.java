package com.yamdeng.reboot.java.basic;

/*

    escape 문자
     -tab : \t
     -backspace : \b
     -form feed : \f
     -new line : \n
     -carriage return : \r
     -역슬래쉬(\) : \\
     -작은따옴표 : \'
     -큰따옴표 : \"

 */

// 특수 문자
public class EscapeChar {

    public static void main(String[] args) {
        System.out.println("========== 특수 문자 ==========");
        System.out.println();

        // escape
        escape();
        System.out.println();

        System.out.println("========== EscapeChar End ==========");
    }

    public static void escape() {
        System.out.println("escape");
        char char1 = '\'';
        char char2 = '\"';
        char char3 = '\\';
        char char4 = '/';
        System.out.println("char1 : " + char1); // '
        System.out.println("char2 : " + char2); // "
        System.out.println("char3 : " + char3); // \
        System.out.println("char4 : " + char4); // /
        String string1 = "hi/hi";
        String string2 = "hi\\hi";
        String string3 = "hi\'hi\'";
        String string4 = "hi\"hi\"";
        System.out.println("string1 : " + string1); // hi/hi
        System.out.println("string2 : " + string2); // hi\hi
        System.out.println("string3 : " + string3); // hi'hi'
        System.out.println("string4 : " + string4); // hi"hi"
    }

}
