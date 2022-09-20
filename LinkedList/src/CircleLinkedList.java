public class CircleLinkedList {
    //此处专为求解约瑟夫问题而建立的环形链表
    private SingleListNode first = new SingleListNode(-1);

    // 添加子节点，构建环形链表
    public void addNode (int nums) {
        if (nums < 1) {
            System.out.println("长度不够，无法构建环形链表");
        }
        // 创建辅助遍历指针,方便构建环形链表
        SingleListNode currentNode = null;
        // 使用for循环创建环形链表
        for (int i = 1; i <= nums; i ++) {
            //依据编号创建节点
            SingleListNode newNode = new SingleListNode(i);
            // 如果是第一个节点
            if (i == 1) {
                first = newNode;
                // 成环
                first.setNext(first);
                currentNode = first; // 让currentNode指向第一个节点，first节点不动
            } else {
                currentNode.setNext(newNode);
                newNode.setNext(first);
                currentNode = newNode; // 将当前节点指针指到下一个节点
            }
        }
    }

    // 遍历环形链表
    public void showList () {
        SingleListNode currentNode = first;
        if (currentNode.getNo() == -1) {
            System.out.println("当前环形链表为空！");
        }
        // 循环到第一个节点就结束
        do {
            System.out.println("节点编号：" + currentNode.getNo());
            currentNode = currentNode.getNext();
        } while (currentNode != first);
    }

    /**
     * @param startNo 表示从第几个节点开始数数
     * @param countNum 表示数几下
     * @param num 表示最初有几个节点
     */
    // 求解约瑟芬问题
    public void solveJoseph(int startNo, int countNum, int num) {
        //输入合法性检验
        if (first.getNo() == -1 || startNo < 1 || startNo > num) {
            System.out.println("输入非法！");
        }

        // 创建辅助指针，帮助节点出圈
        SingleListNode helper = first;

        // 先让辅助指针指向环形链表的最后一个节点
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }

        // 开始报数之前，先让first和helper移动startNo-1次
        for (int j = 0; j < startNo - 1; j ++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        // 当开始报数时让first和helper 指针同时的移动 countNum - 1 次, 然后出圈
        // 让first和helper 指针同时的移动 countNum - 1 次, 然后出圈
        while (true) {
            if (helper == first) { // 当前圈中只有一个人
                System.out.println("最后出圈：" + first.getNo());
                break;
            }
            for (int i = 0; i < countNum; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // first所指向的节点，出圈
            System.out.println("出圈编号：" + first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
    }
}