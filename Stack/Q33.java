// Trapping Rain Water [LC - 42]

import java.util.Stack;

public class Q33 {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int totalWater = 0;
        int n = height.length;
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&& height[i]>height[st.peek()]){

                int bottom = st.pop();

                if(st.isEmpty()) break;

                int left = st.peek();
                int right = i;

                int waterHeight = Math.min(height[left],height[right]) - height[bottom];
                int width = right - left - 1;
                totalWater += waterHeight * width;
            }
            st.push(i);
        }
        return totalWater;
    }

    public static void main(String[] args) {
        Q33 sol = new Q33();
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(sol.trap(heights));
    }
}
