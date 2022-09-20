import java.util.Stack;

/**
 *  双向链表实现
 */
public class DoubleLinkedList {
    private final DoubleListNode head = new DoubleListNode();

    // 显示链表
    public void showList () {
        if (head.next == null) {
            System.out.println("链表为空！");
        }
        DoubleListNode cursor = head.next;
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
        DoubleListNode cursor = head.next;
        // 创建一个栈，用于逆序输出
        Stack<DoubleListNode> stack = new Stack<>();
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
        DoubleListNode cursor = head.next;
        int count = 0;
        while (cursor != null) {
            count ++;
            cursor = cursor.next;
        }
        return count;
    }

    // 添加节点(尾部加入)
    public void addNode (DoubleListNode node) {
        DoubleListNode cursor = head;
        while (cursor.next != null) {
            cursor = cursor.next;
        }

        cursor.next = node;
        node.pre = cursor;
    }

    // 有序插入节点 (需要处理两个指针指向关系)
    public void insertNode (DoubleListNode node) {
        if (head.next == null) {
            node.pre = head;
            head.next = node;
        }

        DoubleListNode cursor = head.next;
        boolean flag = false;

        while (true) {
            if (cursor.next == null) {
                break;
            }
            if (cursor.no > node.no) {  // 思考一下为什么跟单链表表示不一样
                break;
            } else if (cursor.no == node.no) {
                flag = true;
                break;
            }
            cursor = cursor.next;
        }
        if (flag) {
            System.out.println("编号已存在！");
        } else {
            node.next = cursor;
            node.pre = cursor.pre;

            cursor.pre.next = node;
            cursor.pre = node;
        }
    }

    // 删除节点
    public void deleteNode (int no) {
        if (head.next == null) {
            System.out.println("链表为空！");
        }

        DoubleListNode cursor = head.next;
        boolean flag = false;

        while (true) {
            if (cursor.next == null) {
                break;
            }
            if (cursor.no == no) {
                flag = true;
                break;
            }
            cursor = cursor.next;
        }

        if (flag) {
            cursor.pre.next = cursor.next;
            cursor.next.pre = cursor.pre;
        } else {
            System.out.println("未找到该节点，无法删除！");
        }
    }

    // 查找节点
    public DoubleListNode findNode (int no) {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        DoubleListNode cursor = head;
        for (int i = 0; i < no; i++) {
            cursor = cursor.next;
        }
        return cursor;
    }

    // 修改节点
    public void updateNode (DoubleListNode node) {
        if (head.next == null) {
            System.out.println("链表为空！");
        }

        DoubleListNode cursor = head.next;
        boolean flag = false;
        while (true) {
            if (cursor == null) {
                break;
            }
            if (cursor.no == node.no) {
                flag = true;
                break;
            }
            cursor = cursor.next;
        }
        if (flag) {
            cursor.val = node.val;
        } else {
            System.out.println("未找到修改节点编号 " + node.no);
        }
    }
}
