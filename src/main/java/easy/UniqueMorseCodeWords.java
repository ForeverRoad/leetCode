package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 * <p>
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 * <p>
 * Return the number of different transformations among all words we have.
 * <p>
 * Example:
 * Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation:
 * The transformation of each word is:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * <p>
 * There are 2 different transformations, "--...-." and "--...--.".
 * Note:
 * <p>
 * The length of words will be at most 100.
 * Each words[i] will have length in range [1, 12].
 * words[i] will only consist of lowercase letters.
 * @Author zcf
 * @Date 2019-01-25 17:30
 **/
public class UniqueMorseCodeWords {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        String[] words = {"gin","zen","gig","msg"};
        System.out.println(uniqueMorseRepresentations(words));
        System.out.println(System.currentTimeMillis()-time);
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> result = new HashSet<>();
        for (String key:words){
            StringBuilder sb = new StringBuilder();
            char[] chars = key.toCharArray();
            for (char c:chars){
                sb.append(code[(c - 'a')]);
            }
            result.add(sb.toString());
        }
        return result.size();
    }
}
