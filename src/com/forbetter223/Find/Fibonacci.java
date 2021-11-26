package com.forbetter223.Find;

import java.util.Arrays;

/**
 * 斐波那契查找
 * 黄金分割点查找
 */
public class Fibonacci {
    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 10, 89, 1000, 1234};
        find(array,50);
    }

    /**
     * 查找
     * 非递归
     *
     * @param params    有序目标数组
     * @param findValue 查找的值
     * @return 值所对应的坐标
     */
    private static int find(int[] params, int findValue) {
        // 数组最低位
        int low = 0;
        // 数组最高位
        int high = params.length - 1;
        // 斐波那契数列分割值的下坐标
        int goldIndex = 0;
        // 分割点
        int middle = 0;
        // 获取到斐波那契数列
        int[] fibonacciArray = createFibonacci(params.length);
        // 计算goldIndex
        // exp: params的数组长度是6
        // 斐波那契数列的值 0，1，1，2，3，5，8，13，21，34
        // 那么最终goldValue = 8 ,goldIndex = 6
        while(high > fibonacciArray[goldIndex]){
            goldIndex++;
        }
        // 切片params数组
        int[] temp = Arrays.copyOf(params,fibonacciArray[goldIndex]);
        // 切片之后下坐标比params.length-1大的都是0，需要把它们替换成params最后的一个数值
        // 1, 8, 10, 89, 1000, 1234 => 1, 8, 10, 89, 1000, 1234,1234,1234,1234
        for (int i = high + 1; i < temp.length; i++) {
            if(temp[i] == 0){
                temp[i] = params[high];
            }
        }
        // 黄金分割点取出来之后，进行查找
        while(low <= high){
            middle = low + fibonacciArray[goldIndex - 1] - 1;
            if(findValue < temp[middle]){
                // 向左查找
                high = middle - 1;
                goldIndex--;
            }else if (findValue > temp[middle]) {
                // 向右查找
                low = middle + 1;
                goldIndex -= 2;
            }else if(findValue == temp[middle]){
                // 找到
                System.out.println(middle > high ? high : middle);
                return middle > high ? high : middle;
            }
        }
        return -1;
    }

    /**
     * 根据传入的数组长度大小创建一个斐波那契数列
     *
     * @param maxSize 数组长度
     * @return 斐波那契数列
     */
    private static int[] createFibonacci(int maxSize) {
        // 为了避免数组长度太小对返回的斐波那契数列长度+1
        int[] fibonacciArray = new int[maxSize + 1];
        // 斐波那契数列前两位固定
        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;
        int i = 2;
        while(maxSize >= fibonacciArray[i - 1]  + fibonacciArray[i - 2]){
            // 为数列赋值，直到斐波那契数列的值>=传入的数组长度
            fibonacciArray[i] = fibonacciArray[i - 1]  + fibonacciArray[i - 2];
            i++;
        }
        // 为斐波那契数列多加一个值
        fibonacciArray[i] = fibonacciArray[i - 1]  + fibonacciArray[i - 2];
        return fibonacciArray;
    }
}
