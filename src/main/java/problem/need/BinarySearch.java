package problem.need;

/**
 * @Description 二分查找
 * @Author zcf
 * @Date 2020-06-18 15:28
 *
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,3,5,6,8,9,12,34,5678,789797};
        System.out.println(search(arr,6));
    }

    public static int search(int[] arr,int num){
        int min = 0;
        int max = arr.length;
        while (min<=max){
            int mid = (min+max)/2;
            if (arr[mid]==num){
                return mid;
            }else if (arr[mid]>num){
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        return -1;
    }
}
