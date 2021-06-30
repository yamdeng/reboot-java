package com.yamdeng.reboot.java.type.hide;

import java.util.Comparator;

public class DateFieldComparator implements Comparator<DateField> {

    @Override
    public int compare(DateField d1, DateField d2)
    {
        return d2.getOrder() - d1.getOrder();
    }

}
