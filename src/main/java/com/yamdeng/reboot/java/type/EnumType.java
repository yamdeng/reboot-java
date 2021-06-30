package com.yamdeng.reboot.java.type;

import com.yamdeng.reboot.java.type.hide.DateField;
import com.yamdeng.reboot.java.type.hide.DateFieldComparator;

enum Direction {

    EAST, WEST, NORTH, SOUTH

}

// Enum Type
public class EnumType {

    public static void main(String[] args) throws Exception {
        System.out.println("========== Enum Type ==========");
        System.out.println();

        // enum 기본
        basicEnum();
        System.out.println();

        // enum 생성자 / static, 멤버, 추상 메서드 : com.yamdeng.type.hide.DateField 참고
        constructorAndMethod();
        System.out.println();

        // enum type 정렬
        customSortToComparator();
        System.out.println();

        System.out.println("========== EnumType End ==========");
    }

    private static void customSortToComparator() {
        DateField day = DateField.DAY;
        DateField month = DateField.MONTH;
        DateFieldComparator comparator = new DateFieldComparator();
        System.out.println("compare result : " + comparator.compare(day, month));
    }

    private static void basicEnum() {
        System.out.println("enum 기본");

        Direction east = Direction.EAST;
        Direction west = Direction.WEST;
        Direction north = Direction.NORTH;
        Direction south = Direction.SOUTH;

        // 기본 display, ordinal(순서)
        System.out.println("east : " + east + " hashCode : " + east.hashCode()); // EAST
        System.out.println("west : " + west.name()); // WEST
        System.out.println("north : " + north.toString()); // NORTH
        System.out.println("south : " + south.ordinal()); // 3

        // 팩토리 방식으로 객체 생성
        Direction west2 = Direction.valueOf("WEST");
        Direction east2 = Enum.valueOf(Direction.class, "EAST");
        System.out.println("east2 : " + east2.name() + " hashCode : " + east2.hashCode()); // EAST
        System.out.println("west2 : " + west2.name()); // WEST

        // enum type 끼리 비교 : enum은 싱글톤임
        System.out.println("east == east : " + (east == east)); // true
        System.out.println("east == east2 : " + (east == east2)); // true
        System.out.println("east.equals(east2) : " + (east.equals(east2))); // true

        // enum을 compareTo로 비교
        System.out.println("east.compareTo(east2) : " + east.compareTo(east2)); // 0
        System.out.println("east.compareTo(west) : " + east.compareTo(west)); // -1

        // EnumType.values() 정적 메서드
        Direction[] directionArray = Direction.values();
        for (Direction direction : directionArray) {
            System.out.println("direction : " + direction.name());
        }

        // switch 문에 enum 타입을 전달
        switch(east) {
            case EAST:
                System.out.println("switch value EAST");
                break;
            case WEST:
                System.out.println("switch value WEST");
                break;
            default:
                break;
        }
    }

    private static void constructorAndMethod() {
        System.out.println("enum 생성자 / static, 멤버, 추상 메서드 : com.yamdeng.type.hide.DateField 참고");
        DateField day = DateField.DAY;
        DateField month = DateField.MONTH;
        DateField year = DateField.YEAR;

        // 기본 display, ordinal(순서), 커스텀 메서드 : getOrder, getDateName
        System.out.println("day : " + day + " hashCode : " + day.hashCode()); // DAY
        System.out.println("day getDateName : " + day.getDateName() + " getOrder : " + day.getOrder()); // Day, 3
        System.out.println("month : " + month.name()); // MONTH
        System.out.println("month : " + month.toString()); // MONTH
        System.out.println("year : " + year.ordinal()); // 2

        DateField day2 = DateField.DAY;
        System.out.println("day2 getDateName : " + day2.getDateName() + " getOrder : " + day2.getOrder()); // Day, 3
        System.out.println("day == day2 : " + (day == day2)); // true

        // 정적 메서드
        System.out.println("day == DateField.getDateFiled(0) : " + (day == DateField.getDateFiled(0))); // true

        // 멤버 메서드
        day.display();;
        
        // 추상 메서드
        day.customDisplay();
        month.customDisplay();
    }

}

