// Subarray sum equals K [LC - 560]

import java.util.HashMap;

public class Q21{
    public int SubarraySum(int[] nums, int k){
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int PrefixSum = 0;
        int count = 0;

        for(int i =0;i<nums.length;i++){
            int num = nums[i];
            PrefixSum += num;

            if(hm.containsKey(PrefixSum - k)){
                count += hm.get(PrefixSum-k); 
            }

            hm.put(PrefixSum,hm.getOrDefault(PrefixSum,0) +1);
        }
        return count;
    }

    public static void main(String[] args) {
        Q21 sol = new Q21();
        int[] nums = {1, 2, 3};
        int k = 3;

        System.out.println(sol.SubarraySum(nums, k)); 
    }
}