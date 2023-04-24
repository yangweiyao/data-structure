package com.yangweiyao.structure.list.test;

import com.yangweiyao.structure.list.LoopSingleLinkedList;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-19 17:13
 * @Description
 **/
public class LoopSingleLinkedListTest {

    public static void main(String[] args) {

        LoopSingleLinkedList<Integer> loopSingleLinkedList = new LoopSingleLinkedList<>();

        loopSingleLinkedList.insert(46);
        loopSingleLinkedList.insert(16);
        loopSingleLinkedList.insert(38);
        loopSingleLinkedList.insert(22);
        System.out.println(loopSingleLinkedList);

        loopSingleLinkedList.insertByIndex(2, 99);
        System.out.println(loopSingleLinkedList);

        loopSingleLinkedList.insert(88);
        System.out.println(loopSingleLinkedList);

        int index = loopSingleLinkedList.getByData(99);
        System.out.println(index);

        Integer data = loopSingleLinkedList.getByIndex(2);
        System.out.println(data);

        LoopSingleLinkedList<Integer> objectLoopSingleLinkedList = new LoopSingleLinkedList<>();
        objectLoopSingleLinkedList.insert(27);
        objectLoopSingleLinkedList.insert(17);
        loopSingleLinkedList.marge(objectLoopSingleLinkedList);
        System.out.println(loopSingleLinkedList);

        Integer deleteData = loopSingleLinkedList.deleteByIndex(loopSingleLinkedList.size() - 2);
        System.out.println(deleteData);
        System.out.println(loopSingleLinkedList);

    }
    
}
