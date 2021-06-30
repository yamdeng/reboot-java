package com.yamdeng.reboot.java.type.generic;

import com.yamdeng.reboot.java.type.Execute;

public class ProductExecute extends Product implements Execute {

    ProductExecute() {
        super("ProductExecute", Category.NONE, 0);
    }

    @Override
    public void execute() {
        System.out.println("ProductExecute execute");
    }

}
