package com.yamdeng.reboot.java.collection;


import com.google.common.collect.Collections2;
import com.yamdeng.reboot.java.util.YamdengCollectionUtil;

import java.util.*;
import java.util.stream.Collectors;

// List 인터페이스 : Vector, ArrayList, LinkedList
public class ListFunction {

    private static class StringComparator implements Comparator<String> {

        @Override
        public int compare(String str1, String str2)
        {
            return str2.compareTo(str1);
        }

    }

    private static class ListVoComparator implements Comparator<ListVo> {

        @Override
        public int compare(ListVo vo1, ListVo vo2)
        {
            return vo2.compareTo(vo1);
        }

    }

    private static class ListVo implements Comparable<ListVo> {
        String name;
        String key;
        String value;

        public ListVo(String name, String key, String value) {
            this.name = name;
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(ListVo object) {
            return this.name.compareTo(object.name);
        }

        @Override
        public String toString() {
            return "ListVo{" +
                    "name='" + name + '\'' +
                    ", key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println("========== List 인터페이스 : Vector, ArrayList, LinkedList ==========");
        System.out.println();

        // list Function
        listFunction();
        System.out.println();

        // list generic Function
        listGenericFunction();
        System.out.println();

        // list iterator
        listIteratorFunction();
        System.out.println();

        // list remove
        listRemoveFunction();
        System.out.println();

        // list etc Function
        listEtcFunction();
        System.out.println();

        // list sort
        listSort();
        System.out.println();

        System.out.println("========== ListFunction End ==========");
    }

    // add(object), add(index, object), addElement, size, get, set, elementAt, capacity, ensureCapacity, insertElementAt, isEmpty, clear, elements(Enumeration)
    // firstElement, lastElement, forEach, indexOf, lastIndexOf
    private static void listFunction() {
        System.out.println("list Function");

        // raw 타입으로 Vector 생성 : add, addElement, size, capacity, ensureCapacity, get, set
        Vector rawVector = new Vector();
        rawVector.add(new Object());
        rawVector.add("rawVector test");
        rawVector.add(1, "before rawVector test");
        rawVector.addElement("rawVector test2");
        long rawVectorSize = rawVector.size();
        long rawVectorCapacity = rawVector.capacity();
        System.out.println("rawVector size : " + rawVectorSize);
        System.out.println("rawVector capacity : " + rawVectorCapacity);
        System.out.println("rawVector.get(0) : " + rawVector.get(0));
        System.out.println("rawVector.elementAt(0) : " + rawVector.elementAt(0));
        rawVector.set(0, new Object() {
                    @Override
                    public String toString() {
                        return "new Object";
                    }
                }
        );
        System.out.println("rawVector.get(0) set after : " + rawVector.get(0));
        rawVector.ensureCapacity(200);
        rawVectorCapacity = rawVector.capacity();
        System.out.println("rawVector capacity after: " + rawVectorCapacity);

        // insertElementAt, clean, isEmpty
        YamdengCollectionUtil.repeatIterator(rawVector, "rawVector step1");
        rawVector.insertElementAt("rawVector test1", 0);
        YamdengCollectionUtil.repeatIterator(rawVector, "rawVector step2");
        rawVector.insertElementAt("rawVector test5", 4);
        YamdengCollectionUtil.repeatIterator(rawVector, "rawVector step3");
        System.out.println("rawVector isEmpty : " + rawVector.isEmpty());
        rawVector.clear();
        System.out.println("rawVector clear after isEmpty : " + rawVector.isEmpty());

        // elements(Enumeration)
        Enumeration rawVectorEnumeration = rawVector.elements();
        while(rawVectorEnumeration.hasMoreElements()) {
            Object value = rawVectorEnumeration.nextElement();
            System.out.println("rawVectorEnumeration value : " + value.toString());
        }

        Vector<String> stringVector = new Vector<String>();
        Enumeration<String> stringVectorEnumeration = stringVector.elements();
        while(stringVectorEnumeration.hasMoreElements()) {
            String value = stringVectorEnumeration.nextElement();
            System.out.println("stringVectorEnumeration value : " + value.toString());
        }

        // firstElement, lastElement
        rawVector.add("AAA");
        rawVector.add("CCC");
        System.out.println("rawVector.firstElement() : " + rawVector.firstElement());
        System.out.println("rawVector.lastElement() : " + rawVector.lastElement());

        stringVector.add("test string");
        stringVector.add("last string");
        System.out.println("stringVector.firstElement() : " + stringVector.firstElement());
        System.out.println("stringVector.lastElement() : " + stringVector.lastElement());

        // for, forEach
        for(String value : stringVector) {
            System.out.println("foreach value : " + value.toUpperCase());
        }
        rawVector.forEach(value -> {
            System.out.println("rawVector : " + value.toString());
        });
        stringVector.forEach(value -> {
            System.out.println("stringVector : " + value.toUpperCase());
        });

        // indexOf, lastIndexOf
        stringVector.clear();
        stringVector.add("AAA");
        stringVector.add("BBB");
        stringVector.add("CCC");
        stringVector.add("AAA");
        stringVector.add("BBB");
        stringVector.add("AAA");
        stringVector.add("BBB");
        stringVector.add("ZZZ");
        System.out.println("stringVector.indexOf(\"AAA\") : " + stringVector.indexOf("AAA"));
        System.out.println("stringVector.indexOf(\"ZZZ\") : " + stringVector.indexOf("ZZZ"));
        System.out.println("stringVector.indexOf(\"AAA\", 1) : " + stringVector.indexOf("AAA", 4));
        System.out.println("stringVector.lastIndexOf(\"AAA\") : " + stringVector.lastIndexOf("AAA"));
        System.out.println("stringVector.lastIndexOf(\"AAA\") : " + stringVector.lastIndexOf("AAA", 1));

        // LinkedList
        List<String> listInterface = new LinkedList<>();
        listInterface.add("AAA");
        listInterface = new ArrayList<>();
        listInterface = new Vector<>();
    }

    // generic, 다형성, clone, equals, toArray, copyInto
    private static void listGenericFunction() {
        System.out.println("list generic Function");
        
        // raw 타입에는 아무거나 다 넣을 수 있음
        Vector rawVector = new Vector();
        rawVector.add(new Object());
        rawVector.add("test");

        // 제네릭 타입<T>으로 Vector 생성
        Vector<Object> objectVector = new Vector<Object>();
        objectVector.add(new Object());
        objectVector.add("object test");

        Vector<String> stringVector = new Vector<>(); // Vector<String>() === Vector<>() === Vector()
//         stringVector.add(new Object()); // 오류 : String 타입 포함 하위 타입만 요소로 넣을 수 있음
        stringVector.add("test11");

        Vector<Number> numberVector = new Vector<Number>();
//        Vector<Number> numberVector2 = new Vector<Integer>(); // 오류 : 와일드 카드를 사용하지 않으면 계층 구조의 타입으로 정의해도 오류
        numberVector.add(new Integer(20));
        numberVector.add(Integer.valueOf(30));
        numberVector.add(Double.valueOf(10.25));
        numberVector.add(10); // 오토박싱
        int numberValue = (int) numberVector.get(3); // 언박싱 : 캐스팅 연산자 필요

        Vector<Integer> integerVector = new Vector<>();
        integerVector.add(100); // 오토박싱
        int intValue = integerVector.get(0); // 언박싱 : 캐스팅 연산자 필요 없음

        rawVector.addAll(stringVector);
        stringVector.addAll(rawVector);
        integerVector.addAll(rawVector);
        // stringVector.addAll(objectVector); // 오류 : Vector<Object>로 정의하는 것이 Vector로 정의하는 것보다 안전함

        // 다형성
        List listInterface = new Vector();
        listInterface = new ArrayList();
        Collection collectionInterface = new ArrayList();
        collectionInterface = listInterface;
        collectionInterface = stringVector;
        List rawList = rawVector;
        rawList = objectVector;
        rawList = stringVector;
        rawList = integerVector;
        List<String> listInterfaceGeneric = new Vector<String>();
        Collection<String> collectionInterfaceGeneric = new ArrayList<String>();
        List<Object> objectList = rawVector;
        objectList = objectVector;
//        objectList = stringVector; // 오류 : 제네릭 타입을 정의하는 감싸는 타입을 대입시 와일드 카드를 사용하지 않으면 동일한 타입이여 한다
//        objectList = integerVector; // 오류 :
//        List<Number> numberList = integerVector; // 오류 : 계층 구조여도 제네릭은 불공변이므로 오류이다
        List<? extends Number> numberList2 = integerVector;
        List<? super Integer> numberList3 = integerVector;

        // clone : clone 메서드가 Object 타입을 반환하므로 캐스팅이 필수임
        // clone 메서드 자체는 안전하지 않음. 프레임워크를 만들 목적이 아니라면 복사 생성자 또는 복사 팩토리를 사용하는 것이 좋음
        Vector rawVectorClone = (Vector) rawVector.clone();
        Vector<Integer> integerVectorClone = (Vector<Integer>) rawVectorClone.clone();
        
        // clone 메서드 호출시 참조 타입을 요소로 담고 있으면 얕은 복사 수행
        ListVo vo1 = new ListVo("list1", "key1", "value1");
        ListVo vo2 = new ListVo("list2", "key2", "value2");
        ListVo vo3 = new ListVo("list3", "key3", "value3");
        Vector<ListVo> listVoVector = new Vector<>();
        listVoVector.add(vo1);
        listVoVector.add(vo2);
        listVoVector.add(vo3);
        Vector<ListVo> listVoVectorClone = (Vector<ListVo>) listVoVector.clone();
        if(listVoVector.get(0) == listVoVectorClone.get(0)) {
            System.out.println("listVoVector.get(0) === listVoVectorClone.get(0) : " + (listVoVector.get(0) == listVoVectorClone.get(0)));
        }

        // equals
        stringVector.clear();
        List<String> stringList = new ArrayList<String>();
        stringVector.add("AAA");
        stringVector.add("BBB");
        stringList.add("AAA");
        stringList.add( new String("BBB"));
        System.out.println("stringVector.equals(stringList) : " + stringVector.equals(stringList));
        
        // toArray
        Object[] stringListArray1 = stringList.toArray();
        for(Object value : stringListArray1) {
            if(value instanceof String) {
                System.out.println("stringListArray1 string value : " + ((String)value).toUpperCase());
            }
        }
        String[] stringListArray2 = stringList.toArray(new String[0]);
        for(String value : stringListArray2) {
            System.out.println("stringListArray2 string value : " + value);
        }
        
        // copInfo : Vector 에만 존재하는 메서드
        Object[] objectArray = new Object[3];
        objectArray[0] = "aaa";
        objectArray[1] = "bbb";
        objectArray[2] = "ccc";
        stringVector.copyInto(objectArray);
        for(String value : stringVector) {
            System.out.println("stringVector string value : " + value);
        }
        System.out.println("objectArray : " + Arrays.toString(objectArray));
    }

    // iterator, listIterator
    private static void listIteratorFunction() {
        System.out.println("list iterator");
        Collection<String> collection = new ArrayList<String>();
        collection.add("AAA");
        collection.add("BBB");
        collection.add("CCC");
        collection.add("ZZZ");
        collection.add("DDD");
        collection.add("AAA");
        collection.add("FFF");
        collection.add("BBB");

        // iterator
        Iterator iterator = collection.iterator();
        while(iterator.hasNext()) {
            Object value = iterator.next();
            System.out.println("collection iterator value : " + value);
        }
        for(Iterator forIterator = collection.iterator(); forIterator.hasNext();) {
            Object value = forIterator.next();
            System.out.println("collection for statement iterator value : " + value);
        }

        // listIterator
        List<String> list = (List<String>) collection;
        ListIterator listIterator = list.listIterator();
        while(listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            int previousIndex = listIterator.previousIndex();
            Object nextValue = listIterator.next();
//            Object previousValue = listIterator.previous();
            System.out.println("nextIndex : " + nextIndex + ", previousIndex : " + previousIndex);
            System.out.println("list listIterator nextValue : " + nextValue);
        }
    }

    // remove(index), remove(object), removeIf, filter
    private static void listRemoveFunction() {
        System.out.println("list remove");
        List<String> stringList = new ArrayList<String>();
        YamdengCollectionUtil.initStringList(stringList);

        // 오류 : for each 방식으로 list 요소 삭제시 오류 (ConcurrentModificationException)
//        for(String str : stringList) {
//            stringList.remove(str);
//        }

        // iterator 이용해서 삭제
        YamdengCollectionUtil.iteratorToString(stringList, "remove before");
        Iterator<String> iterator = stringList.iterator();
        while(iterator.hasNext()) {
            String value = iterator.next();
            if(value.equals("AAA")) {
                iterator.remove();
            }
        }
        YamdengCollectionUtil.iteratorToString(stringList, "remove after");

        // 작동은 하지만 올바르지 않은 방법
        YamdengCollectionUtil.initStringList(stringList);
        YamdengCollectionUtil.iteratorToString(stringList, "remove before");
        for(int index=0; index<stringList.size(); index++) {
            if(index == 3 || index == 4) {
                // 중복된 값은 무시하고 첫번째로 존재하는 값을 삭제한다
//                stringList.remove("test");
                stringList.remove(index);
            }
        }
        YamdengCollectionUtil.iteratorToString(stringList, "remove after");

        // removeIf
        YamdengCollectionUtil.initStringList(stringList);
        YamdengCollectionUtil.iteratorToString(stringList, "remove before");
        stringList.removeIf((value) -> value.equals("AAA"));
        YamdengCollectionUtil.iteratorToString(stringList, "remove after");

        // guava filter 사용
        YamdengCollectionUtil.initStringList(stringList);
        YamdengCollectionUtil.iteratorToString(stringList, "remove before");
        List<String> newList = Collections2.filter(stringList, (value) -> !value.equals("AAA")).stream().collect(Collectors.toList());
        YamdengCollectionUtil.iteratorToString(stringList, "remove after");
        YamdengCollectionUtil.iteratorToString(newList, "remove after newList");
    }

    // contains, containsAll, subList, addAll, retainAll, removeAll
    private static void listEtcFunction() {
        System.out.println("list etc Function");
        List<String> stringList = new ArrayList<String>();
        YamdengCollectionUtil.initStringList(stringList);

        // contains
        System.out.println("stringList.contains(\"AAA\") : " + stringList.contains("AAA"));
        System.out.println("stringList.contains(\"AAAA\") : " + stringList.contains("AAAA"));

        // containsAll
        List<String> stringList2 = new ArrayList<String>();
        YamdengCollectionUtil.initStringList(stringList2);
        stringList2.remove(0);
        System.out.println("stringList.containsAll(stringList2) : " + stringList.containsAll(stringList2));
        stringList2.add("OOOOO");
        System.out.println("stringList.containsAll(stringList2) : " + stringList.containsAll(stringList2));

        // subList
        List<String> subStringList = stringList.subList(0, stringList.size());
        YamdengCollectionUtil.iteratorToString(subStringList, "subStringList");

        // addAll
        YamdengCollectionUtil.iteratorToString(stringList, "before stringList");
        List<String> smallList = new ArrayList<String>();
        smallList.add("AAA");
        smallList.add("HHH");
        smallList.add("FFF");
        stringList.addAll(smallList);
        YamdengCollectionUtil.iteratorToString(stringList, "after stringList");

        // retainAll
        YamdengCollectionUtil.initStringList(stringList);
        YamdengCollectionUtil.iteratorToString(stringList, "before stringList");
        stringList.retainAll(smallList);
        YamdengCollectionUtil.iteratorToString(stringList, "after stringList");

        // removeAll
        YamdengCollectionUtil.initStringList(stringList);
        YamdengCollectionUtil.iteratorToString(stringList, "before stringList");
        stringList.removeAll(smallList);
        YamdengCollectionUtil.iteratorToString(stringList, "after stringList");
    }

    private static void listSort() {
        System.out.println("list sort");
        
        // String, Integer 기본 정렬
        List<String> stringList = new ArrayList<String>();
        YamdengCollectionUtil.initStringList(stringList);
        List<Integer> integerList = new ArrayList<Integer>();
        YamdengCollectionUtil.initIntegerList(integerList);

        // String, Integer 기본 정렬
        YamdengCollectionUtil.iteratorToString(stringList, "before stringList");
        YamdengCollectionUtil.iteratorToString(integerList, "before integerList");
        stringList.sort(null);
        integerList.sort(null);
        YamdengCollectionUtil.iteratorToString(stringList, "after stringList");
        YamdengCollectionUtil.iteratorToString(integerList, "after integerList");

        // 사용자 정의 클래스 정렬 : implements Comparable
        List<ListVo> voList = new ArrayList<ListVo>();
        voList.add(new ListVo("AAA", "key", "value"));
        voList.add(new ListVo("CCC", "key", "value"));
        voList.add(new ListVo("BBB", "key", "value"));
        voList.add(new ListVo("AAA", "key", "value"));
        voList.add(new ListVo("ZZZ", "key", "value"));
        YamdengCollectionUtil.iteratorToString(voList, "before voList");
        voList.sort(null);
        YamdengCollectionUtil.iteratorToString(voList, "after voList");

        // String, Interger Comparator 적용
        YamdengCollectionUtil.initStringList(stringList);
        YamdengCollectionUtil.initIntegerList(integerList);
        YamdengCollectionUtil.iteratorToString(stringList, "before stringList");
        YamdengCollectionUtil.iteratorToString(integerList, "before integerList");
        YamdengCollectionUtil.iteratorToString(voList, "before voList");
        stringList.sort(new StringComparator());
        integerList.sort((i1, i2) -> i1.compareTo(i2));
        voList.sort(new ListVoComparator());
        YamdengCollectionUtil.iteratorToString(stringList, "after stringList");
        YamdengCollectionUtil.iteratorToString(integerList, "after integerList");
        YamdengCollectionUtil.iteratorToString(voList, "after voList");

        // Collection.sort
        Collections.sort(voList, (vo1, vo2) -> vo1.compareTo(vo2));
        YamdengCollectionUtil.iteratorToString(voList, "Collections.sort after voList");
    }

}
