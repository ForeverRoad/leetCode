package problem.need;

/**
 * @Description 计算数字中二进制中1的个数
 * @Author zcf
 * @Date 2020-06-23 16:41
 **/
public class OneNumbers {
    public static void main(String[] args) {
        int solution = solution(1230);
        int solution2 = solution2(1230);
        System.out.println(solution);
        System.out.println(solution2);
    }

    //左移1，计算
    public static int solution(int n){
        int key = 1;
        int result = 0;
        for (int i=0;i<32;i++){
            if ((n&key)!=0){
                result++;
            }
            key<<=1;
        }
        return result;
    }

    // 一个数和比自己小1的数做与运算，会把这个数最右边的1变成0；
    //然后看能做几次这样的运算，这个数就有多少个1；
    //这个方法有多少个1，就只需要循环多少次，是最优解法；
    public static int solution2(int n){
        int result = 0;
        while (n!=0){
            n = n&(n-1);
            result++;
        }
        return result;
    }
}
