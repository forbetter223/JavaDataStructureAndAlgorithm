package com.forbetter223.Sort;

import java.util.Arrays;

/**
 * 冒泡排序：
 * 1.每次循环两个相邻元素，判断两个元素的大小，如果逆序就交换位置
 * 2.每经过一轮循环就确定最后一个元素的位置，所以再次循环的时候会比第一次循环少执行一次。
 * 3.没有优化的冒泡排序会经过数组length-1次大循环。
 * 时间复杂度：O(n^2)
 * 稳定
 */
public class Bubble {
    public static void main(String[] args) {

        sort( new int[] { 1,221,10,-3,0,8,-5});
        System.out.println("-------------------");
        sort(new int[]{1, 9, 10, -3, 0, 8, 7});
        System.out.println("-------------------");
        sortOptimization(new int[]{1, 9, 10, -3, 0, 8, 7});
        int[] testArr = new int[80000];
        for(int i = 0; i < testArr.length;i++){
            testArr[i] = (int)(Math.random() * 100000);
        }
        long begin = System.currentTimeMillis();
        sortOptimization(testArr);
        long end = System.currentTimeMillis();
        System.out.printf("冒泡排序执行了 %d Millis秒", end - begin);
    }

    /**
     * 从小到大排列
     *
     * @param params
     */
    private static void sort(int[] params) {
        // 最外层循环控制总的大循环次数
        // 两个元素互换时需要一个临时变量存储它们其中一个的值
        int tmp;
        for (int i = params.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (params[j] > params[j + 1]) {
                    tmp = params[j];
                    params[j] = params[j + 1];
                    params[j + 1] = tmp;
                }
            }
            Arrays.stream(params).forEach(item -> System.out.printf("%d ", item));
            System.out.println();
        }
    }

    /**
     * 优化冒泡排序
     * 如果在某一次大循环中没有产生元素位置交换，结束冒泡排序
     * 从小到大排列
     *
     * @param params
     */
    private static void sortOptimization(int[] params) {
        // 最外层循环控制总的大循环次数
        // 两个元素互换时需要一个临时变量存储它们其中一个的值
        int tmp;
        for (int i = params.length - 1; i > 0; i--) {
            // 优化冒泡
            // 如果在某一次大循环中没有产生元素位置交换，结束冒泡排序
            boolean termination = true;
            for (int j = 0; j < i; j++) {
                if (params[j] > params[j + 1]) {
                    tmp = params[j];
                    params[j] = params[j + 1];
                    params[j + 1] = tmp;
                    // 记录下是否有位置交换
                    termination = false;
                }
            }
            // 如果没有位置交换就结束冒泡排序
            if (termination) {
                break;
            }
//            Arrays.stream(params).forEach(item -> System.out.printf("%d ", item));
//            System.out.println();
        }
    }
}
