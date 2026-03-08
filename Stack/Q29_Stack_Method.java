// Next Greater Element - 1 [LC 496]

import java.util.HashMap;
import java.util.Stack;

public class Q29_Stack_Method {
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i = 0;i<nums2.length;i++){
            int num = nums2[i];
            while(!st.isEmpty() && num>st.peek()){
                int smallest = st.pop();
                hm.put(smallest,num);
            }
            st.push(num);
        }
        while (!st.isEmpty()) {
            hm.put(st.pop(),-1);
        }
        int[] result = new int[nums1.length];

        for(int i = 0;i<nums1.length;i++){
            result[i] = hm.get(nums1[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        Q29_Stack_Method sol = new Q29_Stack_Method();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] ans = sol.nextGreaterElement(nums1, nums2);

        for(int num : ans){
            System.out.print(num + " ");
        }
    }
}
