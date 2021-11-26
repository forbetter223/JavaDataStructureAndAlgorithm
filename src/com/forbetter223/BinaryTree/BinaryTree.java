package com.forbetter223.BinaryTree;

public class BinaryTree {
    // 二叉树的根节点
    private TreeNode root;
    public void setRoot(TreeNode pRoot){
        this.root = pRoot;
    }

    public void previous(){
        if(this.root != null){
            this.root.previous();
        }else{
            System.out.println("二叉树为空");
        }
    }

    public TreeNode previousFind(int no){
        if(this.root != null){
            return this.root.previousFind(no);
        }else{
            return null;
        }
    }

    public void infix(){
        if(this.root != null){
            this.root.infix();
        }else{
            System.out.println("二叉树为空");
        }
    }

    public TreeNode infixFind(int no){
        if(this.root != null){
            return this.root.infixFind(no);
        }else{
            return null;
        }
    }

    public void post(){
        if(this.root != null){
            this.root.post();
        }else{
            System.out.println("二叉树为空");
        }
    }

    public TreeNode postFind(int no){
        if(this.root != null){
            return this.root.postFind(no);
        }else{
            return null;
        }
    }

    public TreeNode quickFind(int no){
        if(this.root != null){
            return this.root.quickFind(no);
        }else{
            return null;
        }
    }

    /**
     * 删除节点
     * 主要调用TreeNode的删除方法
     * @return
     */
    public boolean delete(int no){
        boolean deleteFlg = false;
        if (root != null) {
            if(root.getNo() == no){
                root = null;
                deleteFlg = true;
            }else{
                deleteFlg = root.delete(no);
            }
        }else{
            System.out.println("树为空，没右数据");
        }
        return deleteFlg;
    }

}
