// Two Sum Less Than K [LC - 1099]

import java.util.Arrays;

public class Q40 {
    public int twoSumLessThanK(int[] nums,int k){
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int maxSum = -1;

        while (left < right) {
            int sum = nums[left]+nums[right];
            if(sum<k){
                maxSum = Math.max(maxSum, sum);
                left++;
            } 
            else{
                right--;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {

        Q40 sol = new Q40();

        int[] nums1 = {34, 23, 1, 24, 75, 33, 54, 8};
        int k1 = 60;

        int[] nums2 = {10, 20, 30};
        int k2 = 15;

        System.out.println(sol.twoSumLessThanK(nums1, k1)); // Expected: 58
        System.out.println(sol.twoSumLessThanK(nums2, k2)); // Expected: -1
    }
}

