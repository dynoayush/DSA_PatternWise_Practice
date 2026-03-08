// Longest Repeating Character Replacement using Array (LC - 424)

public class Q13_Array {
    public static int longestRepeatingCharacter( String s, int k){
        int left = 0;
        int maxLen = 0;
        int maxFreq = 0;
        int[] freq = new int[26];

        for(int right = 0; right< s.length();right++){
            char ch = s.charAt(right);
            int index = ch - 'A';

            freq[index]++;
            maxFreq = Math.max(maxFreq, freq[index]);

            int windowSize = right - left + 1;

            if(windowSize - maxFreq > k){
                char leftCh = s.charAt(left);
                int leftindex = leftCh - 'A';

                freq[leftindex]--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        int result = longestRepeatingCharacter(s, k);
        System.out.println(result);
    }
}


