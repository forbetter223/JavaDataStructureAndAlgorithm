package com.forbetter223.Stack;

/**
 * 简单模拟Java的Stack类
 * Stack也属于线形数据结构
 * 特点：
 * 1.先进后出。
 * 2.仅限在栈顶进行对数据的添加和删除动作。
 */
public class ImitationStack {
    // 栈的大小
    public int Size = 0;
    // 栈顶元素坐标
    private int top = -1;
    // 用数组存储栈类型
    private String[] strStack;

    /**
     * 构造函数，需要确定栈的大小
     */
    public ImitationStack(int size){
        strStack = new String[size];
        this.Size = size;
    }

    /**
     * 数据压栈，进栈方法
     * @param data 压栈数据
     */
    public void push(String data){
        if(isFull()){
            System.out.println("栈已满，不能进行压栈。");
            return;
        }
        top++;
        strStack[top] = data;
        System.out.printf("%s 已入栈。\n",strStack[top]);
    }

    /**
     * 数据出栈
     */
    public void pop(){
        if(isEmpty()){
            System.out.println("栈已空，不能进行出栈。");
            return;
        }
        System.out.printf("数据 %s 已出栈。\n",strStack[top]);
        top--;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    private boolean isEmpty(){
        return top == -1;
    }

    /**
     * 判断栈是否已满
     * @return
     */
    private boolean isFull(){
        return top == this.Size - 1;
    }
}
