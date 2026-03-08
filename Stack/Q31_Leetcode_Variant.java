// Online Stock Span [LC - 901]

import java.util.Stack;

public class Q31_Leetcode_Variant {
    class StockSpanner {
    private Stack<Integer> priceStack;
    private Stack<Integer> spanStack;
    public StockSpanner() {
        priceStack = new Stack<>();
        spanStack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;

        while(!priceStack.isEmpty() && price>=priceStack.peek()){
            priceStack.pop();
            span += spanStack.pop();
        }
        priceStack.push(price);
        spanStack.push(span);

        return span;
    }
}
public static void main(String[] args) {

        Q31_Leetcode_Variant outer = new Q31_Leetcode_Variant();
        StockSpanner obj = outer.new StockSpanner();

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        for (int price : prices) {
            System.out.print(obj.next(price) + " ");
        }
    }
}
