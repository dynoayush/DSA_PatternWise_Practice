// Combination Sum [LC - 39]

import java.util.ArrayList;
import java.util.List;

public class Q65 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0, candidates, target, result, new ArrayList<>());
        return result;
    }
    private void findCombinations(int idx, int arr[], int target, List<List<Integer>> result, List<Integer> ds){
        if(idx == arr.length){
            if(target == 0){
                result.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[idx] <= target){
            ds.add(arr[idx]);
            findCombinations(idx, arr, target - arr[idx], result, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(idx+1, arr, target, result, ds);
    }
    public static void main(String[] args) {
        Q65 sol = new Q65();
        int[] candidates = {2,3,6,7};
        int target = 7;
        
        List<List<Integer>> results = sol.combinationSum(candidates, target);

        System.out.println("Combinations:");
        for (List<Integer> combination : results) {
            System.out.println(combination);
        }
    }
}
