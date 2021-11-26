package com.forbetter223.Find;


/**
 * 插值查找
 * 注意事项：
 * 1.元素分布均匀的时候用效果好
 * 2.数据量大使用效果好
 */
public class Insert {


    public static void main(String[] args) {
//        Integer[] array = Stream.iterate(1, item -> item + 1).limit(100).collect(Collectors.toList()).toArray(new Integer[100]);
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        find(array,0,array.length - 1, 30);

    }

    /**
     * 插入排序算法
     * @param params 有序数组 1--100
     * @param pLeft 左面坐标
     * @param pRight 有坐标
     * @param findValue 需要查找的值
     */
    private static void find(int[] params, int pLeft, int pRight, int findValue){
        // 当left > right的时候结束递归
        if(pLeft > pRight || findValue < params[0] || findValue > params[params.length - 1]){
            return;
        }
        // 把数组分成左右两个数组
        // 取得临近值的下坐标
        // middle = (left + right) / 2 => left + 1/2 * (right - left)
        // 替换系数 1/2
        // 目标值于最小值的差 比上 数组最大值和最小的差
        // 目标值越大，系数越大，否则，系数越小
        int middle = pLeft + (pRight - pLeft) * (findValue - params[pLeft]) / (params[pRight] - params[pLeft]);
        // 临近数值
        int middleValue = params[middle];
        // 如果要查找的值比中间数值小，则在左侧有序数组寻找
        if (findValue < middleValue) {
            find(params,pLeft,middle - 1,findValue);
        }else if (findValue > middleValue){
            // 如果要查找的值比中间数值大，则在右侧有序数组寻找
            find(params,middle + 1,pRight,findValue);
        }else if (findValue == middleValue){
            System.out.println("找到值:" + middle);
        }
    }
}
