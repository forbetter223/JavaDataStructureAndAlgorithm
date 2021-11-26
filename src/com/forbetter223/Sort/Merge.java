package com.forbetter223.Sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class Merge {
    public static void main(String[] args){
        int[] array = new int[]{8,4,5,7,1,3,6,2};
        // 用空间换时间
        int[] temp = new int[array.length];
        sort(array,0,array.length - 1, temp);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] params, int paLeft, int paRight, int[] paTemp){
        if(paLeft < paRight){
            int mid = (paLeft + paRight) / 2;
            // 向左分解
            sort(params,paLeft,mid,paTemp);
            // 向右分解
            sort(params,mid + 1, paRight,paTemp);
            merge(params,paLeft,mid,paRight,paTemp);
        }
    }
    /**
     * 合并方法
     * @param params 排序对象
     * @param pLeft 左边索引
     * @param pMiddle 中间索引
     * @param pRight 右边索引
     * @param temp 中转变量
     */
    private static void merge(int[] params,int pLeft,int pMiddle,int pRight,int[] temp){
        // 对数组进行左右分割
        // 需要两个变量记录左右分割后两部分的最左下坐标
        // 左边数组的第一个值得下坐标
        int left = pLeft;
        // 右边数组得第一个值得下坐标
        int right = pMiddle + 1;
        // 记录中间数组变量的下坐标
        // 当往中间数组变量temp里增加值时，t需要++;
        int t = 0;
        // 同时循环左右两部分有序数组，
        // 按照从小到大的顺序把它们的值分别插入到
        // 临时变量temp中，t需要++
        while(left <= pMiddle && right <= pRight){
            // 如果left对应的值小于right对应的值
            // 需要先把left的值插入到temp中
            if (params[left] <= params[right]){
                temp[t] = params[left];
                // temp里增加了一个数据自然需要把下坐标也相应的+1
                t++;
                // left对应的值已经被插入到temp里，需要对left的下一个值进行判断
                // 所以left需要++
                left++;
            }else{
                // 如果右边right对应的值比左边left对应的值小
                // 需要把右边right对应的值插入到temp里
                temp[t] = params[right];
                t++;
                right++;
            }
        }
        // 当第一个while循环结束后，左右两个部分的有序数组可能还有未跑完的情况，
        // 这时候需要把未跑完的数组的剩下的数组依次插入到temp里
        // 左边的数组未跑完时
        while(left <= pMiddle){
            // 把剩余数组插入到temp里
            temp[t] = params[left];
            t++;
            left++;
        }
        // 右边的数组未跑完时
        while(right <= pRight){
           // 把剩余数组插入到temp里
            temp[t] = params[right];
            t++;
            right++;
        }
        // temp里已经是一个有序的数组了，
        // 把temp里的值覆盖到原数组params里
        t = 0;
        // 覆盖的数组起点从pLeft动态变化，因为不是每次都需要覆盖params.length次数组
        int tmpLeft = pLeft;
        while (tmpLeft <= pRight){
            params[tmpLeft] = temp[t];
            t++;
            tmpLeft++;
        }
    }
}
