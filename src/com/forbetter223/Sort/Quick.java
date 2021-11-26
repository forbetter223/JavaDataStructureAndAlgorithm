package com.forbetter223.Sort;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args){
        sort(new int[]{6,1,2,7,9,3,4,5,10,8},0,9);
//        sort(new int[]{-9,78,0,23,-567,70},0,5);
    }
    private static void sort(int[] params, int leftIndex, int rightIndex){

        int left = leftIndex;
        int right = rightIndex;
        int temp = 0;
        // 从数组的中间取基准值
        int middle = params[(left + right) / 2];
        System.out.printf("middle = %d \n",middle);
        // 循环体：比中间基准值middle小的值放到基准值左边，
        // 大的值放到基准值middle的右边
        while(left < right){
            // 左循环体
            // 找到比middle大的值，否则一直循环
            while(params[left] < middle){
                left += 1;
            }
            // 右循环体
            // 在右边找到比middle值小的值，否则一直循环
            while(params[right] > middle){
                right -= 1;
            }
            // 当left和right一直循环总有left >= right的时候
            // 那时候就跳出循环
            if(left >= right){
                break;
            }
            // 在左循环体找到比middle大的值
            // 在右循环体找到比middle小的值
            // 数据开始交换
            temp = params[left];
            params[left] = params[right];
            params[right]= temp;
            System.out.println(Arrays.toString(params));
            // 如果数据交换完成后，params[left] == middle 时，这个值不进行判断,对这个值的前一个值进行判断
            // right-- ,right前移
            if(params[left] == middle){
                right--;
            }
            // 如果数据交换完成后，params[right] == middle 时，
            // 说明是右边的值被middle交换到了左边，而middle被 交换到了右边
            // 左边的值肯定比middle小了。所以左边index需要++;
            // 这个值不进行判断,对这个值的后一个值进行判断
            // left++ ,left后移
            if(params[right] == middle){
                left++;
            }
        }
        // 一轮循环完成后，middle左边的值都比middle小，右边的值都比middle大
        // 开始递归
        // 首先为了防止栈溢出，需要判断left和right的值
        if(left == right){
            System.out.println("left == right");
            left++;
            right--;
        }
        // 向左递归
        if(leftIndex < right){
            sort(params, leftIndex, right);
        }
        // 向右递归
        if(rightIndex > left){
            sort(params, left, rightIndex);
        }
        System.out.println(Arrays.toString(params));
    }
}









