// Valid Parenthesis [LC - 20]

import java.util.Stack;

public class Q28{
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }

            else{
                if(stack.isEmpty()){
                    return false;
                }

                char top = stack.pop();

                if(ch == ')' && top!='(') return false;
                if(ch == '}' && top!='{') return false;
                if(ch == ']' && top!='[') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Q28 sol = new Q28();
        System.out.println(sol.isValid("{[]}"));   
        System.out.println(sol.isValid("([)]"));   
        System.out.println(sol.isValid("(((")); 
    }
}