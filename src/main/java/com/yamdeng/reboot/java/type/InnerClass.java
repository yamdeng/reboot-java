package com.yamdeng.reboot.java.type;

import com.yamdeng.reboot.java.type.hide.OuterClass;

// 내부 클래스
public class InnerClass {

    public static void main(String[] args) {
        System.out.println("========== 내부 클래스 ==========");
        System.out.println();

        // 내부 클래스 기본
        innerClass();
        System.out.println();

        System.out.println("========== InnerClass End ==========");
    }

    public static void innerClass() {
        System.out.println("내부 클래스 기본");

        OuterClass outerClass = new OuterClass();
        
        // 멤버 내부 클래스는 외부 객체를 생성한 후 접근이 가능하다
        OuterClass.MemberInnerClass memberInnerClass = outerClass.new MemberInnerClass();
        
        // 멤버 내부 클래스의 멤버 내부 클래스도 사용 가능하다
        OuterClass.MemberInnerClass.MemberInnerInnerClass memberInnerInnerClass = memberInnerClass.new MemberInnerInnerClass();
        memberInnerClass.memberMethod();
        memberInnerInnerClass.memberMethod();

        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
        OuterClass.StaticInnerClass.StaticInnerInnerClass staticInnerInnerClass = new OuterClass.StaticInnerClass.StaticInnerInnerClass();
        staticInnerClass.memberMethod();
        OuterClass.StaticInnerClass.staticMethod();

        OuterClass.staticLocalMethod("test");
    }

}
