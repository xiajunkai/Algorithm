public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,"1");
        TreeNode node1 = new TreeNode(3,"1");
        TreeNode node2 = new TreeNode(6,"2");
        TreeNode node3 = new TreeNode(8,"3");
        TreeNode node4 = new TreeNode(10,"4");
        TreeNode node5 = new TreeNode(14,"5");

        // 先如此创建二叉树
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);

        ThreadBinaryTree tree = new ThreadBinaryTree(root);
        tree.threaded();
        tree.threadedList();

        //System.out.println(tree.postOrderSearch(4));
    }
}