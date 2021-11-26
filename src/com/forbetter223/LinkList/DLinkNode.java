package com.forbetter223.LinkList;

public class DLinkNode {
    // 节点编号
    public int no;
    // 链表中这个节点存放的值
    public String value;
    // 这个节点指向的下一个节点
    DLinkNode nextNode;
    // 指向上一个节点的节点
    DLinkNode previousNode;

    public DLinkNode(int pNo, String pValue){
        this.no = pNo;
        this.value = pValue;
    }

    public String toString(){
        return String.format("no = %d; value = %s",this.no,this.value);
    }
}
