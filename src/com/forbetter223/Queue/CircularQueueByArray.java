package com.forbetter223.Queue;

/**
 * 这个队列是循环队列，如果队列还有空位就可以重复向队列中添加数据
 * 环形队列用到的小算法：
 * 判断队列是否满：(rear + 1) % queueLength == front
 * rear/front向后移：(rear + 1) % queueLength ; (front + 1) % queueLength
 * 队列中有效数据：(rear + queueLength - front) % queueLength
 */
public class CircularQueueByArray {
    // 虽然是环形队列，但是我们也要给队列指定它的大小
    private int maxSize;
    // 队列的头指针
    private int front;
    // 队列的尾指针
    private int rear;
    // 数组模拟队列
    private int[] circularQueue;

    /**
     * 初始化队列
     *
     * @param circularQueueSize
     */
    CircularQueueByArray(int circularQueueSize) {
        this.maxSize = circularQueueSize;
        // 注意和非环形队列区别，环形队列我们指定头指针指向队列的第一个元素
        this.front = 0;
        // 环形队列我们也指定尾指针也从队列的第一个元素开始
        // 我们约定尾指针指向队列最后一个元素的后一个位置，
        // 因为希望空出一个空间作为约定空间
        // 表现在队列中是什么样的呢？
        // 假如我们定义队列的长度为7，那么在队列中最多可以存储6个数据
        this.rear = 0;
        this.circularQueue = new int[this.maxSize];
    }

    /**
     * 向队列添加数据
     *
     * @param data
     */
    public void insertDataToQueue(int data) {
        // 判断队列是否为空
        if (isFull()) {
            System.out.println("环形队列已满，不能加入数据！");
            return;
        }
        // 直接将数据加入
        this.circularQueue[this.rear] = data;
        // 对rear进行操作
        // 因为加入了数据，需要将rear后移。
        // 如果我们假设rear已经是最后一个元素，队列的前几个元素已经被取出，
        // 这就说明队列的前几位已经空出，所以我们需要对rear取模，以便可以
        // 将数据插入到队列的前几位空位置
        // 为什么rear + 1,因为我们约定需要给rear留空位。
        this.rear = (this.rear + 1) % this.maxSize;
    }

    /**
     * 从环形队列取出数据
     *
     * @return
     */
    public int getDataFromQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            // 抛出异常
            throw new RuntimeException("环形队列为空，不能取出数据。");
        }
        // 要记住，front是指向队列的第一个元素，我们按照一下步骤取数据
        // 1.用一个临时变量来保存front对应的元素
        // 2.将front后移;也要取模，否则会报数组下标越界
        // 3.将临时变量return
        int returnValue = this.circularQueue[this.front];
        this.front = (this.front + 1) % maxSize;
        return returnValue;
    }

    /**
     * 打印环形队列
     */
    public void showQueueData() {
        // 判断队列是否为空
        if (isEmpty()) {
            System.out.println("环形队列为空，不能显示数据。");
            return;
        }
        // 首先从front开始遍历
        // 遍历队列中的有效数据
        for(int i = this.front; i <= getCircularQueueExistDataCount(); i++){
            System.out.printf("circularQueue[%d]=%d\n",i%maxSize,circularQueue[i%maxSize]);
        }
        System.out.println("---------------");
        for(int i = 0; i< this.circularQueue.length; i++){
            System.out.printf("meta circularQueue[%d]=%d\n",i,circularQueue[i]);
        }
    }

    /**
     * 打印环形队列的第一个元素
     * @return
     */
    public int showHeadData(){
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("环形队列为空，不能取出数据。");
        }
        return circularQueue[front];
    }

    /**
     * 打印环形队列的rear
     * @return
     */
    public int showRearData(){
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("环形队列为空，不能取出数据。");
        }
        return circularQueue[rear];
    }

    /**
     * front
     * @return
     */
    public int getFront() {
        return front;
    }

    /**
     * rear
     * @return
     */
    public int getRear() {
        return rear;
    }

    /**
     * 得到环形队列中的有效数据
     * @return
     */
    private int getCircularQueueExistDataCount(){

        // test data
        // r:3; m:7; f:0
        // r:5; m:7; f:1
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 判断队列是否满
     *
     * @return
     */
    private boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    private boolean isEmpty() {
        return rear == front;
    }
}
