package com.yamdeng.reboot.java.basic;

public class CustomException extends RuntimeException {

    String code = "";

    public CustomException(Throwable e) {
        super(e);
    }

    public CustomException(String message, Throwable e) {
        super(message, e);
    }

    public CustomException(String message, String code) {
        super(message);
        this.code = code;
    }

    public CustomException(String message) {
        super(message);
    }

}
