// Find Peak Element [LC - 162]

public class Q46{
    public int peakElement(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while (left<right) {
            int mid = left + (right - left)/2;

            if(nums[mid]<nums[mid+1]){
                left = mid + 1;
            } 
            else{
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Q46 sol = new Q46();
        int[] nums = {1,2,3,1};

        System.out.println(sol.peakElement(nums));
    }
}