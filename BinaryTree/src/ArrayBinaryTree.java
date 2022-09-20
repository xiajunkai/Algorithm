public class ArrayBinaryTree {
    // 顺序化二叉树存储
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    /**
     * 顺序：根->左->右
     * @param index 数组下标索引
     */
    public void preOrderTraverse(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空！");
        }
        // 根节点
        System.out.println(arr[index]);
        // 向左递归遍历 第n个元素的左节点位置为 2n+1
        if (2 * index + 1 < arr.length) {
            preOrderTraverse(2 * index + 1);
        }
        // 向左递归遍历 第n个元素的左节点位置为 2n+2
        if (2 * index + 2 < arr.length) {
            preOrderTraverse(2 * index + 1);
        }
    }
}