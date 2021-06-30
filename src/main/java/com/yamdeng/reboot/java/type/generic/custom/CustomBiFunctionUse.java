package com.yamdeng.reboot.java.type.generic.custom;

import java.util.HashMap;
import java.util.Map;

public class CustomBiFunctionUse<T, U, R extends Map<T, U>> implements CustomBiFunction<T, U, R> {

    public R apply(T t, U u) {
        Map<T, U> map = new HashMap<>();
        map.put(t, u);
        return (R) map;
    }

}
