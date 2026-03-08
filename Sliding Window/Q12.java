// Longest substring with exactly k distinct characters (GFG)

import java.util.HashMap;
public class Q12 {
    
    public static int longestKSubstr(String s, int k) {
        int left = 0;
        int maxLen = 0;
        
        HashMap<Character, Integer> hm = new HashMap <>();
        
        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);
            }
            else{
                hm.put(ch,1);
            }
            
            while(hm.size()>k){
                char leftChar = s.charAt(left);
                int count = hm.get(leftChar) - 1;
                if(count == 0){
                    hm.remove(leftChar);
                }
                else{
                    hm.put(leftChar,count);
                }
                left++;
            }
             if (hm.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        if (maxLen == 0) return -1;
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "tvtgv";
        int k = 4;

        int result = longestKSubstr(s, k);
        System.out.println(result);
}
}
    

