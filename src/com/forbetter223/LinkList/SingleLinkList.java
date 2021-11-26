package com.forbetter223.LinkList;

import java.util.Stack;

/**
 * 单链表
 * 单链表是由多个节点组成的一串单向索引存储结构。
 * 每个节点由两部分组成：第一部分存储这个节点的值，第二部分存放指向下一个节点的地址。
 * 单链表的数据是连续的，也就说我们可以根据它的index取出对应的值；
 * 但是它在内存中是不一定连续的。数据相邻的两个节点可能在同一块内存区域，也可能不同。
 * 因为单链表是通过它节点中保存的下一个节点的地址来关联它下一数据的。
 */
public class SingleLinkList {
    // 链表的长度，默认为0
    public int count;
    // 链表的头节点，它是不动的，不变的，它后面的链表不论怎么变，它都不变
    // 其实是链表循环的起始位和参照物
    private LinkNode headNode;

    public SingleLinkList(){
        this.headNode = new LinkNode(0,"");
    }

    /**
     * 在链表的尾部添加数据
     * @param node
     */
    public void add(LinkNode node){
        // 从头节点开始遍历
        LinkNode tmpNode = headNode;
        // 在单链表中只能单向循环，它的最后一个节点的next为空
        while(true){
            // 当节点循环到位空时就说明是最后一个节点，我们就把要新加入的节点
            // 链接到最后一个节点。
            if(tmpNode.nextNode == null){
                break;
            }
            // 如果不是最后一个节点就把下一个节点赋值给tmpNode
            tmpNode = tmpNode.nextNode;
        }
        tmpNode.nextNode = node;
        count++;
    }

    /**
     * 在向链表中添加数据的时候使这些数据根据No.自动排序
     */
    public void addBySort(LinkNode node){
        LinkNode tmpNode = headNode;
        while(true){
            if(tmpNode.nextNode == null){
                break;
            }
            // 注意：
            // 单链表是单向循环不可逆的，要插入的节点一定要比前一个节点的no大并且一定要比后一个节点的no小
            // 所以我们一定要循环到要插入节点所在位置的前一个节点才行，为什么？
            // 因为我们如果循环到插入节点的后一个节点，我们就不知道这个被插入的节点的前一个节点的地址。
            if(tmpNode.nextNode.no > node.no){
                // 当遇到第一个no比插入节点node的no大时，先退出循环，然后把node链接到当前节点
                break;
            }
            tmpNode = tmpNode.nextNode;
        }
        node.nextNode = tmpNode.nextNode;
        tmpNode.nextNode = node;
        this.count++;
    }

    /**
     * 打印链表的内容
     */
    public void print(){
        // 头节点不打印，所以我们直接从头节点的nextNode开始判断为不为空
        LinkNode printNode = headNode.nextNode;
        while (true){
            if(printNode == null){
                break;
            }
            // 先打印，后位移
            System.out.println(printNode.toString());
            printNode = printNode.nextNode;
        }
    }

    /**
     * 根据数据如的坐标找到该坐标的节点
     * @param index 链表的坐标值
     * @return 节点
     */
    public LinkNode get(int index){
        // 对于参数index，首先只有index <= 链表的count-1时才有可能取到值
        // 再一个，index可能是正数也可能是负数，正数的时候我们直接取链表相应
        // 位置的linkNode即可。
        // 如果index < 0,则取得链表的count + index才行
        // 判断是不是只有头节点
        LinkNode linkNode = headNode.nextNode;
        if(linkNode == null || this.count == 0){
            System.out.println("该链表为空，不能取得指定数据");
            return null;
        }
        // 判断index是否超出范围 -4 3
        if (index < 0 && Math.abs(index) > this.count || index >= 0 && index > this.count - 1) {
            System.out.println("指定的index超出链表范围。");
            return null;
        }
        // 链表的下坐标从0开始，所以定义nodeIndex初始值为-1
        int nodeIndex = -1;
        if(index >= 0){
            nodeIndex = index;
        }else{
            nodeIndex = this.count + index;
        }
        // 定义一个计数器，计算循环到第几个节点了
        int loopCount = 0;
        while(true){
            if(linkNode == null || nodeIndex == loopCount){
                break;
            }
            loopCount++;
            linkNode = linkNode.nextNode;
        }
        return linkNode;
    }

    /**
     * 根据数据如的坐标找到该坐标的节点
     * 链表的index 从1开始
     * @param index 链表的坐标值
     * @return 节点
     */
    public LinkNode getValueIndexFrom1(int index){
        // 对于参数index，首先只有index <= 链表的count时才有可能取到值
        // 再一个，index可能是正数也可能是负数，正数的时候我们直接取链表相应
        // 位置的linkNode即可。
        // 如果index < 0,则取得链表的count + index才行
        // 判断是不是只有头节点
        LinkNode linkNode = headNode;
        if(linkNode.nextNode == null || this.count == 0){
            System.out.println("该链表为空，不能取得指定数据");
            return null;
        }
        // 判断index是否超出范围
        if (Math.abs(index) > this.count) {
            System.out.println("指定的index超出链表范围。");
            return null;
        }
        // 判断index是不是0
        if(index == 0){
            System.out.println("该方法的index是从1开始的，所以请选择一个不等于0的数");
            return null;
        }
        // 链表的下坐标从1开始，所以定义nodeIndex初始值为0
        int nodeIndex = 0;
        if(index > 0){
            nodeIndex = index;
        }else{
            nodeIndex = this.count + index;
        }
        // 定义一个计数器，计算循环到第几个节点了
        int loopCount = 0;
        while(true){
            if(linkNode.nextNode == null || nodeIndex == loopCount){
                break;
            }
            linkNode = linkNode.nextNode;
            loopCount++;
        }
        return linkNode;
    }

    /**
     * 删除指定位置的节点
     * @param index
     */
    public void delete(int index){
        // 对于参数index，首先只有index <= 链表的count-1时才有可能删除该值
        // 再一个，index可能是正数也可能是负数，正数的时候我们直接删除链表相应
        // 位置的linkNode即可。
        // 如果index < 0,则删除链表的count + index才行
        // 我们删除链表指定节点的时候，首先循环链表，
        // 当我们循环到指定位置的前一个节点就能开始删除指定节点了，
        // 如果我们循环到指定节点再删除时，我们就无法知道被删除节点的前一个节点
        // 的信息，也就无法把前一个节点的nextNode绑上被删除节点下一个节点
        LinkNode linkNode = headNode;
        if(linkNode == null || this.count == 0){
            System.out.println("该链表为空，不能取得指定数据");
            return;
        }
        // 判断index是否超出范围
        if (Math.abs(index) > this.count - 1) {
            System.out.println("指定的index超出链表范围。");
            return;
        }
        // 链表的下坐标从0开始，所以定义nodeIndex初始值为-1
        int nodeIndex = -1;
        if(index >= 0){
            nodeIndex = index;
        }else{
            nodeIndex = this.count + index;
        }
        // 定义一个计数器，计算循环到第几个节点了
        int loopCount = 0;
        while(true){
            if(linkNode.nextNode == null || nodeIndex == loopCount){
                break;
            }
            loopCount++;
            linkNode = linkNode.nextNode;
        }
        if(linkNode.nextNode != null && linkNode.nextNode.nextNode != null){
            linkNode.nextNode = linkNode.nextNode.nextNode;
        }else {
            linkNode.nextNode = null;
        }
        this.count--;
    }

    /**
     * 利用stack逆序打印链表
     */
    public void reversePrint(){
        Stack<LinkNode> stackNode = new Stack<LinkNode>();
        LinkNode linkNode = this.headNode;
        while(true){
            if(linkNode.nextNode == null){
                break;
            }
            // 头节点不压入栈中
            linkNode = linkNode.nextNode;
            stackNode.push(linkNode);
        }
        // 打印
        while(stackNode.size() > 0){
            System.out.println(stackNode.pop());
        }
    }

    /**
     * 链接两个链表
     * @param link
     */
    public void rangeLink(SingleLinkList link){
        LinkNode paramLinkNode = link.headNode;
        while(true){
            if(paramLinkNode == null){
                break;
            }
            paramLinkNode = paramLinkNode.nextNode;
            this.add(paramLinkNode);
        }
    }

    /**
     * 更新链表中其中一个node值
     * @param updateNode
     */
    public void update(LinkNode updateNode){
        // 首先链表为空的时候打印输出提示信息
        LinkNode linkNode = this.headNode;
        if(this.headNode.nextNode == null){
            System.out.println("链表为空~");
        }
        // 创建一个变量记录如果在链表里找到这个节点就设置它为true;
        boolean hasData = false;
        while(true){
            // 为什么把判断no放到nextNode前面？
            // 如果修改的node正好是最后链表最后一个节点
            // 如果先判断nextNode，很明显它的nextNode为空，跳出循环
            // hasData 为false,我们无法修改最后一个节点的值
            if(linkNode.no == updateNode.no){
                hasData = true;
                break;
            }
            if(headNode.nextNode == null){
                break;
            }
            linkNode = linkNode.nextNode;
        }
        if(hasData){
            linkNode.value = updateNode.value;
        }else{
            System.out.println("链表中没有要更新的节点");
        }
    }
}
