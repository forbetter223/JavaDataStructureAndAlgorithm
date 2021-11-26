package com.forbetter223.Queue;

/**
 * 用数组模拟一个队列
 * 队列的特点：
 * 1.先进先出
 * 2.从队列取数据其实就是队列的头指针+1
 * 3.向队列添加数据就是队列的尾指针+1
 * 包含的主要操作：
 * 1.初始化
 * 2.向队列添加值
 * 3.从队列取值
 * 注意：
 * 这个类模拟的队列只能使用一次，也就是说如果队列满了，你创建的队列对象就只能取数据，不能加数据
 * 当从这个队列取完数据，这个队列就会报废；
 * 如果想想服用队列，请参照CircularQueueByArray.
 */
public class QueueByArray {
    // 必须指定这个队列的大小
    private int queueLength;
    // 定义队列的头指针
    private int front;
    // 定义队列的尾指针
    private int rear;
    // 用一维数组模拟队列
    private int[] queue;

    /**
     * 初始化队列
     * @param queueLength 指定队列的大小
     */
    public QueueByArray(int queueLength){
        // 当创建一个队列时，必须指定队列的大小
        this.queueLength = queueLength;
        // 定义一维数组
        this.queue = new int[this.queueLength];
        // 初始化头指针
        this.front = -1;// 为什么头指针初始化成-1呢？因为数组的下坐标是从0开始的，如果定义成0就代表队列已经有值了。
                        // 当然也可以定义队列的起始位置从1开始，相应的队列的长度要+1。我们这儿遵循数组的原始结构从0开始，所以定义成-1.
        // 初始化尾指针
        this.rear = -1;
    }

    /**
     * 向队列添加数据
     * @param data 要添加的数据
     */
    public void insertData(int data){
        // 添加数据前肯定要判断这个队列还有没有空位能添加数据
        if(insertDataAble()){
            // 添加数据时，队列尾指针向上移动
            this.rear++;
            this.queue[rear] = data;
        }else{
            // 当不能添加数据时抛出exception
            throw new RuntimeException("队列以满，不能存放数据。");
        }
    }

    /**
     * 从队列取数据
     * @return 取出的数据
     */
    public int getDataFromQueue(){
        // 取数据之前我们应该判断这个队列有没有数据
        if(getDataAble()){
            // 取数据时，队列头指针向上移动
            this.front++;
            // 这里为什么先对front++呢
            // 因为头指针永远指向当前数据的前一个坐标。
            // 可以试想一下，如果队列的大小为3，我向队列添加一个数据，rear++从-1变成0
            // 这个数据是第一个数据，下坐标为0
            // front还是-1没变
            // 要取出第一个数据，如果用front做为下坐标的话，必须让它先+1才能取出第一个数据。
            return this.queue[front];
        }else{
            // 当不能取出数据时抛出exception
            throw new RuntimeException("队列为空，不能取出数据。");
        }
    }

    /**
     * 打印队列关键信息
     * @return
     */
    public String printQueue(){
        return "front = " + this.front + ", rear = " + this.rear + ", firstData = " + this.queue[this.front + 1];
    }

    /**
     * 判断队列是否还有空位能插入数据
     * @return 如果尾指针已经等于队列的长度减1了，就说明队列已经满了
     *         没有位置能插入数据了
     */
    private boolean insertDataAble(){
        return this.rear < this.queueLength -1;
    }

    /**
     * 判断队列是否有数据能被取出
     * @return 当队列为空或者头指针和尾指针重合时，就代表队列的数据已经清空了
     */
    private boolean getDataAble(){
        return this.front != this.rear;
    }
}
