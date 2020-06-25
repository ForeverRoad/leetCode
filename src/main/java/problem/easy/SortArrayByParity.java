package problem.easy;

/**
 * @Description Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * @Author zcf
 * @Date 2019-01-29 17:59
 **/
public class SortArrayByParity {

    public static void main(String[] args) {
        SortArrayByParity app = new SortArrayByParity();
        int[] input = {3,1,2,4};
        int[] output = app.sortArrayByParity1(input);
        for (int a:output){
            System.out.println(a);
        }
    }
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int l = 0;
        int r = A.length-1;
        for (int a:A){
            if (a%2==0){
                result[l] = a;
                l++;
            }else {
                result[r] = a;
                r--;
            }
        }
        return result;
    }

    public int[] sortArrayByParity1(int[] A) {
        int l = 0;
        int r = A.length-1;
        while (l<r){
            if (A[l]%2!=0){
                int temp = A[r];
                A[r]=A[l];
                A[l]=temp;
                r--;
            }else {
                l++;
            }
        }
        return A;
    }
}
