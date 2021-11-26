package com.forbetter223.BinaryTree;

public class BinaryTreeStorage {
    private int[] storageArray;

    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6};
        BinaryTreeStorage binaryTreeStorage = new BinaryTreeStorage(array);
        System.out.println("前序遍历");
        binaryTreeStorage.previous(0);
        System.out.println("");
        System.out.println("中序遍历");
        binaryTreeStorage.infix(0);
        System.out.println("");
        System.out.println("后序遍历");
        binaryTreeStorage.post(0);
    }
    public BinaryTreeStorage(int[] params){
        this.storageArray = params;
    }

    /**
     * 完全二叉树 前序遍历
     * 完全二叉树，
     * 父节点的坐标为n时，左子节点的坐标为2*n+1,右子节点坐标为2*n+2
     * @param index
     */
    private void previous(int index){
        if(this.storageArray == null || this.storageArray.length ==0){
            System.out.printf("目标数组为空,不能解析成数结构.");
            return;
        }
        // 父节点
        System.out.printf("%d ",this.storageArray[index]);
        // 左子树
        if(2 * index + 1 < this.storageArray.length){
            previous(2*index + 1);
        }
        // 右子树
        if(2 * index + 2 < this.storageArray.length){
            previous(2*index + 2);
        }
    }

    /**
     * 完全二叉树 中序遍历
     * @param index
     */
    private void infix(int index){
        if(this.storageArray == null || this.storageArray.length ==0){
            System.out.printf("目标数组为空,不能解析成数结构.");
            return;
        }

        // 左子树
        if(2 * index + 1 < this.storageArray.length){
            infix(2*index + 1);
        }
        // 父节点
        System.out.printf("%d ",this.storageArray[index]);
        // 右子树
        if(2 * index + 2 < this.storageArray.length){
            infix(2*index + 2);
        }
    }

    /**
     * 完全二叉树 后序遍历
     * @param index
     */
    private void post(int index){
        if(this.storageArray == null || this.storageArray.length ==0){
            System.out.printf("目标数组为空,不能解析成数结构.");
            return;
        }

        // 左子树
        if(2 * index + 1 < this.storageArray.length){
            post(2*index + 1);
        }
        // 右子树
        if(2 * index + 2 < this.storageArray.length){
            post(2*index + 2);
        }
        // 父节点
        System.out.printf("%d ",this.storageArray[index]);
    }
}
