// Implement Stack using Queues [LC - 225]

import java.util.*;

public class Q85 {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public void push(int x){
        if(!q1.isEmpty()){
            q1.add(x);
        } else {
            q2.add(x);
        }
    }

    public int pop(){
        if (empty()){
            return -1;
        }

        int top = -1;

        if(!q1.isEmpty()){

            while(!q1.isEmpty()){
                top = q1.remove();
                if(q1.isEmpty()){
                    break;
                }

                q2.add(top);
            }
        } else {
            // Case 2: q2 contains the elements
            while (!q2.isEmpty()) {

                top = q2.remove();

                // Last element is the stack top
                if (q2.isEmpty()) {
                    break;
                }

                q1.add(top);
            }
        }

        return top;
    }
    
    public int top() {

        if (empty()) {
            return -1;
        }

        int top = -1;

        // Case 1: q1 contains the elements
        if (!q1.isEmpty()) {

            while (!q1.isEmpty()) {

                top = q1.remove();

                q2.add(top);
            }

        } else {

            // Case 2: q2 contains the elements
            while (!q2.isEmpty()) {

                top = q2.remove();

                q1.add(top);
            }
        }

        return top;
    }

    public static void main(String[] args) {
        Stack s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}


