// Subarray sums divisible by K [LC - 974]

import java.util.HashMap;

public class Q26 {
    public int subarrayDivbyK(int[] nums, int k){
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int PrefixSum = 0;
        int count = 0;

        for(int i = 0;i<nums.length;i++){
            PrefixSum += nums[i];

            int remainder = PrefixSum % k;
            if(remainder<0){
                remainder += k;
            }

            if(hm.containsKey(remainder)){
                count += hm.get(remainder);
            }

            hm.put(remainder,hm.getOrDefault(remainder, 0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        Q26 sol = new Q26();
        int[] nums = {2,3,1};
        int k = 3;
        System.out.println(sol.subarrayDivbyK(nums, k));
    }
}
