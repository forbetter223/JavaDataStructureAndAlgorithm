package com.forbetter223.SparseArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 稀疏数组，在一个二维数组中，为了节省存储资源，我们会把二维数组中的有效数据保存成稀疏数组。
 * 比如无向图的byte数据。
 */
public class SparseArraySimple {

    public static void main(String[] args){
        // 创建一个10 X 10的测试数组
        int[][] simpleData = createSimpleData();
        // 打印测试数据
        printArray(simpleData);
        // 循环simpleData创建一个稀疏数组
        int[][] sparseArray = createSparseArray(simpleData);
        // 打印稀疏数组
        printArray(sparseArray);
        // 稀疏数组还原成原数组
        int[][] revertArray = new int[sparseArray[0][0]][sparseArray[0][0]];
        if(sparseArray.length != 0){
            for (int i = 0; i < sparseArray[0][0]; i++){
                for(int j = 0; j < sparseArray[0][1]; j++){
                    revertArray[i][j] = 0;
                    // 用稀疏数组没行的第一列和第二列分别和还原数组的i，j对比
                    // 如果相同就在i,j位置赋值
                    for(int z = 1; z < sparseArray.length; z++){
                        if(i == sparseArray[z][0] && j == sparseArray[z][1]){
                            revertArray[i][j] = sparseArray[z][2];
                            break;
                        }
                    }
                }
            }
        }
        // 打印还原数组
        printArray(revertArray);
    }

    /**
     * 创建一个测试用的五子棋数据
     * 10 X 10的棋盘
     * 0代表空位
     * 1代表白子
     * 2代表黑子
     * --------------------
     * 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0
     * 0 1 1 0 0 0 0 0 0 0
     * 0 0 2 2 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0
     * --------------------
     * @return
     */
    public static int[][] createSimpleData(){
        int[][] returnSimple = new int[10][10];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(i == 2 && (j == 1 || j == 2)){
                    returnSimple[i][j] = 1;
                }else if (i == 3 && (j == 2 || j ==3)) {
                    returnSimple[i][j] =2;
                }else {
                    returnSimple[i][j] = 0;
                }
            }
        }
        return returnSimple;
    }

    /**
     * 把原数组转化成稀疏数组
     * 只存不是0的数据，在数组大小上节约空间
     * 稀疏数组的大小是 N X 3
     * 第一行存放原数组的行，列，和一共有几个非0数据
     * 第二行存放第一个非0数据的行，列坐标和它的值
     * 第三行以此类推
     * ...
     * @param metaArrayData 未转换的原数组
     * @return 稀疏数组
     */
    public static int[][] createSparseArray(int[][] metaArrayData){
        List<int[]> resultList = new ArrayList<int[]>();
        // 第一行保存原数组的行，列，及非0数据的个数
        // 目前还不知道一共有几个非0数据，暂时保存为0
        int[] returnColumn = new int[3];
        returnColumn = new int[]{10, 10, 0};
        resultList.add(returnColumn);
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(metaArrayData[i][j] != 0){
                    returnColumn = new int[]{i,j,metaArrayData[i][j]};
                    resultList.add(returnColumn);
                }
            }
        }
        // 当原数组循环结束我们就知道原数据一个有几个非0数据，并且他们保存到了resultList里
        // 我们把resultList.size -1 就是一个有几个非0数据
        // 为什么要resultList.size - 1?因为resultList第一行数据存的是原数组的行列数和非0数据的个数
        resultList.get(0)[2] = resultList.size() - 1;
        return resultList.toArray(new int[0][]);
    }

    /**
     * 打印二维数组
     * @param dataArray 被打印的二维数组
     */
    public static void printArray(int[][] dataArray){
        // 打印稀疏数组
        System.out.println("----------------------");
        for(int i = 0,j = 0; i < dataArray.length;){
            System.out.print(dataArray[i][j]);
            j++;
            if(j >= dataArray[i].length){
                System.out.println();
                j = 0;
                i++;
            }
        }
    }
}

