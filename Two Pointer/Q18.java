// Two Sum-|| (Input is sorted array) [LC - 167]

import java.util.Arrays;

public class Q18 {
    public int[] twoSum(int[] numbers,int target){
        int left=0;
        int right = numbers.length - 1;

        while(left<right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left+1,right+1};
            }
            else if (sum<target){
                left++;
            }
            else{
                right--;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        Q18 sol = new Q18();
        int[] numbers = {2,7,11,15};
        int target = 9;

        int[] result = sol.twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }
}
