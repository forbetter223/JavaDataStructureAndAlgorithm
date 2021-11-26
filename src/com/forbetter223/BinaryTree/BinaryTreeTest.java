package com.forbetter223.BinaryTree;

public class BinaryTreeTest {
    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        TreeNode node1 = new TreeNode(1,"name1");
        TreeNode node2 = new TreeNode(2,"name2");
        TreeNode node3 = new TreeNode(3,"name3");
        TreeNode node4 = new TreeNode(4,"name4");
        TreeNode node5 = new TreeNode(5,"name5");
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);
        binaryTree.setRoot(node1);
        System.out.println("前序遍历");
        binaryTree.previous();
        System.out.println("中序遍历");
        binaryTree.infix();
        System.out.println("后序遍历");
        binaryTree.post();

        System.out.println("查找------------");
        System.out.println("前序查找");
        System.out.println(binaryTree.previousFind(4));
        System.out.println("中序查找");
        System.out.println(binaryTree.infixFind(4));
        System.out.println("后序查找");
        System.out.println(binaryTree.postFind(50));
        System.out.println("快速查找----");
        BinaryTree binaryTree2 = new BinaryTree();
        TreeNode node10 = new TreeNode(10,"name10");
        TreeNode node8 = new TreeNode(8,"name8");
        TreeNode node7 = new TreeNode(7,"name7");
        TreeNode node9 = new TreeNode(9,"name9");
        TreeNode node22 = new TreeNode(22,"name22");
        node8.setLeft(node7);
        node8.setRight(node9);
        node10.setLeft(node8);
        node10.setRight(node22);
        binaryTree2.setRoot(node10);
        System.out.println(binaryTree2.quickFind(7));

        System.out.println("删除节点-----------");
        System.out.println(binaryTree.delete(2));
        binaryTree.previous();
        System.out.println(binaryTree.delete(3));
        binaryTree.previous();
        System.out.println(binaryTree.delete(1));
        binaryTree.previous();
    }
}
