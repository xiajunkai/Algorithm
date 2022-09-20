import java.util.Arrays;

/**
 * 一些工具函数集合
 */
public class Tool {
    /**
     * 交换数组中两个数
     * @param arr 待代交换原数组
     * @param i 索引
     * @param j 索引
     */
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 求数组最大值
    public int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    /**
     * @param arr   原始的数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  中转数组
     */
    public void Merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left; // 左侧有序序列的初始索引
        int r = mid + 1;  // 右侧有序序列的初始索引
        int t = 0;  // 初始化temp数组的索引

        // 先把左右两侧(有序)的数据，按规则填充到temp中
        // 指导左右两侧有序数据中一方处理完毕
        while (l <= mid && r <= right) {
            // 若左侧有序序列中当前元素<=右侧有序序列中当前元素
            // 将左侧当前元素放置到对应temp数组中位置initTemp
            if (arr[l] <= arr[r]) {
                temp[t++] = arr[l++];
            } else {
                temp[t++] = arr[r++];
            }
        }

        // 将剩余的数组数据一次性加入temp尾部
        // 左侧有序序列还有剩余数据，将剩余有序数据依次放入temp数组中
        while (l <= mid) {
            temp[t++] = arr[l++];
        }
        // 右侧有序序列还有剩余数据，将剩余数据依次有序放入temp数组中
        while (r <= right) {
            temp[t++] = arr[r++];
        }

        // 将temp数组重新放入arr中(并不是每次都全部拷贝)
        t = 0;
        // 第一次合并 tempLeft=0 right=1
        // 第二次合并 tempLeft=2 right=3
        // 第三次合并 tempLeft=0 right=3
        // 最后一次合并 tempLeft=0 right=7
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }

    /**
     * 将一个数组（二叉树）调整成一个大根堆
     * 功能：完成将以i对应的非叶子结点的树调整成大顶堆
     * 举例int arr[]={4, 6,8,5,9};=>i=1=> adjustHeap=>得到{4,9,8,5, 6}
     * 如果我们再次调用adjustHeap 传入的是i=0=>得到{4,9, 8,5,6}=> {9,6,8,5, 4}
     * @param arr    待调整的数组
     * @param i      表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整，length 是在逐渐的减少
     */
    public void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i]; // 先取出当前元素的值，保存临时变量
        // 开始调整
        // 说明:k=i*2+1k是i结点的左子结点
        for (int k = i * 2; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > arr[i]) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
