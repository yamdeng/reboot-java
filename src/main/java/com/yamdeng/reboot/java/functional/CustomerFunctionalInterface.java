package com.yamdeng.reboot.java.functional;

// 함수형 인터페이스 커스텀
public class CustomerFunctionalInterface {

    @FunctionalInterface
    private interface CustomIO<P1, P2, R> {

        public R toGet(P1 p1, P2 p2);

        public static <P1, P2, R> CustomIO<P1, P2, R> getCustomerIo(P1 p1, P2 p2) {
            return (t1, t2) -> (R) (p1.toString() + p2.toString());
        }

        default public void defaultMethod(P1 p1, P2 p2) {
            System.out.println("CustomIO defaultMethod call");
            System.out.println("defaultMethod P1 : " + p1);
        }
    }

    public static void main(String[] args) {
        System.out.println("========== 함수형 인터페이스 커스텀 ==========");
        System.out.println();
        
        // @FunctionalInterface 인터페이스 정의
        basicCustomFunctionalInterface();
        System.out.println();

        System.out.println("========== CustomerFunctionalInterface End ==========");
    }

    private static void basicCustomFunctionalInterface() {
        System.out.println("@FunctionalInterface 인터페이스 정의");
        CustomIO<Integer, Integer, Double> customIO = new CustomIO<>() {
            @Override
            public Double toGet(Integer i1, Integer i2) {
                return (i1 + i2) * 0.1;
            }
        };
        double doubleResult = customIO.toGet(10, 20);
        System.out.println("doubleResult : " + doubleResult);
        
        // 디폴트 메서드 호출
        customIO.defaultMethod(30, 40);
        
        // static 메서드 호출
        CustomIO<Integer, Integer, String> customIO2 = CustomIO.getCustomerIo(10, 20);
        String stringResult = customIO2.toGet(100, 200);
        System.out.println("stringResult : " + stringResult);
    }

}
