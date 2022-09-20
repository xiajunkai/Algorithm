public class BinaryTree {
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrderTraverse() {
        if (root != null) {
            root.preOderTraverse();
        } else {
            System.out.println("二叉树为空！无法前序遍历");
        }
    }

    // 中序遍历
    public void inOrderTraverse() {
        if (root != null) {
            root.inOrderTraverse();
        } else {
            System.out.println("二叉树为空！无法中序遍历");
        }
    }

    // 后序遍历
    public void postOrderTraverse() {
        if (root != null) {
            root.postOrderTraverse();
        } else {
            System.out.println("二叉树为空！无法后序遍历");
        }
    }

    // 前序查找
    public TreeNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    // 中序查找
    public TreeNode inOrderSearch(int no) {
        if (root != null) {
            return root.inOrderSearch(no);
        } else {
            return null;
        }
    }

    // 前序查找
    public TreeNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    // 删除节点
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("二叉树为空！");
        }
    }
}
