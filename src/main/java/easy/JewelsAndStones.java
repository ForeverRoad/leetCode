package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * <p>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 * <p>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 * <p>
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        String S = randStr(100);
        String J = randStr(5);
        System.out.println("input S=" + S + ",J=" + J);
        int result = numJewelsInStones2(J, S);
        System.out.println(result);
    }

    public static String randStr(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * 52);
            if (rand > 25) {
                stringBuilder.append((char) (97 + rand - 26));
            } else {
                stringBuilder.append((char) (65 + rand));
            }

        }
        return stringBuilder.toString();

    }

    public static int numJewelsInStones(String J, String S) {
        int result = 0;
        char[] JC = J.toCharArray();
        char[] SC = S.toCharArray();
        for (int i = 0; i < JC.length; i++) {
            for (int j = 0; j < SC.length; j++) {
                if (JC[i] == SC[j]) {
                    result++;
                }
            }
        }
        return result;
    }

    public static int numJewelsInStones2(String J, String S) {
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            if (J.indexOf(S.charAt(i)) > -1) {
                result++;
            }
        }
        return result;
    }

    public static int best(String J, String S) {
        int res = 0;
        Set setJ = new HashSet();
        for (char j : J.toCharArray()) setJ.add(j);
        for (char s : S.toCharArray()) if (setJ.contains(s)) res++;
        return res;
    }

    public static int byRegex(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }
}
