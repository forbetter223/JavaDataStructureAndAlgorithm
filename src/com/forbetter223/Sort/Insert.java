package com.forbetter223.Sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class Insert {

    public static void main(String[] args) {
        int[] runArray = new int[]{96, 23, 99, 11, 5, 3};
        sort(runArray);
//        第1波
//                [23, 96, 99, 11, 5, 3]
//        第2波
//                [23, 96, 99, 11, 5, 3]
//        第3波
//                [11, 23, 96, 99, 5, 3]
//        第4波
//                [5, 11, 23, 96, 99, 3]
//        第5波
//                [3, 5, 11, 23, 96, 99]
        sort(new int[]{22,52,52,3,1});
//        第1波
//                [22, 52, 52, 3, 1]
//        第2波
//                [22, 52, 52, 3, 1]
//        第3波
//                [3, 22, 52, 52, 1]
//        第4波
//                [1, 3, 22, 52, 52]
    }

    /**
     * 插入排序，从小到大排序
     * 例如：96,23,99,11,5,3
     * 一共进行数组-1次大的排序
     * 第一轮：以原始数组第一个元素96做为已经完成排序的集合，
     * 23，99，11，5，3做为未排序的集合。
     * 以未排序集合的第一个元素跟已完成排序集合的96相比较，比96小，23插入到96前面。
     * 第一轮结果：23，96，99，11，5，3
     * 第二轮，已完成排序的集合为23，96；未完成排序的集合为99，11，5，3
     * 未完成排序集合的第一个元素99，去和已完成排序集合23，96的最后一个元素96相比较，比96大，99的位置不动。
     * 第二轮结果：23，96，99，11，5，3
     * 第三轮，已完成排序的集合为23，96，99；未完成排序的集合为11，5，3
     * 未完成排序集合的第一个元素11，去和已完成排序集合23，96,99的最后一个元素99相比较，比99小，
     * 再和已完成排序集合的倒数第二个元素96相比较，比96小，再和23比较，比23小，11插入到23前
     * 第三轮比较结果：11，23，96，99，5，3
     * 第四轮，第五轮一次比较。
     * 最后得到结果：3，5，11，96，99
     *
     * @param params
     */
    private static void sort(int[] params) {
        int currentValue;
        int previousIndex;
        // 数组的第一个元素默认为有序集合，所以i从1开始循环
        for (int i = 1; i < params.length; i++) {
            // 用第i个元素和前一个元素相比较,这个值的位置在比较结束前不能改变
            currentValue = params[i];
            // 当前元素前移元素的下坐标
            previousIndex = i - 1;
            while(previousIndex >= 0 && currentValue < params[previousIndex]){
                // 如果碰到 currentValue比previousValue的值小，顺序后移
                params[previousIndex + 1] = params[previousIndex];
                // 前移
                previousIndex--;
            }
            // 有不交换的情况
            if(i != previousIndex + 1){
                params[previousIndex + 1] = currentValue;
            }
            System.out.printf("第%d波\n", i);
            System.out.println(Arrays.toString(params));
        }
    }
}
