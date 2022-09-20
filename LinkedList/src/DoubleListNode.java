public class DoubleListNode {
    int no;
    int val;

    public DoubleListNode pre;
    public DoubleListNode next;

    // 可允许多种构造方法(重载)
    public DoubleListNode(){}
    public DoubleListNode(int no, int val) {
        this.no = no;
        this.val = val;
    }

    @Override
    public String toString() {
        return "no = " + no + "\tval = " + val;
    }
}
