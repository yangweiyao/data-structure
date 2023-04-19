package com.yangweiyao.structure.list.test;

import com.yangweiyao.structure.list.SingleLinkList;

import java.util.Scanner;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-17 14:47
 * @Description
 **/
public class SingleLinkListTest {

    public static void main(String[] args) {

        SingleLinkList<Integer> singleLinkList = new SingleLinkList<>();

        singleLinkList.insert(46);
        singleLinkList.insert(16);
        singleLinkList.insert(38);
        singleLinkList.insert(22);
        System.out.println(singleLinkList);

        singleLinkList.insertByIndex(2, 99);
        System.out.println(singleLinkList);

        singleLinkList.insert(88);
        System.out.println(singleLinkList);

        int index = singleLinkList.getByData(99);
        System.out.println(index);

        Integer data = singleLinkList.getByIndex(2);
        System.out.println(data);

        SingleLinkList<Integer> objectSingleLinkList = new SingleLinkList<>();
        objectSingleLinkList.insert(27);
        objectSingleLinkList.insert(17);
        singleLinkList.marge(objectSingleLinkList);
        System.out.println(singleLinkList);

        Integer deleteData = singleLinkList.deleteByIndex(singleLinkList.size() - 2);
        System.out.println(deleteData);
        System.out.println(singleLinkList);

    }


}
