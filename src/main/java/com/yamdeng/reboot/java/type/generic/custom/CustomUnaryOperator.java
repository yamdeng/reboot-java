package com.yamdeng.reboot.java.type.generic.custom;

import java.util.function.UnaryOperator;

public interface CustomUnaryOperator<T> extends CustomFunction<T, T> {
    static <T> UnaryOperator<T> identity() {
        return t -> t;
    }
}
