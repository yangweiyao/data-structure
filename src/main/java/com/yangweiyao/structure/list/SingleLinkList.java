package com.yangweiyao.structure.list;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-17 11:19
 * @Description 单链表
 **/
public class SingleLinkList {

    /** 头结点 */
    private final LinkListNode head;

    /** 长度 */
    private int length;

    public SingleLinkList() {
        this.head = new LinkListNode();
    }

    public SingleLinkList(Integer data, LinkListNode next) {
        // 头结点
        this.head = new LinkListNode();
        // 首元结点
        LinkListNode node = new LinkListNode();
        node.setData(data);
        node.setNext(next);
        // 设置头结点下个结点
        head.setNext(node);
    }

    /**
     * 默认往链表最后插入元素
     * @param data 元素
     * @return 结点
     */
    public LinkListNode insert(Integer data) {
        LinkListNode newNode = new LinkListNode(data);
        LinkListNode point = head;
        while (point.getNext() != null) {
            point = point.getNext();
        }
        point.setNext(newNode);
        length++;
        return newNode;
    }

    /**
     * 往链表指定位置插入元素
     * @param index 索引
     * @param data 元素
     */
    public LinkListNode insertByIndex(int index, Integer data) {
        if(index > length || index - 1 < 0) {
            return insert(data);
        }
        index--;
        LinkListNode point = head;
        while (index != 0) {
            point = point.getNext();
            index--;
        }
        LinkListNode newNode = new LinkListNode(data, point.getNext());
        point.setNext(newNode);
        length++;
        return newNode;
    }

    /**
     * 按位置查询元素
     * @param index 索引
     * @return 元素
     */
    public Integer getByIndex(int index) {
        if(index > length || index < 0) {
            return null;
        }
        LinkListNode point = head;
        while (index != 0) {
            point = point.getNext();
            index--;
        }
        return point.getData();
    }

    /**
     * 按元素查询索引
     * @param data 元素
     * @return 索引
     */
    public int getByData(Integer data) {
        LinkListNode point = head;
        int index = 0;
        while (point.getNext() != null) {
            point = point.getNext();
            index++;
            if(point.getData().equals(data)) {
                return index;
            }
        }
        if(index == length && !point.getData().equals(data)) {
            return 0;
        }
        return index;
    }

    /**
     * 遍历单链表
     */
    public void print() {
        LinkListNode point = head;
        StringBuilder builder = new StringBuilder("SingleLinkList: ");
        while (point.getNext() != null) {
            point = point.getNext();
            builder.append("{").append(point.getData());
            if(point.getNext() != null) {
                builder.append("-[").append(point.getNext().getData()).append("]");
            }
            builder.append("}").append("->");
        }
        System.out.println(builder.substring(0, builder.length() - 2));
    }

    /**
     * 按位置索引删除元素
     * @param index 索引
     * @return 删除元素
     */
    public Integer deleteByIndex(int index) {
        if(index > length || index - 1 < 0) {
            return null;
        }
        index--;
        LinkListNode point = head;
        while (index != 0) {
            point = point.getNext();
            index--;
        }
        Integer result = point.getNext().getData();
        point.setNext(point.getNext().getNext());
        length--;
        return result;
    }

    /**
     * 合并链表
     * @param singleLinkList 链表
     */
    public void marge(SingleLinkList singleLinkList) {
        LinkListNode point = head;
        length = length + singleLinkList.length;
        while (point.getNext() != null) {
            point = point.getNext();
        }
        point.setNext(singleLinkList.head.getNext());
    }

    public int size() {
        return length;
    }

}
