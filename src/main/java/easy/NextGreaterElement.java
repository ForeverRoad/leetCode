package easy;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

/**
 * 给你一个数组，返回一个等长的数组，对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1。不好用语言解释清楚，直接上一个例子：
 * <p>
 * 给你一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,-1]。
 * <p>
 * 解释：第一个 2 后面比 2 大的数是 4; 1 后面比 1 大的数是 2；第二个 2 后面比 2 大的数是 4; 4 后面没有比 4 大的数，填 -1；3 后面没有比 3 大的数，填 -1。
 */
public class NextGreaterElement {


    public static void main(String[] args) {
        int[] arr = new int[100000];

        for (int i=0;i<100000;i++){
            arr[i] = (int) (Math.random()*1000);
        }
        System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        int[] result = nextGreater(arr);

        System.out.println(System.currentTimeMillis()-start);
        start = System.currentTimeMillis();
        int[] low = low(arr);
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(low));

    }

    static int[] low(int[] arr){
        //结果
        int[] result = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            int max = -1;
            for (int j=i;j<arr.length;j++){
                if (arr[j]>arr[i]){
                    max=arr[j];
                    break;
                }
            }
            result[i]= max;
        }
        return result;
    }
    static int[] nextGreater(int[] arr) {
        //结果
        int[] result = new int[arr.length];
        //单调栈
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            //小的就直接丢掉
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }
            //当前数的结果就是栈顶的值
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }
}
