package com.forbetter223.BinaryTree;

public class TreeNode {
    private int no;
    private String name;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int pNo, String pName) {
        this.no = pNo;
        this.name = pName;
    }

    /**
     * 前序遍历
     */
    public void previous() {
        System.out.println(this);
        if (this.left != null) {
            this.left.previous();
        }
        if (this.right != null) {
            this.right.previous();
        }
    }

    /**
     * 前序查找方法
     *
     * @param no 查找节点的序号
     * @return 返回找到的节点
     */
    public TreeNode previousFind(int no) {
        System.out.println("进入前序查找方法");
        if (this != null && this.no == no) {
            return this;
        }
        TreeNode temp = null;
        if (this.left != null) {
            temp = this.left.previousFind(no);
        }
        if (temp != null) {
            return temp;
        }
        if (this.right != null) {
            temp = this.right.previousFind(no);
        }
        return temp;
    }

    /**
     * 中序遍历
     */
    public void infix() {
        if (this.left != null) {
            this.left.infix();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infix();
        }
    }

    /**
     * 中序查找方法
     *
     * @param no
     * @return
     */
    public TreeNode infixFind(int no) {

        TreeNode temp = null;
        if (this.left != null) {
            temp = this.left.infixFind(no);
        }
        if (temp != null) {
            return temp;
        }
        System.out.println("进入中序查找方法");
        if (this != null && this.no == no) {
            return this;
        }
        if (this.right != null) {
            temp = this.right.infixFind(no);
        }
        return temp;
    }

    /**
     * 后续遍历
     */
    public void post() {
        if (this.left != null) {
            this.left.post();
        }
        if (this.right != null) {
            this.right.post();
        }
        System.out.println(this);
    }

    /**
     * 后序查找方法
     *
     * @param no
     * @return
     */
    public TreeNode postFind(int no) {

        TreeNode temp = null;
        if (this.right != null) {
            temp = this.right.postFind(no);
        }
        if (temp != null) {
            return temp;
        }
        if (this.left != null) {
            temp = this.left.postFind(no);
        }
        if (temp != null) {
            return temp;
        }
        System.out.println("进入后序查找方法");
        if (this != null && this.no == no) {
            return this;
        }
        return null;

    }

    /**
     * 快速二叉树查找
     * 前提：左子树的数据比父节点小，右子树的数据比父节点大
     *
     * @param no
     * @return
     */
    public TreeNode quickFind(int no) {
        if (this == null) {
            return null;
        }
        System.out.println("进入快速二叉树排序");
        if (this.no == no) {
            return this;
        } else if (this.no < no) {
            return this.right.quickFind(no);
        } else {
            return this.left.quickFind(no);
        }
    }

    /**
     * 删除节点
     * 1，如果删除的节点是子节点就删除这个子节点
     * 2.如果删除的节点是父节点，就删除这个节点的树
     *
     * @param no 删除节点的序号
     */
    public boolean delete(int no) {
        // 定义一个临时变量来判断是否找到了删除的节点
        boolean deletedFlg = false;
        // 这里判断不了root节点
        // 单向树 当前节点只有子节点没有这个节点的父节点
        // 判断一个节点是不是可以删除，要从这个节点的父节点判断
        if (this.left != null && this.left.no == no) {
            this.left = null;
            deletedFlg = true;
        } else if (this.right != null && this.right.no == no) {
            this.right = null;
            deletedFlg = true;
        } else {
            // 没有找到删除的节点是，需要向左子树删除或者右子树删除
            if (this.left != null) {
                deletedFlg = this.left.delete(no);
            }
            if (!deletedFlg) {
                // 如果左子树没有找到要删除的节点，就向右节点删除
                if (this.right != null) {
                    deletedFlg = this.right.delete(no);
                }
            }
        }
        return deletedFlg;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


}
