// Online Stock Span [LC - 901]

import java.util.Stack;

public class Q31{
    public int[] onlinestockPrice (int[] prices){
        Stack<Integer> st = new Stack<>();
        int n = prices.length;
        int[] spanArr = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && prices[i]>=prices[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                spanArr[i] = i+1;
            }
            else{
                spanArr[i] = i - st.peek();
            }
            st.push(i);
        }
        return spanArr;
    }
    public static void main(String[] args) {
        Q31 sol = new Q31();
        int[] price = {100,80,60,70,60,75,85};
        int[] ans = sol.onlinestockPrice(price);
        for(int num: ans){
            System.out.print(num + ", ");
        }
    }
}