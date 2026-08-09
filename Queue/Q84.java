// Implement Queue using Stacks [LC-232]

import java.util.*;

public class Q84 {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public boolean empty(){
        return s1.empty();
    }

    public void add(int x){
        while(!s1.empty()){
            s2.push(s1.pop());
        }

        s1.push(x);

        while(!s2.empty()){
            s1.push(s2.pop());
        }
    }

    public int remove(){
        if(empty()){
            return -1;
        }

        return s1.pop();  
    }

    public int peek(){
        if (empty()) {
            return -1;
        }

        return s1.peek();
    }

    public static void main(String[] args) {
        Q84 q = new Q84();

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("Front: " + q.peek());

        System.out.println("Removed: " + q.remove());

        System.out.println("Front: " + q.peek());

        q.add(4);

        System.out.println("Removed: " + q.remove());
        System.out.println("Removed: " + q.remove());
        System.out.println("Removed: " + q.remove());

        System.out.println("Queue empty: " + q.empty());
    }
}
