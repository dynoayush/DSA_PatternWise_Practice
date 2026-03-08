// Largest subarray with 0 sum [GFG]

import java.util.HashMap;

public class Q25 {
    public int maxLength(int arr[]){
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int PrefixSum = 0;
        int maxLen = 0;

        for(int i = 0;i<arr.length;i++){
            int num = arr[i];
            PrefixSum += num;

            if(hm.containsKey(PrefixSum)){
                int length = i - hm.get(PrefixSum);
                maxLen = Math.max(maxLen, length);
            }
            else {
                hm.put(PrefixSum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Q25 sol = new Q25();
        int[] arr = {1,-1,2,-2,3};
        System.out.println(sol.maxLength(arr));
    }
}
