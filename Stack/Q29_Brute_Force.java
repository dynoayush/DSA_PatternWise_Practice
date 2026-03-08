// Next Greater Element - 1 [LC 496]

public class Q29_Brute_Force{
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        int[] result = new int[nums1.length];
        for(int i = 0;i<nums1.length;i++){
            int target = nums1[i];
            int nextGreater = -1;
            int index = -1;
            for(int j = 0;j<nums2.length;j++){
                if(nums2[j] == target){
                    index = j;
                    break;
                }
            }

            for(int j = index+1;j<nums2.length;j++){
                if(nums2[j]>target){
                    nextGreater = nums2[j];
                    break;
                }
            }
            result[i] = nextGreater;
        }
        return result;
    }
    public static void main(String[] args) {
        Q29_Brute_Force sol = new Q29_Brute_Force();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] ans = sol.nextGreaterElement(nums1, nums2);

        for(int num : ans){
            System.out.print(num + " ");
        }
    }
}
