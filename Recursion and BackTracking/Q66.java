// Combination Sum II [LC - 40]

import java.util.*;

public class Q66 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, result, new ArrayList<>());
        return result;
    }

    private void findCombinations(int index, int[] arr, int target, List<List<Integer>> result, List<Integer> ds){
        if(target == 0){
            result.add(new ArrayList<>(ds));
            return;
        }

        for(int i = index;i<arr.length;i++){
            if(i>index && arr[i] == arr[i-1]) continue;
            if(arr[i]>target) break;

            ds.add(arr[i]);
            findCombinations(i+1, arr, target - arr[i], result, ds);
            ds.remove(ds.size()-1);
        }
    }

    public static void main(String[] args) {
        Q66 sol = new Q66();
        int[] candidates = {1,1,1,2,2};
        int target = 4;
        
        List<List<Integer>> results = sol.combinationSum2(candidates, target);

        System.out.println("Combinations:");
        for (List<Integer> combination : results) {
            System.out.println(combination);
        }
    }
}
