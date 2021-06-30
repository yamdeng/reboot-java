package com.yamdeng.reboot.java.type.generic;

/*

    방법1.
    T[] elementData
    elementData = (T[]) new Object[100];

    방법2
    Object[] elementData;
    return (T) elementData[index];

 */
// 제네릭 배열
public class GenericArray {

    private static class GenericArray1<T> {

        T[] elementData;

        private int lastCurrentIndex = 0;

        public GenericArray1() {
            elementData = (T[]) new Object[100];
        }

        public void add(T item) {
            elementData[lastCurrentIndex] = item;
            lastCurrentIndex++;
        }

        public T get(int index) {
            return elementData[index];
        }

    }

    private static class GenericArray2<T> {

        Object[] elementData;

        private int lastCurrentIndex = 0;

        public GenericArray2() {
            elementData = new Object[100];
        }

        public void add(T item) {
            elementData[lastCurrentIndex] = item;
            lastCurrentIndex++;
        }

        public T get(int index) {
            return (T) elementData[index];
        }
    }

    public static void main(String[] args) {
        System.out.println("========== 제네릭 배열 ==========");
        System.out.println();

        // 제네릭 배열
        genericArray();
        System.out.println();

        System.out.println("========== GenericArray End ==========");
    }

    private static void genericArray() {
        System.out.println("제네릭 배열");
        GenericArray1<Number> integerArray = new GenericArray1<>();
        integerArray.add(10);
        integerArray.add(25.2);
        System.out.println("integerArray.get(0) : " + integerArray.get(0));
        System.out.println("integerArray.get(1) : " + integerArray.get(1));

        GenericArray2<String> stringArray = new GenericArray2<>();
        stringArray.add("AAA");
        stringArray.add("BBB");
        System.out.println("stringArray.get(0) : " + stringArray.get(0));
        System.out.println("stringArray.get(1) : " + stringArray.get(1));
    }

}
