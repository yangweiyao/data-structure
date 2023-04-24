package com.yangweiyao.structure.list;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-19 15:55
 * @Description 单向循环链表
 **/
public class LoopSingleLinkedList<T> {

    /** 头结点 */
    private final Node<T> head;

    /** 长度 */
    private int length;

    public LoopSingleLinkedList() {
        this.head = new Node<>();
        this.head.next = this.head; // make head node point to itself
    }

    public LoopSingleLinkedList(T data, Node<T> next) {
        // 头结点
        this.head = new Node<>();
        // 首元结点
        Node<T> node = new Node<>();
        node.data = data;
        node.next = next;
        // 设置头结点下个结点
        head.next = node;
        this.head.next = this.head; // make last node point to head node
        length++;
    }

    /**
     * 默认往链表最后插入元素
     * @param data 元素
     */
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> point = head;
        while (point.next != head) { // traverse until last node
            point = point.next;
        }
        point.next = newNode;
        newNode.next = head; // make last node point to head node
        length++;
    }

    /**
     * 往链表指定位置插入元素
     * @param index 索引
     * @param data 元素
     */
    public void insertByIndex(int index, T data) {
        if(index > length || index - 1 < 0) {
            return;
        }
        index--;
        Node<T> point = head;
        while (index != 0) {
            point = point.next;
            index--;
        }
        point.next = new Node<>(data, point.next);
        length++;
    }

    /**
     * 按位置查询元素
     * @param index 索引
     * @return 元素
     */
    public T getByIndex(int index) {
        if(index > length || index < 0) {
            return null;
        }
        Node<T> point = head.next;
        while (index != 0) {
            point = point.next;
            index--;
        }
        return point.data;
    }

    /**
     * 按元素查询索引
     * @param data 元素
     * @return 索引
     */
    public int getByData(Integer data) {
        Node<T> point = head.next;
        int index = 0;
        while (point != head) {
            index++;
            if(point.data.equals(data)) {
                return index;
            }
            point = point.next;
        }
        return -1;
    }


    /**
     * 按位置索引删除元素
     * @param index 索引
     * @return 删除元素
     */
    public T deleteByIndex(int index) {
        if(index > length || index - 1 < 0) {
            return null;
        }
        index--;
        Node<T> point = head;
        while (index != 0) {
            point = point.next;
            index--;
        }
        T result = point.next.data;
        point.next = point.next.next;
        if (point.next == head) { // update last node to point to head node
            point.next = head.next;
        }
        length--;
        return result;
    }

    /**
     * 合并链表
     * @param loopSingleLinkedList 链表
     */
    public void marge(LoopSingleLinkedList<T> loopSingleLinkedList) {
        Node<T> point = head;
        length = length + loopSingleLinkedList.length;
        while (point.next != head) {
            point = point.next;
        }
        point.next = loopSingleLinkedList.head.next;
        loopSingleLinkedList.head.next = head;
    }

    public int size() {
        return length;
    }

    @Override
    public String toString() {
        Node<T> point = head.next;
        StringBuilder builder = new StringBuilder("LoopSingleLinkedList: ");
        for (int j = length; j > 0; j--) {
            builder.append("{").append(point.data);
            if(point.next.data != null) {
                builder.append("-[").append(point.next.data).append("]");
            } else {
                point = point.next;
                if(point.next.data != null) {
                    builder.append("-[").append(point.next.data).append("]");
                }
            }
            builder.append("}").append("->");
            point = point.next;
        }
        return builder.substring(0, builder.length() - 2);
    }

    private static class Node<T> {

        /** 结点的数据域 */
        private T data;

        /** 下一个结点 */
        private Node<T> next;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

    }
}
