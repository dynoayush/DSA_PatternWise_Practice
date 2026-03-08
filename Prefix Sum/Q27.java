// Binary Subarrays with Sum [LC - 930]

import java.util.HashMap;
public class Q27 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int PrefixSum = 0;
        int count  = 0;

        for(int i = 0 ; i<nums.length;i++){
            PrefixSum += nums[i];

            if(hm.containsKey(PrefixSum - goal)){
                count += hm.get(PrefixSum - goal); 
            }
            hm.put(PrefixSum,hm.getOrDefault(PrefixSum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        Q27 sol = new Q27();
        int[] nums = {1,0,1};
        int goal = 2;
        System.out.println(sol.numSubarraysWithSum(nums, goal));
    }
}
