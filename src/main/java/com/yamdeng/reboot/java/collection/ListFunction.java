package com.yamdeng.reboot.java.collection;


import com.google.common.collect.Collections2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// List 인터페이스 : ArrayList, LinkedList
public class ListFunction {

    public static void main(String[] args) {
        System.out.println("========== 래퍼 클래스 ==========");
        System.out.println();

        // ArrayList Basic
//        arrayList();

        // ArrayList remove
        arrayListRemove();

        System.out.println("========== ListFunction End ==========");
    }

    private static void arrayList() {
        System.out.println("ArrayList Basic");
        List list1 = new ArrayList();

        // isEmpty
        System.out.println("list1.isEmpty() : " + list1.isEmpty());
        for(int index=10; index>0; index--) {
            list1.add(index+1);
        }

        // size
        System.out.println("list1 size : " + list1.size());
        System.out.println("list1 : " + list1);

        // toArray
        Object[] list1Arr = (Object[]) list1.toArray();
        System.out.println("list1Arr : " + list1Arr);

        // sort
        list1.sort(null);
        System.out.println("list1 sort after: " + list1);

        // clear
        list1.clear();
        CollectionUtil.resetList(list1);

        // set(index, value)
        list1.set(0, 1000);
        System.out.println("list1 : " + list1 + " list1[0] : " + list1.get(0));

        // remove(index)
        list1.remove(0);
        System.out.println("list1 : " + list1 + " list1[0] : " + list1.get(0));
        CollectionUtil.resetList(list1);

        // subList
        List list2 = list1.subList(5, 6);
        System.out.println("list1 : " + list1 + " list1[0] : " + list1.get(0));
        System.out.println("list2 : " + list2 + " list2[0] : " + list2.get(0));

        List list3 = new ArrayList();
        CollectionUtil.resetList(list3, 0, 3);

        // addAll
        list1.addAll(list3);
        System.out.println("list1 : " + list1 + " list1[0] : " + list1.get(0));
        System.out.println("list3 : " + list3);
        CollectionUtil.resetList(list1);
        CollectionUtil.resetList(list3, 0, 3);

        // retainAll
        list1.retainAll(list3);
        System.out.println("list1 : " + list1 + " list1[0] : " + list1.get(0));
        System.out.println("list3 : " + list3);
        CollectionUtil.resetList(list1);
        CollectionUtil.resetList(list3, 0, 3);

        // removeAll
        list1.removeAll(list3);
        System.out.println("list1 : " + list1 + " list1[0] : " + list1.get(0));
        System.out.println("list3 : " + list3);
        CollectionUtil.resetList(list1);
        CollectionUtil.resetList(list3, 0, 3);

        // contains
        System.out.println("list1.contains(3)" + list1.contains(31));

    }

    private static void arrayListRemove() {

        //        list를 반복하면서 삭제하는 방법
//        1.Iterator.remove 사용
//        2.removeIf 사용

        System.out.println("ArrayList remove");
        List<String> list1 = new ArrayList<String>();
        CollectionUtil.resetList(list1, "test");
        System.out.println("list1 : " + list1);
        
        // 에러
//        for(String str : list1) {
//            list1.remove(str);
//        }
        
        // 올바른 방법
//        Iterator<String> ite = list1.iterator();
//        while(ite.hasNext()) {
//            String str = ite.next();
//            ite.remove();
//        }
        
        // 작동은 하지만 올바르지 않은 방법
        for(int index=0; index<list1.size(); index++) {
            if(index == 3 || index == 4) {
//                list1.remove(3);
                // 중복된 값은 무시하고 첫번째로 존재하는 값을 삭제한다
                list1.remove("test");
            }
            System.out.println(list1.get(index));
        }

        System.out.println("list1 : " + list1);
        CollectionUtil.resetList(list1, "test");

        // removeIf
        list1.removeIf((value) -> value.equals("test"));
        System.out.println("list1 : " + list1);
        CollectionUtil.resetList(list1, "test");
        
        // guava filter 사용
        List<String> newList = Collections2.filter(list1, (value) -> !value.equals("test")).stream().collect(Collectors.toList());
        System.out.println("list1 : " + list1);
        System.out.println("newList : " + newList);



//        Collections2.filter(list1
    }

}
