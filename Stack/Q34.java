// Next Greater Element - II [LC - 503]

import java.util.Arrays;
import java.util.Stack;

public class Q34 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for(int i = 0;i<2*n;i++){
            int index = i % n;
            while(!st.isEmpty() && nums[index]>nums[st.peek()]){
                int top = st.pop();
                result[top] = nums[index];
            }
            st.push(index);
        }
        return result;
    }

    public static void main(String[] args) {
        Q34 sol = new Q34();
        int[] number = {1,2,1};
        int[] res = sol.nextGreaterElements(number);
        for(int num: res){
            System.out.print(num+" ");
        }
    }
}
