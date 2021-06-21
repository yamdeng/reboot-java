package com.yamdeng.reboot.java.type.hide;


public class OuterClass {

    private static String outerStaticStr = "outerStatic";

    private String outerMemberStr = "outerMember";

    // Outer 클래스의 멤버로 사용할 수 있다
    private MemberInnerClass mi = new MemberInnerClass();
    private StaticInnerClass si = new StaticInnerClass();

    public static void staticMethod() {
        System.out.println("OuterClass outerStaticStr : " + OuterClass.outerStaticStr);
        System.out.println("StaticInnerClass outerStaticStr : " + StaticInnerClass.outerStaticStr);
        StaticInnerClass.staticMethod();
    }

    public static void staticLocalMethod(String arg) {

        String str = "local";
        // 로컬 클래스에서 메서드 블록안에 정의된 변수를 멤버의 값으로 셋팅할 수 있는데 해당 변수를 변경하면 오류가 발생한다(가능하면 final로 정의한다)
//        str = "333";
//        arg = "333";
        class LocalClass {
            private String name = str;
            private String uuid = arg;
        }

        LocalClass lc = new LocalClass();
        String nameVar = lc.name;
        System.out.println("nameVar : " + nameVar);
    }

    private void localMethod() {
        class LocalClass {
            private String localString = outerMemberStr;
        }
    }

    public static class StaticInnerClass {

        private static String outerStaticStr = "StaticInnerClass outerInnerStatic";

        private static String innerStaticStr = "StaticInnerClass innerStatic";

        private String staticMember = "StaticInnerClass staticMember";

        public static void staticMethod() {
            System.out.println("OuterClass outerStaticStr : " + OuterClass.outerStaticStr);
            System.out.println("StaticInnerClass outerStaticStr : " + outerStaticStr);
        }

        public void memberMethod() {
            System.out.println("OuterClass outerStaticStr : " + OuterClass.outerStaticStr);
            System.out.println("StaticInnerClass outerStaticStr : " + outerStaticStr);
            // 정적 내부 클래스에서는 Outer 멤버에 접근할 수 없다
            // System.out.println("outerMemberStr : " + OuterClass.this.outerMemberStr);
        }

        private void localMethod() {
            class LocalClass {
                // static 내부 클래스의 메서드에 정의시 Outer 클래스의 인스턴스 멤버에 접근할 수 없다
                // private String localString = outerMemberStr;
            }
        }

        // 정적 내부 클래스에서는 멤버 내부 클래스와 정적 내부 클래스 모두 정의 가능하다
        public static class StaticInnerInnerClass {

        }

    }

    public class MemberInnerClass {

        // 내부 멤버 클래스에서는 static 멤버 정의 X
        // private static String innerMemberStr = "innerStatic";

        // static final은 가능함
        private static final String innerMemberStr = "MemberInnerClass innerStatic";

        private String outerMemberStr = "MemberInnerClass outerMember";

        private String innerMember = "MemberInnerClass innerMember";

        // static 메서드 정의할 수 없음
//        public static void staticMethod() {
//        }

        public void memberMethod() {
            System.out.println("OuterClass outerStaticStr : " + OuterClass.outerStaticStr);
            System.out.println("StaticInnerClass outerStaticStr : " + outerStaticStr);
            System.out.println("OuterClass outerMemberStr : " + OuterClass.this.outerMemberStr);
            System.out.println("MemberInnerClass outerMemberStr : " + this.outerMemberStr);
        }

        // 내부 클래스에서는 멤버 내부 클래스는 정의할 수 있고 정적 내부 클래스는 정의할 수 없다
        public class MemberInnerInnerClass {
            private String outerMemberStr = "MemberInnerInnerClass outerMember";

            public void memberMethod() {
                System.out.println("OuterClass outerStaticStr : " + OuterClass.outerStaticStr);
                System.out.println("StaticInnerClass outerStaticStr : " + outerStaticStr);
                System.out.println("OuterClass outerMemberStr : " + OuterClass.this.outerMemberStr);
                System.out.println("MemberInnerClass outerMemberStr : " + MemberInnerClass.this.outerMemberStr);
                System.out.println("MemberInnerInnerClass outerMemberStr : " + this.outerMemberStr);
            }

        }

        private void localMethod() {
            class LocalClass {
                private String localString = outerMemberStr;
            }
        }

    }

    // 같은 패키지안에 같은 이름의 내부 클래스를 선언해도 상관없음 : 내부 클래스는 Outer 클래스의 소유이기 때문에
    public static class StaticInnerClass2 {
    }
    public class MemberInnerClass2 {
    }

}
