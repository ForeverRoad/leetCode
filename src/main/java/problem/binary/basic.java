package problem.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * 二进制常见问题
 */
public class basic {

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 7, 3, 4, 4, 7, 2, 2};
//        System.out.println(singleNumber(arr));
//        System.out.println(singleNumber2(arr));
//        System.out.println(singleNumberMod(arr));

        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();

        byte[] bytes = data.getBytes();

        for (int i=0;i<bytes.length/2;i++){
            byte temp = bytes[i];
            bytes[i] = bytes[bytes.length-1-i];
            bytes[bytes.length-1-i] = temp;
        }
        System.out.println(new String(bytes));
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(()->{});
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     */

    public static int singleNumber(int[] arr) {
        int result = 0;
        //相同的数字亦或后会抵消，所以剩下的就是单独的那个数
        for (int n : arr) {
            result = result ^ n;
        }
        return result;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现三次。找出那个只出现了一次的元素。
     *
     * @param nums
     * @return
     */
    //{2,4,7,7,3,4,4,7,2,2}
    public static int singleNumber2(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }

    //计算每个位置的1的数量，然后于3取模，余一是单独的那个数
    public static int singleNumberMod(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] >> i) & 1;
            }

            result ^= sum % 3 << i;
        }

        return result;
    }

    /**
     *给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素
     * @param nums
     * @return
     */
    public static int[] singleNumber3(int[] nums){
        // 通过异或去除偶数次等元素，剩下单独的两个元素的结果
        //x & (-x) 是保留位中最右边 1 ，且将其余的 1 设位 0 的方法。求出两个数之间的差异
        //
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) bitmask ^= num;

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums) if ((num & diff) != 0) x ^= num;

        return new int[]{x, bitmask^x};

    }

    //计算一个数二进制中含多少个1
    public static int numberOfBits(int num){
        int result = 0;
        while (num>0){
            result++;
            num=num&(num-1);
        }
        return result;
    }
    //给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回
    public static int[] countOfBits(int num){
        int[] result = new int[num+1];
        //上一个缺1的元素加1
        for (int i=1;i<num;i++){
            result[i] = result[i&(i-1)]+1;
        }
        return result;
    }



}
