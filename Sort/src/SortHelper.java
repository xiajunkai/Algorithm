/**
 *  排序帮助类，实现各种排序算法(以数组为基础实现)
 */
public class SortHelper {
    // 初始化一个工具类
    Tool tool = new Tool();

    // 冒泡排序
    public int[] bubbleSort(int[] arr) {
        // 第一个循环为趟数
        boolean flag = false; //标记变量，表示是否交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tool.swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {  //一次交换都没有发生，代表已经排序完成，无需再去进行第n-1趟
                break;
            } else {
                flag = false;
            }
        }
        return arr;
    }

    // 选择排序
    public int[] selectSort(int[] arr) {
        int temp;
        // 第一个循环为趟数
        for (int i = 0; i < arr.length - 1; i++) {
            // 先寻找最小值,令其为擂主
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = min;
                arr[minIndex] = temp;
            }
        }
        return arr;
    }

    // 插入排序
    public int[] insertSort(int[] arr) {
        int insertIndex = 0; // 待插入数据的前一个位置
        int insertValue;
        for (int i = 1; i < arr.length; i++) {
            insertIndex = i - 1; // 待插入数据的前一个位置
            insertValue = arr[i];
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// 待插入数的前一个数后移
                insertIndex--; // 待插入位置
            }
            // 判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValue; // 退出while 循环时 插入位置找到 insertIndex + 1 (因为insertIndex初始化的时候是待插入数的前一个数)
            }
        }
        return arr;
    }

    // 希尔排序(交换法)
    public int[] shellSort(int [] arr) {
        int group = arr.length / 2;
        while (group != 0) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i - group; j >= 0; j -= group) {
                    if (arr[j] > arr[j + 1]) {
                        tool.swap(arr, j, j + 1);
                    }
                }
            }
            group /= 2;
        }
        return arr;
    }

    // 优化希尔排序(移位法)
    public int[] shellSortOptimize(int[] arr) {
        int group = arr.length / 2;
        int insertIndex = 0;
        int insertValue = 0;
        while (group != 0) {
            for (int i = group; i < arr.length; i++) {
                insertIndex = i - group;
                insertValue = arr[i];
                while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                    arr[insertIndex + group] = arr[insertIndex];
                    insertIndex -= group;
                }
                arr[insertIndex + group] = insertValue;
            }
            group /= 2;
        }
        return arr;
    }

    /**
     * 归并排序
     * @param arr   待排序数组
     * @param left  左侧索引
     * @param right 右侧索引
     * @param temp  归并排序需要的临时交换数组 (与arr大小一致)
     */
    public void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; // 中间索引
            // 向左递归分解
            mergeSort(arr, left, mid, temp);
            // 向右递归分解
            mergeSort(arr, mid + 1, right, temp);

            // 上述递归是分解
            // 每分解一次，都需要重新合并一次
            tool.Merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 快速排序(递归法)
     * @param arr   待排序数组
     * @param left  左边的索引
     * @param right 右边的索引
     */
    public void quickSort(int[] arr, int left, int right) {

        int l = left;  // 左侧索引
        int r = right;  // 右侧索引
        int pivot = arr[(l + r) / 2];  // 待排序数字中间数字的值

        // 只要右边的索引大于左边的索引就继续循环  目的是让比pivot小的值放到左边，比pivot值大的放在右边
        while (l < r) {
            // 在pivot的左边一直找找到大于等于pivot的值 ,才退出
            while (arr[l] < pivot) {
                l++;
            }
            // 在pivot的右边一直找找到小于等于pivot的值 ,才退出
            while (arr[r] > pivot) {
                r--;
            }
            //  如果成立则说明pivot左边的值, 已经全部小于等于pivot的值, 右边的已经全部大于等于pivot的值
            if (l >= r) {
                break;
            }
            // 交换
            tool.swap(arr, l, r);
            // 进行判断，若交换完后发现arr[l] = pivot rightIndex向前移动 rightIndex--
            if (arr[l] == pivot) {
                r--;
                // 进行判断，若交换完后发现arr[rightIndex] = pivot rightIndex向前移动 l--
            } else if (arr[r] == pivot) {
                l++;

            }
        }

        // 如果 l == rightIndex 必须 l++ 和 rightIndex--, 否则会出现栈溢出
        if (l == r) {
            l++;
            r--;
        }

        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }

        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    // 堆排序
    public int[] heapSort(int[] arr) {
        // 构建最大堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            tool.adjustHeap(arr, i, arr.length);
        }

        //将堆项元素与末尾元素交换，将最大元素"沉"到数组末端;
        //重新调整结构，使其满足堆定义，然后继续交换堆项元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
        for (int j = arr.length - 1; j > 0; j--) {
            tool.swap(arr, j, 0);
            tool.adjustHeap(arr, 0, j);
        }
        return arr;
    }

    // 基数排序
    // 有负数不要使用基数排序(因为需要将数进行位数分解)
    public int[] radixSort(int[] arr) {
        //定义一个二维数组代表10个桶，每一个桶就是一个一维数组
        int[][] bucket = new int[10][arr.length];
        //为了记录每一个桶中实际存放了多少个数据，我们定义一个一维数组来记录各个桶每次放入的数据个数
        int[] bucketElementCounts = new int[10];//记录每个桶中数据的数量
        int max = tool.getMaxValue(arr);

        int maxLength = String.valueOf(max).length();  // 计算max位数

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int value : arr) {
                //取出每个元素的个/十/百位
                int digitOfElement = value / n % 10;
                //放入到对应的桶中
                //数组中的第一个数代表这0.1.2...
                //数组中第二个数代表每一个桶中有多少个数
                //bucketElementCounts[digitOfElement] 代表着每一个桶中，元素的索引
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = value;
                bucketElementCounts[digitOfElement]++;
            }
            //放入原数组
            int index = 0;
            //遍历每一个桶，并将桶中的数据放入到原数组
            for (int k = 0; k < bucket.length; k++) {
                //如果桶中有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //说明桶中有数据
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                bucketElementCounts[k] =0;//处理完一个桶之后需要将桶置为0
            }
        }
        return arr;
    }
}