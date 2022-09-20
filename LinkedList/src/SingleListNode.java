public class SingleListNode {
    int no;
    int val;
    public SingleListNode next;
    // 可允许多种构造方法(重载)
    public SingleListNode(){}

    public SingleListNode(int no) {
        this.no = no;
    }

    public SingleListNode(int no, int val) {
        this.no = no;
        this.val = val;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public SingleListNode getNext() {
        return next;
    }

    public void setNext(SingleListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "no = " + no + "\tval = " + val;
    }
}