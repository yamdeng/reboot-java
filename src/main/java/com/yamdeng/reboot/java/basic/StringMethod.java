package com.yamdeng.reboot.java.basic;

import java.util.Arrays;
import java.util.StringTokenizer;

// String 메서드
public class StringMethod {

    public static void main(String[] args) {
        System.out.println("========== Sting 메서드 ==========");
        System.out.println();

        // String 메서드
        stringMethod();
        System.out.println();
        
        // 문자열 토큰
        stringTokenizer();
        System.out.println();

        System.out.println("========== StringMethod End ==========");
    }

    public static void stringMethod() {
        System.out.println("String 메서드");
        String str1 = "hellow! welcome!";
        String str2 = "안녕하세요! 반갑습니다!";
        String str5 = "hellow! welcome!";

        // 문자열의 길이
        System.out.println("str1.length : " + str1.length()); // 15
        System.out.println("str2.length : " + str2.length()); // 12

        // 문자열 비교
        if(str1.equals("hellow! welcome!") && str1.equals(str5)) {
            System.out.println("equals method");
        }

        // index 기준으로 문자 가져오기
        char char1 = str2.charAt(2);
        System.out.println("str2.charAt(2) : " + char1); // 하

        // substring : 시작 index는 0부터 시작 종료 index는 1부터 시작
        System.out.println("str2.substring(1) : " + str2.substring(1)); // 녕하세요! 반갑습니다!
        System.out.println("str2.substring(1, 1) : " + str2.substring(1, 2)); // 녕

        // indexOf, lastIndexOf
        System.out.println("str1.indexOf(\"!\") : " + str1.indexOf("!")); // 6
        System.out.println("str1.lastIndexOf(\"!\") : " + str1.lastIndexOf("!")); // 15

        // char[]로 변환하기
        char[] str1CharArray = str1.toCharArray();
        System.out.println("str1CharArray : " + Arrays.toString(str1CharArray)); // [h, e, l, l, o, w, !,  , w, e, l, c, o, m, e, !]

        // byte[]로 변환한기
        // byte[] byteArr = str1.getBytes();
        // str1.toLowerCase(); // 소문자로 변경
        // str1.toUpperCase(); // 대문자로 변경
        // str1.compareTo(""); // 문자열 비교
        // str1.contains(""); // 문자열을 포함하고 있는지
        // str1.concat(""); // 문자열 합치기
        // str1.replaceAll("", ""); // 문자열 교체(치환)
        // str1.trim(); // 공백 문자 제거
        // String.valueOf // 기본 타입을 문자열로 변경
        // String join // 구분자를 기준으로 문자 합치기
        String[] strArr = str1.split("");
        System.out.println("str1.split(\"\") : " + Arrays.toString(strArr)); // [h, e, l, l, o, w, !,  , w, e, l, c, o, m, e, !]
        String[] strArr2 = str1.split(" ");
        System.out.println("str1.split(\" \") : " + Arrays.toString(strArr2)); // [hellow!, welcome!]
    }

    public static void stringTokenizer() {
        System.out.println("문자열 토큰");
        String str1 = "hellow! welcome!";
        StringTokenizer stoken = new StringTokenizer(str1);
        while(stoken.hasMoreTokens()) {
            System.out.println("stoken.nextToken() : " + stoken.nextToken());
        }
        String str2 = "안녕하세요!반갑습니다!AAA";
        StringTokenizer stoken2 = new StringTokenizer(str2, "!");
        while(stoken2.hasMoreTokens()) {
            System.out.println("stoken2.nextToken() : " + stoken2.nextToken());
        }
    }
}
