public class TreeNode {
    private int no;
    private String val;
    private TreeNode left;
    private TreeNode right;

    //如果leftType == 0表示指向的是左子树，如果 leftType == 1则表示指向的是前驱结点
    private int leftType;
    //如果rightType == 0表示指向的是右子树，如果 rightType == 1则表示指向的是后继结点
    private int rightType;

    public TreeNode(int no, String val) {
        this.no = no;
        this.val = val;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
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

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public String toString() {
        return "no = " + no + "\tval = " + val;
    }

    /*
     * 基础二叉树操作
     */

    // 前序遍历
    // 根 > 左 > 右
    public void preOderTraverse() {
        System.out.println(this);
        if (left != null) {
            left.preOderTraverse();
        }
        if (right != null) {
            right.preOderTraverse();
        }
    }

    // 中序遍历
    // 左 > 根 > 右
    public void inOrderTraverse() {
        if (left != null) {
            left.inOrderTraverse();
        }
        System.out.println(this);
        if (right != null) {
            right.inOrderTraverse();
        }
    }

    // 后序遍历
    // 左 > 右 > 根
    public void postOrderTraverse() {
        if (left != null) {
            left.postOrderTraverse();
        }
        if (right != null) {
            right.postOrderTraverse();
        }
        System.out.println(this);
    }

    // 前序查找
    public TreeNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        TreeNode result = null;
        // 左子树遍历
        if (left != null) {
            result = left.preOrderSearch(no);
        }
        // 注意此处判断
        if (result != null) {
            return result;
        }
        //右子树遍历
        if (right != null) {
            result = right.preOrderSearch(no);
        }
        return result;
    }

    // 中序查找
    public TreeNode inOrderSearch(int no) {
        TreeNode result = null;
        if (left != null) {
            result = left.inOrderSearch(no);
        }
        if (result != null) {
            return result;
        }

        if (this.no == no) {
            return this;
        }

        if (this.right != null) {
            result = right.inOrderSearch(no);
        }
        return result;
    }

    // 后序查找
    public TreeNode postOrderSearch(int no) {
        TreeNode result = null;
        if (left != null) {
            result = left.postOrderSearch(no);
        }
        if (result != null) {
            return result;
        }

        if (right != null) {
            result = right.postOrderSearch(no);
        }
        if (result != null) {
            return result;
        }

        if (this.no == no) {
            return this;
        }
        return null;
    }

    // 递归删除节点
    // 1 如果删除的是叶子节点，则删除叶子节点
    // 2 如果删除的是非叶子节点，则删掉整个子树
    /*
    1 因为二叉树是单向的，所以我们是判断当前节点的子节点是否需要删除节点，而不能判断当前这个节点上是不是需要删除的节点
    2 如果当前节点的左子节点不为空，且左子节点就是要删除的节点，就将this.left == null;并且返回（结束递归）
    3 如果当前节点的右子节点不为空，且右子节点就是要删除的节点，就将this.right == null;并且返回（结束递归）
    4 如果第2步和第3步没有删除节点，那么我们就要向左子树进行递归删除
    5 如果第4步没有删除节点，那么就要向右子树进行递归删除
     */

    public void delNode(int no) {
        if (left != null && left.no == no) {
            left = null;
            return;
        }
        if (right != null && right.no == no) {
            right = null;
            return;
        }
        // 向左子树进行递归删除
        if (left != null) {
            left.delNode(no);
        }
        // 向右子树进行递归删除
        if (right != null) {
            right.delNode(no);
        }
    }
}