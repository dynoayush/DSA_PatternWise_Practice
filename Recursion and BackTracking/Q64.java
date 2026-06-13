// Permutation II [LC - 47] 

import java.util.*;

public class Q64 {
    public List<List<Integer>> permuteUnique(int [] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permute = new ArrayList<>();

        HashMap <Integer,Integer> Count = new HashMap<>();
        for(int num: nums){
        Count.put(num, Count.getOrDefault(num,0)+1);
        }
        permutation(result, permute, Count, nums.length);
        return result;
    }

    private void permutation(List<List<Integer>> result, List<Integer> permute, HashMap<Integer,Integer> count, int n){
        if(permute.size() == n){
            result.add(new ArrayList<>(permute));
            return;
        }
        for(int num: count.keySet()){  // Keyset - returns only the keys
            if(count.get(num)>0){
                // choose 
                permute.add(num);  // take this number
                count.put(num, count.get(num)-1); // reduce the availability
                
                // explore
                permutation(result, permute, count, n); // fill remaining positions

                // undo 
                count.put(num, count.get(num)+1); // restore original state
                permute.remove(permute.size()-1); // try with another choice
            }
        }
    }

    public static void main(String[] args) {
        Q64 sol = new Q64();
        int[] nums = {1, 1, 2};

        List<List<Integer>> result = sol.permuteUnique(nums);
        
        System.out.println("Unique Permutations:");
        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }
}
