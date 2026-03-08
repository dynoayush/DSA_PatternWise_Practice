// Sort array by Parity [LC - 905]

public class Q37 {
    public int[] sortArrayByParity(int[] nums) {
        int slow = 0;
        for(int fast = 0;fast<nums.length;fast++){
            if(nums[fast]%2 == 0){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        Q37 sol = new Q37();
        int[] nums = {3,1,2,4};
        int[] ans = sol.sortArrayByParity(nums);
        for(int answer:ans){
            System.out.print(answer + " ");
        }
    }
}
