package easy;

/**
 * @Description Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 * Example 1:
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 * Example 2:
 * Input: "III"
 * Output: [0,1,2,3]
 * Example 3:
 * Input: "DDI"
 * Output: [3,2,0,1]
 * Note:
 * <p>
 * 1 <= S.length <= 10000
 * S only contains characters "I" or "D".
 * @Author zcf
 * @Date 2019-01-28 17:30
 **/
public class DIStringMatch {

    public static void main(String[] args) {
        int[] result = diStringMatch("DDI");

        for (int i : result) {
            System.out.println(i);
        }

    }

    public static int[] diStringMatch(String S) {
        char[] arr = S.toCharArray();
        int[] result = new int[arr.length + 1];

        int iIndex = 0;
        int dIndex = S.length();
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 'I') {
                result[i] = iIndex;
                iIndex++;
            } else {
                result[i] = dIndex;
                dIndex--;
            }
            if (i >= (arr.length - 1)) {
                result[i + 1] = iIndex;
            }
        }
        return result;
    }
}
