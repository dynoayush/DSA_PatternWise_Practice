// Subsets - II [LC-90]

import java.util.*;

public class Q62 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);   // To remove duplicates we must sort the provided array 
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(),nums,0);
        return result;
    }
    private void backtrack(List<List<Integer>> results, List<Integer> temp, int nums[], int start){
        results.add(new ArrayList<>(temp));
        for(int i = start; i<nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]){     // If any element matches with the previous one continue to the next element
                continue;
            }
            temp.add(nums[i]);
            backtrack(results, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args) {
         Q62 obj = new Q62();

        int[] nums = {1, 2, 2};

        List<List<Integer>> subsets = obj.subsetsWithDup(nums);

        System.out.println("Subsets are:");
        for(List<Integer> subset : subsets){
            System.out.println(subset);
        }
    }
}
