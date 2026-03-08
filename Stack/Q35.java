// Asteroid Collision [LC - 735]

import java.util.Stack;

public class Q35 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        for(int i = 0;i<n;i++){
            int current = asteroids[i];

            boolean destroyed = false;
            while(!st.isEmpty() && st.peek()>0 && current < 0){
                if(Math.abs(current) > st.peek()){
                    st.pop();
                    continue;
                }
                else if(Math.abs(current) == st.peek()){
                    st.pop();
                }
                destroyed = true;
                break;
            }
            if(!destroyed){
                st.push(current);
            }
        }
        int s = st.size();
        int[] result = new int[s];
        for(int i = s - 1;i>=0;i--){
            result[i] = st.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Q35 sol = new Q35();
        int[] asteroids = {5,10,-5};
        int[] ans = sol.asteroidCollision(asteroids);
        for(int num:ans){
            System.out.print(num+" ");
        }
    }
}
