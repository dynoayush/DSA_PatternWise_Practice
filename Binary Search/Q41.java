// Search Insert position [LC - 35]

public class Q41{
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left<=right){
            int mid = left + (right - left)/2;

            if(nums[mid] >= target){
                right = mid - 1; 
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Q41 sol = new Q41();
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(sol.searchInsert(nums, target));
    }
} 
