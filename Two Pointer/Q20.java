// 3-Sum [LC -15]

import java.util.*;

public class Q20 {
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for(int i =0;i<n-2;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i]>0){
                break;
            }
            int left = i+1;
            int right = n-1;
            
            while(left<right){
                int target = -nums[i];
                int sum = nums[left] + nums[right];

                if(sum == target){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;

                        while(left<right && nums[left] == nums[left-1]){
                            left++;
                        }
                        while (left<right && nums[right] == nums[right+1]){
                            right--;                        
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return result;
        }

        public static void main(String[] args) {
            Q20 sol = new Q20();
            int[] nums = {-1, 0, 1, 2, -1, -4};
            List<List<Integer>> result = sol.threeSum(nums);
            System.out.println(result);
        }
    }

