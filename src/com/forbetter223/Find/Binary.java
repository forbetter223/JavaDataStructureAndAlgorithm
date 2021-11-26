package com.forbetter223.Find;

/**
 * 二分查找
 */
public class Binary {
    public static void main(String[] args){
//        int[] array = new int[]{-11,0,5,88,88,107,112};
        int[] array = new int[]{-11,-11,-11,-11,-11,107,112};
        find(array,0, array.length - 1, -11);
    }

    /**
     * 二分查找
     * @param params 从小到大的有序数组
     * @param pLeft 左侧有序数组的下坐标
     * @param pRight 右侧有序数组的下坐标
     * @param findValue 要查找的值
     */
    private static void find(int[] params, int pLeft, int pRight, int findValue){
        // 当left > right的时候结束递归
        if(pLeft > pRight){
            return;
        }
        // 把数组分成左右两个数组
        // 取得中间的下坐标
        int middle = (pLeft + pRight) / 2;
        // 中间数值
        int middleValue = params[middle];
//        // 如果要查找的值比中间数值小，则在左侧有序数组寻找
//        if (findValue < middleValue) {
//            find(params,pLeft,middle - 1,findValue);
//        }else if (findValue > middleValue){
//            // 如果要查找的值比中间数值大，则在右侧有序数组寻找
//            find(params,middle + 1,pRight,findValue);
//        }else
            if (findValue == middleValue){
            // 如果要查找的值比中间数值相等，则说明已经找到需要查找的值
            System.out.printf("找到值，Index=%d \n",middle);
            // 在数组中有两个相等的值就需要再向左/右扫描
            find(params,middle + 1,pRight,findValue);
            find(params,pLeft,middle - 1,findValue);
        }
    }
}
