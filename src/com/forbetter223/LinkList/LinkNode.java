package com.forbetter223.LinkList;

/**
 * 模仿链表的一个节点
 */
public class LinkNode {
    // 节点编号
    public int no;
    // 链表中这个节点存放的值
    public String value;
    // 这个节点指向的下一个节点
    LinkNode nextNode;

    public LinkNode(int pNo, String pValue){
        this.no = pNo;
        this.value = pValue;
    }

    public String toString(){
        return String.format("no = %d; value = %s",this.no,this.value);
    }
}
