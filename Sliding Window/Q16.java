// Minimum Window Substring (LC - 76)

public class Q16 {
    public String minWindow(String s, String t){
        if(t.length()> s.length()){
            return "";
        }

        int[] freqT = new int[128];
        int required = 0;
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(freqT[ch]==0){
                required++;
            }
            freqT[ch]++;    
        }
        int[] windowFreq = new int[128];
        int formed = 0;
        int left = 0;
        int bestLen = Integer.MAX_VALUE;
        int bestStart = 0;

        for(int right = 0;right<s.length();right++){
            char rightchar = s.charAt(right);
            windowFreq[rightchar]++;

            if(windowFreq[rightchar] == freqT[rightchar]){
                formed++;
            }

            while(formed == required){
                int windowSize = right - left + 1;
                if(windowSize<bestLen){
                    bestLen = windowSize;
                    bestStart = left;
                }

                char leftchar = s.charAt(left);
                windowFreq[leftchar]--;
                if(windowFreq[leftchar]< freqT[leftchar]){
                    formed--;
                }
                left++;
            }
        }
        if(bestLen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(bestStart, bestStart+bestLen);
    }
    public static void main(String[] args) {
        Q16 sol = new Q16();
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = sol.minWindow(s, t);
        System.out.println("Minimum window substring: " + result);
    }
}
