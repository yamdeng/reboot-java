package com.yamdeng.reboot.java.vo;

public enum BoardCategory {

    IT("IT", 1), SICENCE("SICENCE", 2), HEALTH("HEALTH", 3),
    MATH("MATH", 4), STUDY("STUDY", 5), FOOD("FOOD", 6);

    private final String categoryName;
    private final int orderNo;

    public static BoardCategory getBoardCategory(int orderNo) {
        if(orderNo == 1) {
            return BoardCategory.IT;
        } else if(orderNo == 2) {
            return BoardCategory.SICENCE;
        }else if(orderNo == 3) {
            return BoardCategory.HEALTH;
        }else if(orderNo == 4) {
            return BoardCategory.MATH;
        }else if(orderNo == 5) {
            return BoardCategory.STUDY;
        }else if(orderNo == 6) {
            return BoardCategory.FOOD;
        } else {
            return BoardCategory.IT;
        }
    }

    BoardCategory(String categoryName, int orderNo) {
        this.categoryName = categoryName;
        this.orderNo = orderNo;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getOrderNo() {
        return orderNo;
    }

    @Override
    public String toString() {
        return "BoardCategory{" +
                "categoryName='" + categoryName + '\'' +
                ", orderNo=" + orderNo +
                '}';
    }
}
