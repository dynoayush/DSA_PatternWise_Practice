// Longest Repeating Character Replacement using HashMap (LC - 424)

import java.util.HashMap;

public class Q13_HashMap {
    public static int characterReplacement(String s, int k) {
        int left = 0;
        int maxLen = 0;
        int maxFreq = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // Add / update frequency
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }

            // Update max frequency
            maxFreq = Math.max(maxFreq, map.get(ch));

            int windowLength = right - left + 1;

            // Shrink window if invalid
            if (windowLength - maxFreq > k) {
                char leftChar = s.charAt(left);
                int count = map.get(leftChar) - 1;

                if (count == 0) {
                    map.remove(leftChar);
                } else {
                    map.put(leftChar, count);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        int result = characterReplacement(s, k);
        System.out.println(result);
    }
}

