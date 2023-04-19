package com.yangweiyao.struture.list;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-18 15:10
 * @Description
 **/
public class DoubleLinkedList<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> end;
    private int length;

    /**
     * 头部插入元素
     * @param data 元素
     */
    public void addFirst(T data) {

        // 暂存头结点
        DoubleNode<T> head = this.head;

        // 新建结点，并指向头部
        DoubleNode<T> newNode = new DoubleNode<>(data);
        this.head = newNode;

        // 如果头部结点是null，则尾结点就是头部结点
        if(head == null) {
            this.end = newNode;
        } else {
            // 头部结点前驱记录新结点
            head.prev = newNode;
            // 新结点尾部记录原先的头结点
            newNode.next = head;
        }
        length++;
    }

    /**
     * 尾部插入元素
     * @param data 元素
     */
    public void addLast(T data) {

        // 暂存尾部结点
        DoubleNode<T> end = this.end;

        // 新建结点，并指向尾部结点
        DoubleNode<T> newNode = new DoubleNode<>(data);
        this.end = newNode;

        // 尾部结点为空，则头部结点就是尾结点
        if(end == null) {
            this.head = newNode;
        } else {
            // 新结点的头部结点就是原先的尾部结点
            newNode.prev = end;
            // 尾部结点后继记录新的结点
            end.next = newNode;
        }
        length++;
    }

    /**
     * 指定索引位置插入元素
     * @param index 索引
     * @param data 元素
     */
    public void addByIndex(int index, T data) {
        if(rangeCheck(index)) {
            if(index == 0) {
                addFirst(data);
            } else if (index == length) {
                addLast(data);
            } else {

                DoubleNode<T> newNode = new DoubleNode<>(data);

                // 找到索引对应的元素
                DoubleNode<T> node = queryNodeByIndex(index);
                // 索引对应的元素的前驱
                DoubleNode<T> prev = node.prev;

                // 索引对应的元素的【前面的结点】后继更新为新结点
                prev.next = newNode;
                // 索引对应的元素的前驱更新为新结点
                node.prev = newNode;

                // 新结点的前驱为【索引对应的元素的前面的结点】
                newNode.prev = prev;
                // 新结点的后继为【索引对应的元素】
                newNode.next = node;

                length++;
            }
        }
    }

    /**
     * 移除链表首个出现的元素
     * @param data 元素
     */
    public void removeFirst(T data) {
        DoubleNode<T> node = this.head;
        while (node != null) {
            if(node.data == data) {
                deleteNode(node);
                break;
            }
            node = node.next;
        }
    }

    /**
     * 移除链表出现的元素
     * @param data 元素
     */
    public void removeAll(T data) {
        DoubleNode<T> node = this.head;
        while (node != null) {
            if(node.data == data) {
                // 暂存后继，防止删除后找不到之前的位置
                DoubleNode<T> next = node.next;
                deleteNode(node);
                node = next;
            } else {
                node = node.next;
            }
        }
    }

    /**
     * 指定索引移除元素
     * @param index 索引
     * @return 被移除的值
     */
    public T removeByIndex(int index) {
        if(!rangeCheck(index)) {
            return null;
        }

        DoubleNode<T> doubleNode = queryNodeByIndex(index);
        T data = doubleNode.data;
        deleteNode(doubleNode);
        length--;
        return data;
    }

    /**
     * 判断链表是否包含该元素
     * @param data 元素
     * @return true/false
     */
    public boolean contain(T data) {
        // 从头开始遍历
        DoubleNode<T> node = head;
        while (node != null) {
            if(node.data == data) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * 指定索引获取元素
     * @param index 索引
     * @return 元素
     */
    public T get(int index) {
        if(rangeCheck(index)) {
            return queryNodeByIndex(index).data;
        }
        return null;
    }

    /**
     * 指定索引修改元素
     * @param index 索引
     * @param newData 新元素值
     */
    public void set(int index, T newData) {
        if(!rangeCheck(index)) {
            return;
        }
        DoubleNode<T> doubleNode = queryNodeByIndex(index);
        doubleNode.data = newData;
    }

    private void deleteNode(DoubleNode<T> node) {

        // 待删除的前驱、后继结点
        DoubleNode<T> prev = node.prev;
        DoubleNode<T> next = node.next;

        if(prev == null) {
            // 待删除的结点是头结点
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if(next == null) {
            // 待删除的结点是尾结点
            end = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

    }


    private DoubleNode<T> queryNodeByIndex(int index) {
        DoubleNode<T> node;
        // index 在链表前部分
        if(index < length >> 1) { // length >> 1 对半
            // 从头部往后移到index
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            // 从尾部往前移到index
            node = end;
            for (int i = length - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    private boolean rangeCheck(int index) {
        if(index < 0 || index >= length) {
            System.err.println("索引越界！");
            return false;
        }
        return true;
    }

    public int size() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        DoubleNode<T> head = this.head;
        while (head != null) {
            builder.append("{");
            if(head.prev != null) {
                builder.append("[").append(head.prev.data).append("]-");
            }
            builder.append(head.data);
            if(head.next != null) {
                builder.append("-[").append(head.next.data).append("]");
            }
            builder.append("}->");
            head = head.next;
        }
        return builder.substring(0, builder.length() - 2);
    }

    static class DoubleNode<T> {

        /* 前驱结点 */
        private DoubleNode<T> prev;
        
        /* 具体数据 */
        private T data;
        
        /* 后继结点 */
        private DoubleNode<T> next;

        public DoubleNode(T data) {
            this.data = data;
        }
    }

}
