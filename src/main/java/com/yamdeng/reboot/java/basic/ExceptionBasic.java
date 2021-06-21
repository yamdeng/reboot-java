package com.yamdeng.reboot.java.basic;

// 예외
public class ExceptionBasic {

    public static void main(String[] args) {
        System.out.println("========== 예외 ==========");
        System.out.println();

        // 예외 기본 : try ~ catch ~ finally
        try {
            int result = basicException();
            System.out.println("result : " + result);
        } catch (IndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("basicException catch");
            e.printStackTrace();
        }
        System.out.println();

        // checked exception
        // try로 감싸거나 메서드에서 throws 예외를 정의하지 않으면 컴파일 에러
        try {
            checkedException();
        } catch (Exception e) {
            System.out.println("checkedException catch");
            e.printStackTrace();
        }
        System.out.println();

        // runtime exception
        // try로 감싸지 않아도 컴파일 에러가 아님
        runtimeException();
        System.out.println();

        // custom exception
        try {
//            customException();
        } catch (CustomException e) {
            e.printStackTrace();
            System.out.println("e.getCause().getMessage() : " + e.getCause().getMessage());
        }
        System.out.println();

        System.out.println("========== Exception End ==========");
    }

    public static int basicException() {
        System.out.println("예외 기본 : try ~ catch ~ finally");
        // try를 시작하지 않으면 finally로 타지 않는다
        try {
            System.out.println("Class.forName start");
            if(false) {
                return 10;
            }
            Class cls = Class.forName("java.lang.Object2");
            System.out.println("cls : " + cls.getName());
            System.out.println("Class.forName end");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println("ClassNotFoundException catch");
            e.printStackTrace();
            System.out.println("e : " + e.getMessage());
//            return;
        } catch (Exception e) {
        }finally {
            if(true) {
                return 11;
            }
            System.out.println("first finally");
        }

        try {
            System.out.println("number div start");
            if(false) {
                return 20;
            }
            int result = 10 / 0;
            System.out.println("result : " + result);
            System.out.println("number div end");
        } catch(ArithmeticException e) {
            System.out.println("ArithmeticException catch");
            e.printStackTrace();
        } finally {
            System.out.println("second finally");
            if(true) {
                return 21;
            }
        }
        System.out.println("basicException method end");
        return 100;
    }

    public static void checkedException() throws Exception {
        System.out.println("checked exception");
    }

    public static void runtimeException() throws java.lang.RuntimeException {
        System.out.println("runtime exception");
    }

    public static void customException() {
        System.out.println("custom exception");
        try {
            System.out.println("customException() method start");
            int result = 10 / 0;
            System.out.println("customException() method end");
        } catch(RuntimeException e) {
            System.out.println("customException RuntimeException catch");
            e.printStackTrace();
            throw new CustomException("Custom Error", e);
//            CustomException customException = new CustomException("Custom Error");
//            customException.initCause(e);
//            throw customException;
        }
    }

}
