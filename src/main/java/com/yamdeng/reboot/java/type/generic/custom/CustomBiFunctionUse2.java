package com.yamdeng.reboot.java.type.generic.custom;

import java.util.function.BiFunction;

public class CustomBiFunctionUse2 implements BiFunction<Integer, Integer, String> {

    @Override
    public String apply(Integer t, Integer u) {
        return t.intValue() + u.intValue() + "";
    }

}
