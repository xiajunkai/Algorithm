import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        SortHelper helper = new SortHelper();
        int[] arr = {3,8,10,41,2,15,4,77,10,9,87,41};
        int[] temp = new int[arr.length];


        //helper.MergeSort(arr,0,arr.length-1, temp);
        helper.quickSort(arr,0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(helper.bubbleSort(arr)));
    }
}
