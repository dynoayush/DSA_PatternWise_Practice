// Count the number of subarrays with sum = 0

import java.util.HashMap;

public class Q22 {
    public int countZeroSumSubarrays(int[] nums){
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int PrefixSum = 0;
        int count = 0;

        for(int i = 0;i<nums.length;i++){
            int num = nums[i];
            PrefixSum += num;

            if(hm.containsKey(PrefixSum)){
                count += hm.get(PrefixSum);
            }
            hm.put(PrefixSum,hm.getOrDefault(PrefixSum, 0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        Q22 sol = new Q22();
        int[] nums = {1, -1, 2, -2, 3};
        System.out.println(sol.countZeroSumSubarrays(nums)); 

    }
}
