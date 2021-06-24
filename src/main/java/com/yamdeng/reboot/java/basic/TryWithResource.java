package com.yamdeng.reboot.java.basic;

import java.io.FileInputStream;

class AutoCloseableResource implements AutoCloseable {

    FileInputStream fis;

    AutoCloseableResource() {}

    public void read() throws Exception {
        this.fis = new FileInputStream("test3.txt");
    }

    @Override
    public void close() {
        System.out.println("AutoCloseableResource close call");
        if(true) {
            throw new RuntimeException("AutoCloseable Test");
        }
    }

}

// AutoCloseable 인터페이스를 구현하지 않은 클래스는 try ~ with ~ resource 구문을 사용할 수 없음
class NoAutoCloseableResource {

}

// try - with - resources : AutoCloseable 인터페이스
public class TryWithResource {

    public static void main(String[] args) {
        System.out.println("========== try - with - resources : AutoCloseable 인터페이스 ==========");
        System.out.println();

        // try-with-resource 이전 방식
        try {
            before();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // try-with-resource
        try {
            tryWithResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        // try-with-resource : 커스텀 AutoCloseable
        try {
            tryWithResourceCustomAutoClosable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        System.out.println("========== TryWithResource End ==========");
    }

    private static void before() throws Exception {
        System.out.println("try-with-resource 이전 방식");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("test3.txt");
        } catch(Exception e) {
            throw e;
        } finally {
            try {
                if(fis != null) {
                    System.out.println("fos != null call");
                    fis.close();
                }
                if(true) {
                    throw new RuntimeException("test");
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private static void tryWithResource() throws Exception {
        System.out.println("try-with-resource");
        try (FileInputStream fis = new FileInputStream("test3.txt")){
        } finally {
            System.out.println("tryWithResource finally");
        }
    }

    private static void tryWithResourceCustomAutoClosable() throws Exception {
        System.out.println("try-with-resource : 커스텀 AutoCloseable");
        try (AutoCloseableResource rs = new AutoCloseableResource()){
            rs.read();
        } finally {
            System.out.println("tryWithResource finally");
        }
    }

}
