public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,1);
        TreeNode node1 = new TreeNode(2,2);
        TreeNode node2 = new TreeNode(3,3);
        TreeNode node3 = new TreeNode(4,4);
        TreeNode node4 = new TreeNode(5,5);

        // 先如此创建二叉树
        root.setLeft(node1);
        root.setRight(node2);
        node2.setRight(node3);
        node2.setLeft(node4);

        BinaryTree tree = new BinaryTree();
        tree.delete(root,6);
        tree.preOrderTraverse(root);

    }
}
