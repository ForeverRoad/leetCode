package problem.need;

/**
 * @Description TODO
 * @Author zcf
 * @Date 2020-06-18 15:46
 **/
public class QuickSort {


    public static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    public static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }


    public static int getIndex(int[] arr,int l,int h){
        int key = arr[l];
        int i=l,j=h;
        if (l<h){
            while (i<j){
                while (i<j&&arr[j]>=key){
                    j--;
                }
                if (i<j){
                    swap(arr,i,j);
                    i++;
                }

                while (i<j&&arr[i]<key){
                    i++;
                }
                if (i<j){
                    swap(arr,i,j);
                    j--;
                }

            }
        }
        arr[i]=key;
        return i;
    }
    public static int[] quick(int[] arr,int left,int right){
        if (left<right){
            int index = getIndex(arr,left,right);
            quick(arr,left,index-1);
            quick(arr,index+1,right);
        }

        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {1,234534,45,457,5647,345,2,245};
//        int[] result = quickSort(arr, 0, arr.length-1);
        int[] result = quick(arr, 0, arr.length-1);
        for (int i : result) {
            System.out.println(i);
        }
    }

}
