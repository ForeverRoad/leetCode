package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Description In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 * <p>
 * Return the element repeated N times.
 * Example 1:
 * Input: [1,2,3,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,1,2,5,3,2]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [5,1,5,2,5,3,5,4]
 * Output: 5
 * Note:
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length is even
 * @Author zcf
 * @Date 2019-01-29 12:00
 *
 *
 **/
public class NRepeated {

    public static void main(String[] args) {
        int[] input = {2, 1, 3, 5, 2, 2};
        int i = repeatedNTimes2(input);
        System.out.println(i);
    }

    public static int repeatedNTimes(int[] A) {
        HashSet set = new HashSet();
        for (int i : A) {
            if (!set.add(i)){
                return i;
            }
        }
        return -1;
    }

    public static int repeatedNTimes1(int[] A) {
        int[] temp = new int[10000];
        int result = -1;
        for (int i : A) {
            if (temp[i]++ == 1) {
                result = i;
            }
        }
        return result;
    }

    //有N+1种数字，就保证了一半是重复数，另一半不是，所以最极端的分布就是1,N,1,N交叉分布，所以重复数会相邻或与前后隔一位重复
    public static int repeatedNTimes2(int[] A) {
        for (int i = 2; i < A.length; ++i)
            if (A[i] == A[i - 1] || A[i] == A[i - 2])
                return A[i];
        return A[0];
    }
}
