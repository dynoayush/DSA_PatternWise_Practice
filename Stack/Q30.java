// Daily Temperatures [LC 739]

import java.util.Stack;
public class Q30 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] result_arr = new int[n];

        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int prev_idx = st.pop();
                int distance = i - prev_idx;
                result_arr[prev_idx] = distance;
            }
            st.push(i);
        }
        return result_arr;
    }

    public static void main(String[] args) {
        Q30 sol = new Q30();
        int[] temp = {73,74,75,71,69,72,76,73};
        int[] ans = sol.dailyTemperatures(temp);
        for(int num:ans){
        System.out.print(num + " ");
        }
    }
}
