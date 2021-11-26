package com.forbetter223.LinkList;

/**
 * 循环链表就是链表的所有节点首尾相连起来
 * 和循环队列不一样，它不用进行取模运算
 * 比如循环队列判断队列是否以满：(rear + 1)%queueLength == front
 * 循环链表不需要判断链表是否满。
 * 循环队列rear和front指针上移进行队列的增/删数据需要取模：
 * （rear + 1）%queueLength;(front + 1)%queueLength.
 * 循环链表永远从链表头开始循环，然后对数据进行操作。
 * 判断循环队列中的有效数据：（rear + queueLength - front）% queueLength
 * 循环链表的长度就是链表里的有效数据。
 */
public class CircularLinkList {
    // 循环链表用单链表的节点,就是只有nextNode,没有previousNode
    // 记录链表的第一个节点，就是为了让尾节点的nextNode指向它，形成一个环。
    private LinkNode firstNode = new LinkNode(-1,"");
    // 一个辅助节点，它一直指向链表的最后一个节点
    private LinkNode lastNode = new LinkNode(-1,"");
    public int Count = 0;

    public CircularLinkList(){

    }
    public CircularLinkList(LinkNode... nodes){
        for(LinkNode ln : nodes){
            add(ln);
        }
    }
    /**
     * 循环列表的特点是所有节点首位相接形成一个环
     * 当链表里只有一个节点时，它的nextNode就是它本身。
     * 当有多个节点时，依次相连接后最后一个节点的nextNode是第一个节点
     * @param addNode 增加的节点
     */
    public void add(LinkNode addNode){
        // 当firstNode的下一个节点为空时说明链表为空
        if(firstNode.nextNode == null){
            // 把传入的节点当作第一个节点
            firstNode = addNode;
            // 当前节点指向第一个节点，它总指向链表最后一个节点
            lastNode = firstNode;
        }
        // currentNode的nextNode要和新加入的节点连接上
        lastNode.nextNode = addNode;
        // 新加入的节点的nextNode要链接到第一个节点，形成一个环
        addNode.nextNode = firstNode;
        // currentNode向后移，使它永远指向链表的最后一个节点
        lastNode = addNode;
        this.Count++;
    }
    /**
     * 打印链表的内容
     */
    public void print(){
        // 头节点不打印，所以我们直接从头节点的nextNode开始判断为不为空
        LinkNode printNode = firstNode;
        while (printNode.nextNode != firstNode){
            // 先打印，后位移
            System.out.println(printNode.toString());
            printNode = printNode.nextNode;
        }
        System.out.println(printNode.toString());
    }

    /**
     * 约瑟夫问题
     *  * N个节点组成一个链表，从第m个节点开始，每数s个节点就删除该节点
     *  * 问节点被移除出去的顺序。
     *  * 举个例子：
     *  * 有5个节点组成一个环形链表（1，2，3，4，5），从第一个节点开始，每数2个节点就删除该节点
     *  * 第一次删除2。 1，3，4，5从3开始再数2个节点。
     *  * 第二次删除4。 1，3，5从5开始再数2个节点。
     *  * 第三次删除1. 3，5从3开始再数2个节点。
     *  * 第四次删除5. 只剩余一个3
     *  * 第五次删除3.
     * @param start 从环形链表第几个节点开始循环
     * @param interval 间隔多少个节点取出节点
     */
    public void josephi(int start, int interval){
        // 首先对参数进行校验，start和interval肯定不能小于1
        if(start < 1 || interval < 1){
            System.out.println("参数验证失败，请输入有效数字。");
        }
        // start和interval 有可能是比链表总长大的数。
        start = start % this.Count;
        interval = interval % this.Count;
        // 从第start开始循环，我们就需要把first和last节点移动相应的位置
        for(int i = 1; i < start; i++){
            firstNode = firstNode.nextNode;
            lastNode = lastNode.nextNode;
        }
        // 开始移除第interval节点
        while(lastNode.nextNode != lastNode){
            // first 为要移出的点
            // last 为移出节点的前一节点
            for(int l = 1; l < interval; l++){
                firstNode = firstNode.nextNode;
                lastNode = lastNode.nextNode;
            }
            System.out.println("移出节点：" + firstNode.toString());
            // first节点指向移出节点的下一个节点
            firstNode = firstNode.nextNode;
            // 保持last节点的下一个节点是first节点
            lastNode.nextNode = firstNode;
        }
        System.out.println("最后移出节点：" + lastNode.toString());
    }
}
