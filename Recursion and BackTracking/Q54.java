// Print Nth Fibonacci Number

public class Q54 {
    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        int nm1 = fib(n-1);
        int nm2 = fib(n-2);
        int fn = nm1 + nm2;
        return fn;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(n));
    }
}
