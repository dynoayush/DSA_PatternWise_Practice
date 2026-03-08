// Remove an element from a given array (LC: 27)

public class Q5 {
    public static int removeElement(int[] nums, int val) {
        int write = 0 ;
        for(int read = 0;read<nums.length;read++){
            if(nums[read] != val){
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 4};
        int result = removeElement(arr,2);
        System.out.println(result);
    }
}
