public class TreeNode {
    private int no;
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int no, int val) {
        this.no = no;
        this.val = val;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
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

    @Override
    public String toString() {
        return "no = " + no + "\tval = " + val;
    }
}
