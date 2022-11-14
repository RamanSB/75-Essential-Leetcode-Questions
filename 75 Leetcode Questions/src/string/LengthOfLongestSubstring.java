package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Think before coding with this one (as you should always).
 *
 * Consider the following string "dvdfae"...
 *
 * Intuitively one would begin at the 0-index 'd' and count 1, then move to the next index "v" and count 2.
 * However when we move to the index after "v", (index-2) we get 'd' and therefore we cannot increment our length to 3,
 * we must record that:
 *  - 2 is the largest length we have seen thus far
 *  - reset our length to 0 and begin counting from v onwards.
 *
 *  The notion of restarting our count from the next index that we had initially started from can be coded using the
 *  2-pointer technique.
 *
 *  We use a map to record / check if repeated characters are encountered as we traverse the string, if a repeated character is
 *  encountered, we increment our start pointer and set back = start (this mimics starting from the next index
 *  that we had initially started on and failed...)
 *
 *  Suppose there are n characters and are solution is k, k the largest length of the non-repeating substring.
 *
 *  Space Complexity: Then the max number of elements our Map must hold will be K, leading to space complexity of O(k).
 *
 *  Time complexity: O(n)
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int size = 0;
        int start = 0, back = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxSize = 0;
        if (s.isEmpty()) {
            return 0;
        }
        while (back != s.length()) {
            if (!map.containsKey(s.charAt(back))) {
                map.put(s.charAt(back), 1);
                size++;
                if (size > maxSize) {
                    maxSize = size;
                }
                back++;
            } else {
                map.clear();
                start++;
                back = start;
                size = 0;
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring instance = new LengthOfLongestSubstring();
        String test = "dvdfae";
        System.out.println(instance.lengthOfLongestSubstring(test)); // 5
    }
}
