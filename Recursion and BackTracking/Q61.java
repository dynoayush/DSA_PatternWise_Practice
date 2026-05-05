// Subsets [LC-78]

import java.util.*;

public class Q61 {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(), nums, 0);
        return result;
    }
    private void backtrack(List<List<Integer>> results, List<Integer> temp, int[] nums, int start){
        results.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            backtrack(results, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
         Q61 obj = new Q61();

        int[] nums = {1, 2, 3};

        List<List<Integer>> subsets = obj.subsets(nums);

        System.out.println("Subsets are:");
        for(List<Integer> subset : subsets){
            System.out.println(subset);
        }
    }
}
