package com.forbetter223.LinkList;


/**
 * 双向链表也由一个一个的节点组成，但是和单向链表区分开的地方就是
 * 单向链表的每个节点由两部分组成，值和指向下一个节点的指针组成。
 * 而组成双向链表的节点由3部分组成，指向前一个节点的指针，值和指向下一个节点的指针。
 * 在代码的组织上和单链表相差不大，对数据的插入，取得没由太大的变化。
 * 在数据的更新和删除上，需要让变化节点有指向前一个节点的动作
 */
public class DoublyLinkList {
    // 双向链表的长度，默认值其实也是0
    public int Count = 0;

    // 双向链表的头节点，不是链表的第一个有实际值的节点
    // 更像是辅助节点，它没有前节点，它的后节点就是链表的第一个值
    private final DLinkNode headNode;

    public DoublyLinkList(){
        headNode = new DLinkNode(0,"");
    }

    public DoublyLinkList(DLinkNode... dLinkNodes){
        headNode = new DLinkNode(0,"");
        for (DLinkNode dLinkNode : dLinkNodes) {
            add(dLinkNode);
        }
    }

    /**
     * 头节点的get方法
     * @return 链表头节点
     */
    public DLinkNode getHeadNode() {
        return headNode;
    }

    /**
     * 向双向链表添加数据的方法
     * 向链表的末尾添加数据
     */
    public void add(DLinkNode addNode){
        DLinkNode dLinkNode = getHeadNode();
        while (dLinkNode.nextNode != null) {
            dLinkNode = dLinkNode.nextNode;
        }
        // 向链表末尾加入数据，需要做两个动作
        // 1.使原链表末尾的节点的下一个节点指向新加入的节点
        dLinkNode.nextNode = addNode;
        // 2.使新加入节点的前一个节点指向原链表的最后一个节点
        addNode.previousNode = dLinkNode;
        this.Count++;
    }

    /**
     * 把指定的节点从双向链表中删除
     * @param delNode 指定的节点
     */
    public void delete(DLinkNode delNode){
        DLinkNode dLinkNode = getHeadNode();
        // 判断在双向链表是否找到了要删除的节点
        boolean hasDelNode = false;
        while (true){
            if(dLinkNode == null){
                break;
            }
            // 在双向链表中找到和要删除节点一样的数据。
            if(dLinkNode.no == delNode.no && dLinkNode.value.equals(delNode.value)){
                hasDelNode = true;
                break;
            }
            dLinkNode = dLinkNode.nextNode;
        }
        if(hasDelNode){
            // 当在双向链表中找到了要删除的节点
            // 需要让本删除的上一个节点的nextNode链接到被删除节点的下一个节点上
            // 当要删除的节点是链表第一个有效值时
            if (dLinkNode.previousNode != null) {
                dLinkNode.previousNode.nextNode = dLinkNode.nextNode;
            }
            // 还需要让被删除节点的下一个节点的previousNode连接到被删除节点的上一个节点上
            // 如果要删除的节点是最后一个节点时
            if (dLinkNode.nextNode != null) {
                dLinkNode.nextNode.previousNode = dLinkNode.previousNode;
            }
            this.Count--;
        }else{
            // 要删除的节点不在双向链表中时，打印提示信息。
            System.out.println("要删除的节点不在该双向链表中。");
        }
    }

    /**
     * 根据传入的值修改双向链表的值
     * @param updateNode 替换链表中的值
     */
    public void update(DLinkNode updateNode){
        // 从头节点的下一个节点开始循环
        // 因为头节点的no初始值也为0，所以updateNode的no如果也为0，就会修改头节点的值
        // 我们不希望这样。因为头节点其实是辅助节点。
        DLinkNode dLinkNode = getHeadNode().nextNode;
        // 判断要替换的值是否在链表中存在
        boolean hasNode = false;
        while(dLinkNode != null){
            if(dLinkNode.no == updateNode.no){
                hasNode = true;
                break;
            }
            dLinkNode = dLinkNode.nextNode;
        }
        if(hasNode){
            // 只需要替换当前节点的值就行了。
            dLinkNode.value = updateNode.value;
        }else{
            System.out.println("要更新的节点不在该双向链表中。");
        }
    }

    /**
     * 从双向链表中取得指定位置的节点
     * 下坐标从0开始
     * @param index 需要取哪个位置的节点
     * @return 取得的节点
     */
    public DLinkNode get(int index) {
        // 判断是不是空链表
        if(getHeadNode().nextNode == null){
            System.out.println("链表为空");
            return getHeadNode();
        }
        // 判断参数index正负数
        if(index >=0 && index >= this.Count){
            System.out.println("参数超过链表的范围，无法取到对应的值。返回空节点：");
            return getHeadNode();
        }else if(index < 0 && Math.abs(index) > this.Count) {
            System.out.println("参数超过链表的范围，无法取到对应的值。返回空节点：");
            return getHeadNode();
        }
        if(index < 0){
            index = this.Count + index;
        }
        DLinkNode dLinkNode = getHeadNode().nextNode;

        int loopCnt = 0;
        while(dLinkNode != null){
            if(loopCnt == index){
                break;
            }
            dLinkNode = dLinkNode.nextNode;
            loopCnt++;
        }
        return dLinkNode;
    }
    /**
     * 输出打印双向链表
     */
    public void print(){
        DLinkNode dLinkNode = getHeadNode().nextNode;
        while (dLinkNode != null) {
            System.out.println(dLinkNode.toString());
            dLinkNode = dLinkNode.nextNode;
        }
    }

}
