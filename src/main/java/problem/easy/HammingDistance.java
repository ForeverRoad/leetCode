package problem.easy;

/**
 * @Description
 * @Author zcf
 * @Date 2019-02-11 11:08
 **/
public class HammingDistance {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        int result = 0;
        int input = x ^ y;
        //移位，把int转成二进制
        //for (int i=0;i<32;i++) {
        //  result += (input >>> i) & 1;
        //}

        //api  Integer.bitCount(i);
        String str = Integer.toBinaryString(input);
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == '1') {
                result++;
            }
        }
        return result;
    }
}
