// Permutation [LC-46]

import java.util.*;
public class Q63{
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> answer = new ArrayList<>();
        getPermute(nums,0,answer);
        return answer;
    }
    private void getPermute(int[] nums, int idx, List<List<Integer>> ans){
        if(idx==nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num:nums){  // This converts the array to list 
                temp.add(num);
            }
            ans.add(temp);
            return;
        }
        for(int i = idx;i<nums.length;i++){
            swap(nums,idx,i);
            getPermute(nums, idx+1, ans);
            swap(nums,idx,i);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        Q63 obj = new Q63();

        int[] nums = {1, 2, 3};

        List<List<Integer>> permutation = obj.permute(nums);

        System.out.println("Permutation:");
        for(List<Integer> permute:permutation){
            System.out.println(permute);
        }
    }
}