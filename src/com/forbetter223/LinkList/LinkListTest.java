package com.forbetter223.LinkList;

public class LinkListTest {
    public static void main(String[] args){
        CircularLinkList cll1 = new CircularLinkList();
        LinkNode ln0 = new LinkNode(0,"Value0");
        LinkNode ln1 = new LinkNode(1,"Value1");
        LinkNode ln2 = new LinkNode(2,"Value2");
        LinkNode ln3 = new LinkNode(3,"Value3");
        LinkNode ln4 = new LinkNode(4,"Value4");
        LinkNode ln5 = new LinkNode(5,"Value5");
        LinkNode ln6 = new LinkNode(6,"Value6");
//        cll1.add(ln0);
//        cll1.add(ln2);
//        cll1.add(ln5);
//        cll1.print();
        CircularLinkList cll2 = new CircularLinkList(ln1,ln2,ln3,ln4,ln5);
        cll2.print();
        cll2.josephi(1,7);
    }
    public void SingleLinkListTest(){
        // 变量ln1,2,3,4,5在每次使用完后它的nextNode都会保留赋与的值。
        LinkNode ln1 = new LinkNode(1,"value1");
        LinkNode ln2 = new LinkNode(2,"value2");
        LinkNode ln3 = new LinkNode(3,"value3");
        LinkNode ln4 = new LinkNode(4,"value4");
        LinkNode ln5 = new LinkNode(5,"value5");
        System.out.println("向链表尾部添加数据");
        SingleLinkList sl = new SingleLinkList();
        // add 数据的顺序就是链表存储的顺序
        sl.add(ln1);
        sl.add(ln5);
        sl.add(ln3);// 打印的顺也是1，5，3
        sl.print();
        System.out.println("有序添加数据");
        SingleLinkList s2 = new SingleLinkList();
        s2.addBySort(ln1);
        s2.addBySort(ln5);
        s2.addBySort(ln3);
        s2.print();// 打印的顺是1，3，5
        System.out.println("取得指定位置的数据");
        SingleLinkList s3 = new SingleLinkList();
        LinkNode s3L1 = s3.get(0);
        System.out.println(s3L1 == null?"s3L1为空~":s3L1.toString());
        s3.addBySort(ln1);
        LinkNode s3L2 = s3.get(9);
        System.out.println(s3L2 == null?"s3L2为空~":s3L1.toString());
        s3.addBySort(ln5);
        s3.addBySort(ln3);
        System.out.println(s3.count);
        System.out.println(s3.get(0).toString());
        System.out.println(s3.get(1).toString());
        System.out.println(s3.get(2).toString());
        System.out.println(s3.get(-1).toString());
        System.out.println(s3.get(-2).toString());
        System.out.println(s3.get(-3).toString());
        System.out.println("取得指定位置的数据，下坐标从1开始");
        SingleLinkList s4 = new SingleLinkList();
        s4.addBySort(ln1);
        s4.addBySort(ln5);
        s4.addBySort(ln3);
        System.out.println(s4.count);
        System.out.println(s4.getValueIndexFrom1(0) == null?"无法取得node":s4.getValueIndexFrom1(0).toString());
        System.out.println(s4.getValueIndexFrom1(1).toString());
        System.out.println(s4.getValueIndexFrom1(2).toString());
        System.out.println(s4.getValueIndexFrom1(3).toString());
        System.out.println(s4.getValueIndexFrom1(-1).toString());
        System.out.println(s4.getValueIndexFrom1(-2).toString());
        System.out.println("删除指定位置的节点");
        SingleLinkList s5 = new SingleLinkList();
        s5.delete(0);
        s5.addBySort(ln1);
        s5.delete(9);
        s5.addBySort(ln5);
        s5.addBySort(ln3);
        System.out.println(s5.count);
        s5.delete(-1);
        s5.print();
        System.out.println(s5.count);
        System.out.println("逆序打印链表");
        SingleLinkList s6 = new SingleLinkList();
        s6.add(ln2);
        s6.add(ln4);
        System.out.println(s6.count);
        s6.reversePrint();
        s6.print();
        System.out.println("合并链表");
        LinkNode ln6 = new LinkNode(6,"value6");
        LinkNode ln7 = new LinkNode(7,"value7");
        LinkNode ln8 = new LinkNode(8,"value8");
        SingleLinkList s7 = new SingleLinkList();
        SingleLinkList s8 = new SingleLinkList();
        s7.add(ln6);
        s7.add(ln7);
        s8.add(ln8);
        s7.rangeLink(s8);
        s7.print();

        System.out.println("更新链表");
        SingleLinkList s9 = new SingleLinkList();
        ln1 = new LinkNode(1,"value1");
        ln2 = new LinkNode(2,"value2");
        ln3 = new LinkNode(2,"updateValue3");
        s9.add(ln1);
        s9.add(ln2);
        s9.print();
        System.out.println("-------------");
        s9.update(ln3);
        s9.print();
    }

    public void DoublyLinkList(){
        DLinkNode dln0 = new DLinkNode(0,"Value0");
        DLinkNode dln1 = new DLinkNode(1,"Value1");
        DLinkNode dln2 = new DLinkNode(2,"Value2");
        DLinkNode dln3 = new DLinkNode(3,"Value3");
        DLinkNode dln4 = new DLinkNode(4,"Value4");
        DLinkNode dln5 = new DLinkNode(5,"Value5");
        DoublyLinkList dll1 = new DoublyLinkList();
        dll1.add(dln0);
        dll1.add(dln2);
        dll1.add(dln4);
        System.out.println(dll1.Count);
        dll1.print();
        DoublyLinkList dll2 = new DoublyLinkList(new DLinkNode(6,"Value6"),
                new DLinkNode(7,"Value7"));
        System.out.println(dll1.Count);
        dll2.print();
        print("删除数据。");
        dll1.delete(dln0);
        print(dll1.Count);
        dll1.print();
        dll1.delete(dln5);
        dll1.delete(dln4);
        print(dll1.Count);
        dll1.print();
        print("更新数据");
        DoublyLinkList dll3 = new DoublyLinkList(
                new DLinkNode(0,"Value0"),
                new DLinkNode(7,"Value7"),
                new DLinkNode(8,"Value8"));
        dll3.print();
        dll3.update(new DLinkNode(0,"update the 0"));
        dll3.update(new DLinkNode(7,"update the 7"));
        dll3.update(new DLinkNode(9,"update the 9"));
        dll3.print();
        print("取得数据");
        print(dll3.get(0).toString());
        dll3 = new DoublyLinkList();
        print("清空数据");
        dll3.print();
        print(dll3.get(0));
        print("重新填充数据");
        dll3.add(dln1);
        dll3.add(dln3);
        dll3.print();
        print("测试数据");
        print(dll3.get(1).toString());
        print(dll3.get(2).toString());
        print(dll3.get(-1).toString());
        print(dll3.get(-2).toString());
        print(dll3.get(-3).toString());
        dll3.print();
    }
    public static void print(Object message){
        System.out.println(String.valueOf(message));
    }
}
