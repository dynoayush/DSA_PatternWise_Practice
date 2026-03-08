// Longest Substring without repeating characters (LC-3) 
 
import java.util.HashSet;

public class Q10 {
    public static int longestSubstring(String s){
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;

        for(int right = 0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = longestSubstring(s);
        System.out.println(result);
    }
}
