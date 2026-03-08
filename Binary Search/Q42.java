// Find First and Last Position of Element in Sorted Array [LC - 34]

import java.util.Arrays;

public class Q42{
    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target); 
        if (first == nums.length || nums[first] != target) {
        return new int[]{-1, -1};
    }
        int last = upperBound(nums, target) - 1;
        return new int[]{first, last};
    }
    
    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private int upperBound(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Q42 sol = new Q42();
        int[] num = {5,7,7,8,8,10};
        int target = 8;

        System.out.println(Arrays.toString(sol.searchRange(num, target)));
    }
}
