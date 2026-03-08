// Contiguous Array [LC - 525]

import java.util.HashMap;

public class Q24 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int PrefixSum = 0;
        int maxLen = 0;

        for(int i = 0;i<nums.length;i++){
            int num = nums[i] == 0? -1: 1;
            PrefixSum += num;

            if(hm.containsKey(PrefixSum)){
                int length = i - hm.get(PrefixSum);
                maxLen = Math.max(maxLen, length);
            }

            if(!hm.containsKey(PrefixSum)){
                hm.put(PrefixSum,i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Q24 sol = new Q24();
        int num[] = {0,1,0,1,1};
        System.out.println(sol.findMaxLength(num));
    }
}
