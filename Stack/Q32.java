// Largest Rectangle in Histogram [LC - 84]

import java.util.Stack;
public class Q32 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i = 0;i<=n;i++){

            int currentHeight;
            if (i == n) {
                currentHeight = 0;
            } else {
                currentHeight = heights[i];
            }

            while(!st.isEmpty() && currentHeight<heights[st.peek()]){
                int top = st.pop();
                int height = heights[top];

                int width;
                if(st.isEmpty()){
                    width = i;
                } else {
                    width = i - st.peek() - 1;
                }

                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        Q32 sol = new Q32();
        int[] height = {2,1,5,6,2,3};
        System.out.println(sol.largestRectangleArea(height));
    }
}
