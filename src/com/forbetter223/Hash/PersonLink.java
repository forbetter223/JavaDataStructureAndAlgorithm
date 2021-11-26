package com.forbetter223.Hash;

public class PersonLink {
    private int size;
    private Person head;

    public PersonLink(int pSize) {
        this.size = pSize;
        head = null;
    }

    public void add(Person node) {
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Person tempNode = this.head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = node;
        }
    }

    public void print( int line) {
        Person node = this.head;
        if(isEmpty()){
            System.out.printf("该链表 %d 为空 \n",line);
        }else{
            do {
                System.out.printf("该链表 %d 有值 ",line);
                node.print();
                node = node.next;
            } while (node != null);
        }

    }

    public void find(int no) {
        Person node = this.head;
        boolean tmpb = false;
        if (!isEmpty()) {
            do {
                if (no == node.ID) {
                    node.print();
                    tmpb = true;
                    break;
                }
                node = node.next;
            } while (node != null);
        }
        if(!tmpb){
            System.out.println("没有找到该值");
        }
    }

    public void delete(Person node){
        if(isEmpty()){
            return;
        }
        Person tempNode = this.head;
        if(tempNode.ID == node.ID){
            this.head = null;
            return;
        }
        while(tempNode.next != null){
            if(tempNode.next.ID == node.ID){
                tempNode.next = node.next;
            }
            tempNode = tempNode.next;
        }
    }

    private boolean isEmpty() {
        if (this.head == null) {

            return true;
        }
        return false;
    }
}
