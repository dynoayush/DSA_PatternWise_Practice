// Find all anagrams in a string (LC - 438)

import java.util.*;

public class Q15 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length()>s.length()){
            return result;
        }

        int[] freqp = new int[26];
        int required = 0;

        for(int i=0;i<p.length();i++){
            char ch = p.charAt(i);
            int index = ch - 'a';

            if(freqp[index] == 0){
                required++;
            }
            freqp[index]++;
        }
        
        int[] windowFreq = new int[26];
        int formed = 0;
        int left = 0;
        int window = p.length();

        for(int right = 0;right<s.length();right++){
            char rightchar = s.charAt(right);
            int rightindex = rightchar - 'a';
            windowFreq[rightindex]++;

            if(windowFreq[rightindex] == freqp[rightindex]){
                formed++;
            }

            int windowSize = right - left + 1;

            if(windowSize>window){
                char leftchar = s.charAt(left);
                int leftindex = leftchar - 'a';

                if(windowFreq[leftindex] == freqp[leftindex]){
                    formed--;
                }
                windowFreq[leftindex]--;
                left++;
            }
            if(formed == required){
                result.add(left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q15 sol = new Q15();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = sol.findAnagrams(s, p);
        System.out.println("Anagram starting indices: " + result);
    }
}
