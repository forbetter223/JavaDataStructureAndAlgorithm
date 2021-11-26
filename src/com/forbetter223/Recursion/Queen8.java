package com.forbetter223.Recursion;

/**
 * 用递归解决8皇后问题
 * 在8x8的棋盘上放置8个皇后，
 * 每行放一个皇后
 * 要求：所有的皇后
 * 1.不能同行
 * 2.不能同列
 * 3.不能斜对线
 * 问：有几种摆置方法？
 */
public class Queen8 {

    // 定义一个数组，存放8皇后的正确放置位置
    // 数组的0~7代表每行，每个坐标的值代表皇后在该行的位置
    // 比如queen[2] = 4代表第三的皇后在第5个位置
    int[] queen = new int[8];

    public static void main(String[] args){
        Queen8 queen8 = new Queen8();
        queen8.check(0);
    }

    /**
     * 放置皇后
     * @param n 第n个皇后，也就是说第n行
     */
    private void check(int n){
        if(n == 8){
            // 所有8个皇后已经放置好
            print();
            return;
        }
        // 依次放置皇后，并判断每个皇后是否冲突
        // 皇后放置在第i列
        for(int i = 0; i < 8; i++){
            // 先把当前皇后n放到该行的第i列,
            // 从第n行的第i列开始
            queen[n] = i;
            // 判断放置第n行的皇后到第i列时，是否冲突
            if(!isConflicting(n)){
                // 如果不冲突，开始放置下一个皇后，直到放到第8个皇后为止
                // 如果所有列都冲突，然开始从上一行皇后开始递归回溯
                check(n + 1);
            }
            // 如果冲突，则从第i + 1列开始判断是否能放置。
        }
    }

    /**
     * 判断冲突。
     * 当我们放置第n个皇后时就去检测该皇后是否和前面已经摆放的皇后冲突
     * 1.不能同行
     * 2.不能同列
     * 3.不能斜对线
     *
     * @param n 第n个皇后
     * @return 冲突返回ture,
     * 否则返回false;
     */
    private boolean isConflicting(int n) {
        // 循环前n行数据，判断是否冲突
        for (int q = 0; q < n; q++) {
            if (queen[q] == queen[n]) {
                // 判断是否在同一列
                // 如果第q行和第n行的值一样时，代表第q行和第n行在同一列。
                return true;
            } else if (Math.abs(n - q) == Math.abs(queen[n] - queen[q])) {
                // 判断是否在斜对角线
                // 行-行 = 列-列 的时候表明第q行和第n行的在对角线
                return true;
            }
            // 不用判断是否在同一行，因为queen数组每个下坐标只能存放一个列值
            // 当它开始自增时就表明行在递增变化。每个皇后肯定不在同一行。
        }
        return false;
    }

    /**
     * 打印其中一种结果。
     */
    private void print() {
        for (int item : queen) {
            System.out.print(item);
        }
        System.out.println();
    }
}
