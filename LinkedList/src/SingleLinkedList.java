import java.util.Stack;

/**
 * 本类中实现了链表的基本操作
 */
public class SingleLinkedList {
    //先定义一个头节点
    private final SingleListNode head= new SingleListNode();

    //显示链表
    public void showList () {
        if (head.next == null) {
            System.out.println("链表为空！");
        }
        SingleListNode cursor = head.next;
        while (cursor != null) {
            System.out.println(cursor);
            cursor = cursor.next;
        }
    }

    // 逆序显示链表
    public void reverseShowList () {
        if (head.next == null) {
            System.out.println("链表为空！");
        }
        SingleListNode cursor = head.next;
        // 创建一个栈，用于逆序输出
        Stack<SingleListNode> stack = new Stack<>();
        while (cursor != null) {
            stack.push(cursor);
            cursor = cursor.next;
        }

        // 输出
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    // 计算链表长度
    public int listLength () {
        if (head.next == null) {
            return 0;
        }
        SingleListNode cursor = head.next;
        int count = 0;
        while (cursor != null) {
            count ++;
            cursor = cursor.next;
        }
        return count;
    }

    // 添加节点 (尾部加入)
    public void addNode (SingleListNode node) {
        SingleListNode cursor = head;
        // 遍历该表到最后
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        cursor.next = node;
    }

    // 有序插入节点
    public void insertNode(SingleListNode node) {

        SingleListNode cursor = head.next;
        boolean flag = false;

        while (true) {
            if (cursor.next == null) {
                break;
            }
            if (cursor.next.no > node.no) { //位置找到了，在此处添加
                break;
            } else if (node.no == cursor.next.no) { //已经存在相同节点，不插入
                flag = true;
                break;
            }
            cursor = cursor.next; //未寻找到插入点，继续遍历
        }
        if (flag) {
            System.out.println("编号已存在 " + node.no);
        } else {
            // 把待插入节点listNode的头尾都接上
            node.next = cursor.next;
            cursor.next = node;
        }
    }

    // 删除节点
    public void deleteNode (int no) {
        if (head.next == null) {
            System.out.println("链表为空！");
        }

        SingleListNode cursor = head;
        boolean flag = false;

        while (true) {
            if (cursor.next == null) {
                break;  //遍历已完成
            }
            if (cursor.next.no == no) {
                flag = true;
                break;  // 寻找成功
            }
            cursor = cursor.next;
        }

        if (flag) {
            cursor.next = cursor.next.next;
        } else {
            System.out.println("未找到该节点，无法删除！");
        }
    }

    // 查找节点
    public SingleListNode findNode (int no){
        if (head.next == null) {
            System.out.println("链表为空！");
        }
        SingleListNode cursor = head;
        for (int i = 0; i < no; i++) {
            cursor = cursor.next;
        }
        return cursor;
    }

    // 修改节点
    public void updateNode (SingleListNode node) {
        if (head.next == null) {
            System.out.println("链表为空！");
        }

        SingleListNode cursor = head;
        boolean flag = false;
        do {
            if (cursor == null) {
                break; // 遍历完成
            }
            if (cursor.no == node.no) {
                flag = true; // 找到该编号
                break;
            }
            cursor = cursor.next;
        } while (true);

        if (flag) {
            cursor.val = node.val;
        } else {
            System.out.println("未找到修改节点编号 " + node.no);
        }
    }

    // 反转链表
    // 头插法(类似栈处理方式)
    public SingleListNode reverseList () {
        if (head.next == null || head.next.next == null) {
            System.out.println("链表长度不够，无法反转！");
        }
        // 操作当前链表的指针
        SingleListNode cursor = head.next;
        // 建立新链表存储反转的链表
        SingleListNode result = new SingleListNode();
        SingleListNode next = null; //表示当前节点的下一个节点(交换时暂时存放)
        while (cursor != null) {
            next = cursor.next;  // 先暂时保存当前节点的下一个节点
            // 左侧是原链表当前节点存储地址部分，右侧是指向下一个节点地址的部分
            cursor.next = result.next;  // 将cursor下一个节点指向输出链表的头部
            result.next = cursor;
            cursor = next;
        }
        head.next = result.next;
        return result;
    }

    // 合并两个有序链表(可不使用递归求法)
    public SingleListNode mergeList (SingleListNode head1, SingleListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }

        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        SingleListNode cursor = null;
        if (head1.val <= head2.val) {
            cursor = head1;
        } else {
            cursor = head2;
        }
        cursor.next = mergeList(head1.next, head2);
        return cursor;
    }
}