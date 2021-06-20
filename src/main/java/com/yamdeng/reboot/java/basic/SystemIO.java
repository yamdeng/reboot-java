package com.yamdeng.reboot.java.basic;

import java.io.IOException;

// 표준 입출력
public class SystemIO {

    public static void main(String[] args) throws Exception {
        System.out.println("========== 표준 입출력 ==========");
        System.out.println();

        // System.out
        sysout();
        System.out.println();

        // System.in
        sysin();
        System.out.println();

        System.out.println("========== SystemIO End ==========");
    }

    public static void sysout() {
        /*

            표준 출력
             1.개행 문자열을 표준 출력에 전달하고 싶으면 System.out.println 메서드 사용
             2.개행이 아닌 문자열을 표준 출력에 전달하고 싶으면 System.out.print 메서드 사용
             3.System.out.print~ 메서드에서 문자열과 숫자를 더하면(+) 항상 문자열이 된다

         */
        System.out.println("표준 출력 확인");
        System.out.print("System.out.pinrt() method");
        System.out.println("System.out.pinrtln() method");

        // 5 + 3은 8을 출력
        System.out.println(5 + 3);

        // "5" + 3은 53을 출력
        System.out.println("5" + 3);
    }

    public static void sysin() throws IOException {
        /*

            표준 입력
             1.키보드 하나의 입력을 받고 싶을때 System.in.read() 사용 : 숫자는 ascii 코드와 대응됨
              -2를 입력하면 숫자 50이 전달됨
              #.아스키코드 : https://ko.wikipedia.org/wiki/ASCII

         */
        System.out.println("표준 입력 확인");
        System.out.println("input keyboard : ");
        int keyValue = System.in.read();
        System.out.println("keyValue : " + keyValue);
    }
}
