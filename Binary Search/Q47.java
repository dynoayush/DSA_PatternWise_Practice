// Search in rotated sorted array [LC - 81]

public class Q47 {
    public boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return true;
            }

            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                left++;
                right--;
                continue;
            }

            if(nums[left] <= nums[mid]){

                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }

            else{

                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Q47 sol  = new Q47();
        int nums[] = {2,5,6,0,0,1,2};
        int target = 0;
        boolean result = sol.search(nums, target);
        System.out.println("Target found: " + result);
    }

}
