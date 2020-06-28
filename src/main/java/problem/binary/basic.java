package problem.binary;

/**
 * 二进制常见问题
 */
public class basic {

    public static void main(String[] args) {
        int[] arr = {2,4,6,7,3,4,6,7,2};
        System.out.println(singleNumber(arr));

    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     */

    public static int singleNumber(int[] arr){
        int result = 0;
        //相同的数字亦或后会抵消，所以剩下的就是单独的那个数
        for (int n : arr) {
            result= result^n;
        }
        return result;
    }
}
