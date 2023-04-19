package com.yangweiyao.struture.list.test;

import com.yangweiyao.struture.list.DoubleLinkedList;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-18 15:24
 * @Description
 **/
public class DoubleLinkedListTest {

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        System.out.println(doubleLinkedList);

        doubleLinkedList.addLast(3);
        doubleLinkedList.addLast(3);
        doubleLinkedList.addLast(3);
        System.out.println(doubleLinkedList);

        doubleLinkedList.addByIndex(2, 4);
        System.out.println(doubleLinkedList);

        doubleLinkedList.removeFirst(3);
        System.out.println(doubleLinkedList);

        doubleLinkedList.removeAll(3);
        System.out.println(doubleLinkedList);

        Integer data = doubleLinkedList.removeByIndex(1);
//        System.out.println(data);
        System.out.println(doubleLinkedList);

        boolean contain = doubleLinkedList.contain(6);
        System.out.println("flag:" + contain);

        Integer value = doubleLinkedList.get(1);
        System.out.println(value);

        doubleLinkedList.set(1, 9);
        System.out.println(doubleLinkedList);

    }

}
