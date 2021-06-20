package com.yamdeng.reboot.java.type.hide;

import com.yamdeng.reboot.java.type.hide.vo.CommandVo;

class CustomCommandVo extends CommandVo {

}

public class Encapsulation {

    public static void main(String[] args) {
        System.out.println("========== 패키지 / 캡슐화 ==========");
        System.out.println();

        //접근 제어자
        accessModifier();

        System.out.println("========== Encapsulation End ==========");
    }

    public static void accessModifier() {
        System.out.println("접근 제어자");
        CommandVo cmdVo = new CommandVo();
        // CommandDTO dto = new CommandDTO(); // public class가 아니므로 객체 생성 불가함
        // ResultVo retVo = new ResultVo(); // ResultVo class는 public class가 아니여서 같은 패키지가 아니므로 접근이 불가함
    }

}
