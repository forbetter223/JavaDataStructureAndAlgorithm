package com.forbetter223.Sort;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 基数排序
 * 桶排序
 */
public class Radix {
    public static void main(String[] args) {
        int[] array = new int[]{53, 3, 542, 748, 14, 214};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 从小到大排序
     * @param params
     */
    private static void sort(int[] params) {
        // 任何数组都是由0-9组成
        // 定义10个桶，没个桶可存放params.length个数
        int[][] buckets = new int[10][params.length];
        // 定义每个桶中数据个数的变化
        int[] bucketIndex = new int[10];
        // 得到数组中最大的值，以这个值的长度为循环次数
        OptionalInt maxNum = Arrays.stream(params).max();
        int maxLength = maxNum.toString().length();
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 按照各位数进行排序
            for (int p = 0; p < params.length; p++) {
                // 取出数组中每个元素的个位数
                int num = params[p] /n % 10;
                // 把num放入到对应的桶中
                buckets[num][bucketIndex[num]] = params[p];
                // 计数器bucketIndex[num]需要加1
                bucketIndex[num]++;
            }
            // 循环桶数据，把每个桶的数据按照次序依次放入到原数组中
            int metaIndex = 0;
            // 先循环每个桶中存放多少个数据的数组
            for (int count = 0; count < bucketIndex.length; count++) {
                // 如果每个桶的计数器不为0，开始覆盖原数组
                if (bucketIndex[count] != 0) {
                    for (int b = 0; b < bucketIndex[count]; b++) {
                        params[metaIndex] = buckets[count][b];
                        metaIndex++;
                    }
                    // 计数器清0
                    bucketIndex[count] = 0;
                }
            }
        }
    }
}
