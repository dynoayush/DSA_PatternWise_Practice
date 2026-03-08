// Longest subarray with sum k [GFG]

import java.util.HashMap;

public class Q23 {
    public int longestSubarray(int[] arr, int k){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int PrefixSum = 0;
        int maxLen = 0;

        for(int i =0;i<arr.length;i++){
            int num = arr[i];
            PrefixSum += num;

            if(PrefixSum == k){
                maxLen = i + 1;
            }

            if(hm.containsKey(PrefixSum - k)){
                int length = i - hm.get(PrefixSum-k);
                maxLen = Math.max(maxLen, length);
            }

            if(!hm.containsKey(PrefixSum)){
                hm.put(PrefixSum,i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Q23 sol = new Q23();
        int arr[] = {1,-1,5,-2,3};
        int k = 3;
        System.out.println(sol.longestSubarray(arr, k));
    }
}
