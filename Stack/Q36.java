// Remove K Digits [LC - 402]

import java.util.Stack;

public class Q36 {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<num.length();i++){
            char curr = num.charAt(i);

            while(!st.isEmpty() && st.peek()>curr && k>0){
                st.pop();
                k--;
            }
            st.push(curr);
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0, st.pop());
        }
        int index = 0;
        while(index<sb.length() && sb.charAt(index) == '0'){
            index++;
        }
        sb.delete(0, index);

        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Q36 obj = new Q36();
        System.out.println(obj.removeKdigits("1432219", 3));
    }
}
