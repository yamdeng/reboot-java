package com.yamdeng.reboot.java.type;

import java.util.Objects;

class ObjectVo {
    private Child child;
    private String name;
    private String address;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjectVo)) return false;
        ObjectVo objectVo = (ObjectVo) o;
        return age == objectVo.age && child.equals(objectVo.child) && name.equals(objectVo.name) && address.equals(objectVo.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(child, name, address, age);
    }

    @Override
    public String toString() {
        return "ObjectVo{" +
                "child=" + child +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}

// 최상위 클래스 Object
public class ObjectBasic {

    public static void main(String[] args) {
        System.out.println("========== 최상위 클래스 Object ==========");
        System.out.println();

//        Objects.equals();
//        Objects.hash();
//        Objects.toString();
//        Objects.hashCode();
//        Objects.compare();
//        Objects.deepEquals();
//        Objects.isNull();
//        Objects.nonNull();
//        Objects.requireNonNull();
//        System.identityHashCode();

        System.out.println("========== ObjectBasic End ==========");
    }
}
