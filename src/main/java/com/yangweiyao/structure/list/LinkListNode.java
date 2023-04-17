package com.yangweiyao.structure.list;

/**
 * @Author yangweiyao
 * @CreateTime 2023-04-17 11:19
 * @Description 结点
 **/
public class LinkListNode {

    /** 结点的数据域 */
    private Integer data;

    /** 下一个结点 */
    private LinkListNode next;

    public LinkListNode() {
    }

    public LinkListNode(Integer data) {
        this.data = data;
    }

    public LinkListNode(Integer data, LinkListNode next) {
        this.data = data;
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public LinkListNode getNext() {
        return next;
    }

    public void setNext(LinkListNode next) {
        this.next = next;
    }

}
