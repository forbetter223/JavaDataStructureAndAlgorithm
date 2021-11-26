package com.forbetter223.Sort;


/**
 * 选择排序
 * 先选定一个规则，比如从小到大排序
 * 如果有值比第一个值小的，就和第一个值换位置，
 * 一轮循环下来，第一个值已经排好序；
 * 然后从第二个值开始循环，以此类推，直到把数组都循环完毕。
 * 时间复杂度：O(n^2)
 * 稳定排序
 */
public class Select {


    public static void main(String[] args) {

        sort(new int[]{1, 9, 3, 6, 8});
        //[1, 9, 3, 6, 8]
        //[1, 3, 9, 6, 8]
        //[1, 3, 6, 9, 8]
        //[1, 3, 6, 8, 9]
        //[1, 3, 6, 8, 9]
        System.out.println("-----------------");
        sortByMarkIndex(new int[]{1, 3, 3, 6, 2});
        //[1, 3, 3, 6, 2]
        //[1, 2, 3, 6, 3]
        //[1, 2, 3, 6, 3]
        //[1, 2, 3, 3, 6]
        //[1, 2, 3, 3, 6]
        System.out.println("-------performance----------");
        int[] testArr = new int[80000];
        for(int i = 0; i < testArr.length;i++){
            testArr[i] = (int)(Math.random() * 100000);
        }
        long begin = System.currentTimeMillis();
        sort(testArr);
        long end = System.currentTimeMillis();
        System.out.printf("sort排序执行了 %d Millis秒", end - begin);
        System.out.println("-----------------");
        int[] testArr2 = new int[80000];
        for(int i = 0; i < testArr2.length;i++){
            testArr2[i] = (int)(Math.random() * 100000);
        }
        begin = System.currentTimeMillis();
        sortByMarkIndex(testArr2);
        end = System.currentTimeMillis();
        System.out.printf("sortByMarkIndex排序执行了 %d Millis秒", end - begin);

        // 结论:sortByMarkIndex执行效率高与sort
    }

    /**
     * 从小到大排序
     *
     * @param params
     */
    private static void sort(int[] params) {
        // 定义一个临时变量存放交换的值
        int tmp;
        // 先假设i元素是最小值，用它和i以外的值比较，如果有比i值小的就替换位置
        for (int i = 0; i < params.length; i++) {
            // 前i项都已经排好序，从i以后的值开始比较
            for (int j = i + 1; j < params.length; j++) {
                // 如果有比i值da的值就和i替换位置
                if (params[i] > params[j]) {
                    tmp = params[i];
                    params[i] = params[j];
                    params[j] = tmp;
                }
            }
//            System.out.println(Arrays.toString(params));
        }
    }

    /**
     * 从小到大排序
     * 选择排序的另一种排序方法：
     * 从数组的第一个元素开始，如果第二个元素比第一个元素小
     * 不交换它们的位置，但是要记录第二个元素的值和index。接着循环。
     * 如果后面又有元素比记录的第二个值小的元素，记录后面元素的值和index,
     * 以此类推，直到循环结束
     *
     * @param params
     */
    private static void sortByMarkIndex(int[] params) {
        if (params == null || params.length == 0) {
            System.out.println("参数不能为空。");
            return;
        }

        for (int i = 0; i < params.length; i++) {
            // 数组的第一个元素
            int markValue = params[i];
            // 数组的首坐标
            int markIndex = i;
            // 记录是否替换过
            boolean changeFlg = false;
            for (int j = i + 1; j < params.length; j++) {
                // 如果后续元素比当前元素小，记录小的元素的值和index
                if (params[j] < markValue) {
                    markIndex = j;
                    markValue = params[j];
                    changeFlg = true;
                }
            }
            // 如果元素替换过，需要交换它们的值
            if (changeFlg) {
                params[markIndex] = params[i];
                params[i] = markValue;
            }
//            System.out.println(Arrays.toString(params));
        }
    }
}
