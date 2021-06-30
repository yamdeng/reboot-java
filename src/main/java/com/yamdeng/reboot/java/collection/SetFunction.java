package com.yamdeng.reboot.java.collection;

import com.yamdeng.reboot.java.util.YamdengCollectionUtil;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// Set 인터페이스
public class SetFunction {

    private static class SetVo {
        String name;
        String key;
        String value;

        public SetVo(String name, String key, String value) {
            this.name = name;
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "SetVo{" +
                    "name='" + name + '\'' +
                    ", key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    private static class SetVo2 {
        String name;
        String key;
        String value;

        public SetVo2(String name, String key, String value) {
            this.name = name;
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "SetVo2{" +
                    "name='" + name + '\'' +
                    ", key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SetVo2)) return false;
            SetVo2 setVo = (SetVo2) o;
            return Objects.equals(name, setVo.name) && Objects.equals(key, setVo.key) && Objects.equals(value, setVo.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, key, value);
        }
    }

    public static void main(String[] args) {
        System.out.println("========== Set 인터페이스 ==========");
        System.out.println();

        // HashSet
        hashSetFunction();
        System.out.println();

        System.out.println("========== SetFunction End ==========");
    }

    private static void hashSetFunction() {
        System.out.println("hashSetFunction");
        Set<String> stringSet = new HashSet<>();
        stringSet.add("AAA");
        stringSet.add("BBB");
        stringSet.add("AAA");
        stringSet.forEach(value -> System.out.println("value : " + value));
        YamdengCollectionUtil.iteratorToString(stringSet, "stringSet");

        Set<SetVo> voSet = new HashSet<>();
        voSet.add(new SetVo("AAA", "BBB", "CCC"));
        voSet.add(new SetVo("AAA", "BBB", "CCC"));
        voSet.add(new SetVo("AAA", "BBB", "CCC"));
        YamdengCollectionUtil.iteratorToString(voSet, "voSet");

        // hashCode, equals를 오버라이딩 했을때 : 중복 제거를 해줌
        Set<SetVo2> voSet2 = new HashSet<>();
        voSet2.add(new SetVo2("AAA", "BBB", "CCC"));
        voSet2.add(new SetVo2("AAA", "BBB", "CCC"));
        voSet2.add(new SetVo2("AAA", "BBB", "CCC"));
        YamdengCollectionUtil.iteratorToString(voSet2, "voSet2");
    }
}
