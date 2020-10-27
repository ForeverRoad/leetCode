package problem.need;

/**
 * @Description 二分查找
 * @Author zcf
 * @Date 2020-06-18 15:28
 **/
public class BinarySearch {

    public static void main(String[] args) {
//        int[] arr = {1, 3, 5, 6, 8, 9, 12, 34, 5678, 789797};
//        System.out.println(search(arr, 6));

        int[] arr = {7,8,9,10,1,3,5};
        System.out.println(searchReverser(arr,99));
    }

    public static int search(int[] arr, int target) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }

    //部分旋转查找
    public static int searchReverser(int[] arr,int num){
        int left = 0;
        int right = arr.length-1;

        while (left<=right){
            int leftVal = arr[left];
            int rightVal = arr[right];
            int mid = (left+right)/2;
            if (arr[mid]==num){
                return mid;
            }
            //判断最左段的值大小
            if (arr[mid]>num){
                if (num<leftVal){
                    left = mid+1;
                }else{
                    right = mid-1;
                }

            }else{
                if (num>rightVal){
                    right = mid-1;
                }else{
                    left = mid+1;
                }

            }
        }

        return -1;
    }

    //部分翻转的有序数组，查找最小值
    public static int searchMin(int[] nums){

        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length-1;

        if (nums[right] > nums[0]) {
            return nums[0];
        }


        while (left<=right){

            int mid = (left+right)/2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid]>nums[0]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
}
