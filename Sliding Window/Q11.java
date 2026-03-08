// Longest Substring with at-most K unique/distinct Characters (LC-340)

import java.util.HashMap;

public class Q11 {
    public static int longestSubstringKDistinct(String s, int k) {
        int left = 0;
        int maxLen = 0;

        HashMap<Character, Integer> hm = new HashMap<>();

        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);
            } else {
                hm.put(ch,1);
            }

            while(hm.size()>k){
                char leftChar = s.charAt(left);
                int count = hm.get(leftChar)-1;
                if(count==0){
                    hm.remove(leftChar);
                } else {
                    hm.put(leftChar,count);
                }
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;

        int result = longestSubstringKDistinct(s, k);
        System.out.println(result);
    }
}
