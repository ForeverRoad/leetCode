package problem.easy;

/**
 * @Auther zcf
 * @Date 2019-01-09
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 */
public class ToLowerCase {
    public static String toLowerCase(String str) {
//        return str.toLowerCase();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'A' && c <= 'Z') {
                chars[i] = (char) (c - 'A' + 'a');
            }
        }
        return new String(chars);
    }



    public static void main(String[] args) {
        System.out.println(toLowerCase("SdESdfde"));
    }
}
