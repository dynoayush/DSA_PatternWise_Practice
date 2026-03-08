// Sliding Window Maximum (LC - 239)

import java.util.*;

public class Q17 {
    public int[] maxSlidingWindow(int[] nums, int k){
        int n = nums.length;
        int[] result = new int[n-k+1];
        int idx = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            // Remove those indices which are out of the current window
            if(!dq.isEmpty() && dq.peekFirst()<i-k+1){
                dq.removeFirst();
            }
            // Remove smaller elements from the back
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.removeLast();
            }
            // Add current Index
            dq.addLast(i);
            // Store result once window is valid
            if(i>=k-1){
                result[idx++] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Q17 sol = new Q17();

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] ans = sol.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }
}
