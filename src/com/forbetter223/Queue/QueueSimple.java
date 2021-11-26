package com.forbetter223.Queue;

import java.util.Scanner;

public class QueueSimple {

    public static void main(String[] args){


//        QueueByArray queueByArray = new QueueByArray(3);
//        queueByArray.insertData(1);
//        System.out.println(queueByArray.printQueue());
//        queueByArray.insertData(2);
//        System.out.println(queueByArray.printQueue());
//        queueByArray.insertData(3);
//        System.out.println(queueByArray.printQueue());
//        queueByArray.getDataFromQueue();
//        System.out.println(queueByArray.printQueue());
//        queueByArray.getDataFromQueue();
//        System.out.println(queueByArray.printQueue());
//        queueByArray.getDataFromQueue();
        // test Queue
        CircularQueueByArray queue = new CircularQueueByArray(3);
        char inputKey;
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("p(print):打印队列所有值");
            System.out.println("q(quit):退出程序");
            System.out.println("i(insert):往队列里添加数据");
            System.out.println("g(get):依次取出/删除队列里的数据");
            System.out.println("f(front):查看front的值和它对应的元素");
            System.out.println("r(rear):查看rear的值和它对应的元素");
            // 接收用户输入的一个命令或值
            inputKey = sc.next().charAt(0);
            switch(inputKey){
                case 'p':
                    queue.showQueueData();
                    break;
                case 'q':
                    sc.close();
                    loop = false;
                    break;
                case 'i':
                    System.out.println("请输入一个数字：");
                    int number = sc.nextInt();
                    queue.insertDataToQueue(number);
                    break;
                case 'g':
                    try{
                        int getValue = queue.getDataFromQueue();
                        System.out.printf("取出的数据是%d\n", getValue);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'f':
                    try{
                        System.out.printf("front = %d; ", queue.getFront());
                        int getValue = queue.showHeadData();
                        System.out.printf("queue[front]=%d \n", getValue);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'r':
                    try{
                        System.out.printf("rear = %d; ", queue.getRear());
                        int getValue = queue.showRearData();
                        System.out.printf("queue[rear]=%d \n", getValue);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
