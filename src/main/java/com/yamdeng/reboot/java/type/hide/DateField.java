package com.yamdeng.reboot.java.type.hide;

public enum DateField {
    
    DAY(3, "Day") {
        // 추상 메서드 오버라이드
        public void customDisplay() {
            System.out.println("customDisplay DAY");
        }
    }, MONTH(5, "Month") {
        // 추상 메서드 오버라이드
        public void customDisplay() {
            System.out.println("customDisplay MONTH");
        }
    }, YEAR(10, "Year") {
        // 추상 메서드 오버라이드
        public void customDisplay() {
            System.out.println("customDisplay YEAR");
        }
    };

    private final int order;
    private final String dateName;
    private static final DateField[] DATE_FIELD_ARRAY = DateField.values();

    // 추상 메서드
    abstract public void customDisplay();

    // 정적 메서드
    public static DateField getDateFiled(int arrayIndex) {
        return DATE_FIELD_ARRAY[arrayIndex];
    }

    // 생성자
    DateField(int order, String dateName) {
        this.order = order;
        this.dateName = dateName;
    }

    public int getOrder() {
        return order;
    }

    public String getDateName() {
        return dateName;
    }

    public void display() {
        System.out.println("[" + this.name() + "] : " + dateName + " , " + order);
    }

    @Override
    public String toString() {
        return dateName + ":" + order;
    }
}
