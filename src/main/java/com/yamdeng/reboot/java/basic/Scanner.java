package com.yamdeng.reboot.java.basic;

// Scanner
public class Scanner {

    public static void main(String[] args) {
        System.out.println("========== Scanner ==========");
        System.out.println();

        // scanner
        scanner();
        System.out.println();

        System.out.println("========== Scanner End ==========");
    }

    public static void scanner() {
        System.out.println("scanner");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("문자열을 입력해주세요 : ");
        String input = scanner.nextLine();
        System.out.println("입력한 문자열 : " + input);
    }

}
