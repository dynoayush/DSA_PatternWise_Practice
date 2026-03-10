// Find Minimum in Rotated Sorted Array [LC - 153]

public class Q45 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left<right){
            int mid = left + (right - left)/2;
            
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Q45 sol = new Q45();
        int[] nums = {3,4,5,6,0,1,2};

        System.out.println(sol.findMin(nums));
    }
}
