// Permutation in String (LC - 567)

public class Q14 {
    public static boolean checkPermutation(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        // For S1
        int[] freqS1 = new int[26];
        int required = 0;

        for(int i = 0;i<s1.length();i++){
            char ch = s1.charAt(i);
            int index = ch - 'a';

            if(freqS1[index] == 0){
                required++;
            }
            freqS1[index]++;
        }
        // For S2
        int[] windowFreq = new int[26];
        int formed = 0;
        int left = 0;
        int window = s1.length();

        for(int right = 0;right<s2.length();right++){
            char ch = s2.charAt(right);
            int rightindex = ch - 'a';
            windowFreq[rightindex]++;

            if(windowFreq[rightindex] == freqS1[rightindex]){
                formed++;
            }

            int windowSize = right - left + 1;

            if(windowSize>window){
                char leftch = s2.charAt(left);
                int leftindex = leftch - 'a';

                if(windowFreq[leftindex] == freqS1[leftindex]){
                    formed--;
                }
                windowFreq[leftindex]--;
                left++;
            }
            if(formed == required){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String S1 = "ab";
        String S2 = "eidboaoo";

        System.out.println(checkPermutation(S1, S2));
    }
}

