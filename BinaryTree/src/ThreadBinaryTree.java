public class ThreadBinaryTree {
    /**
     * 以后尝试下前序、后续线索化
     */
    private TreeNode root;
    //为了实现线索化，需要创建指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre总是保留前一个结点
    private TreeNode pre = null;

    public ThreadBinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    // 线索化操作
    public void threaded() {
        threadedNodes(root);
    }

    /**
     * 中序线索化二叉树
     * @param node 当前需要线索化节点
     */
    private void threadedNodes(TreeNode node) {
        // 非空判断，为空无法线索化当前节点
        if (node == null) {
            return;
        }

        // 线索化左子树
        if (node.getLeft() != null) {
            threadedNodes(node.getLeft());
        }

        // 线索化当前节点
        // 处理当前节点的前驱节点
        if (node.getLeft() == null) {
            // 让当前节点左指针指向前驱节点
            node.setLeft(pre);
            // 修改当前节点左指针类型，指向前驱节点
            node.setLeftType(1);
        }

        // 处理后继节点
        if (pre != null && pre.getRight() == null) {
            // 让当前节点右指针指向当前节点
            pre.setRight(node);
            // 修改当前节点类型
            pre.setRightType(1);
        }

        // 每处理一个节点，让当前节点成为下一节点的前驱节点
        pre = node;

        // 线索化右子树
        if (node.getRight() != null) {
            threadedNodes(node.getRight());
        }
    }

    public void threadedList() {
        // 存储当前遍历的节点
        TreeNode node = root;
        while (node != null) {
            // 找出LeftType == 1的节点
            // 之后继续遍历，因LeftType == 1时，说明该节点是照着线索化处理后的有效节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            // 若当前节点右指针指向后继节点，则继续输出
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            // 更新遍历节点
            node = node.getRight();
        }
    }

}
