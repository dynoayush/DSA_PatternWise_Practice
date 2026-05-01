// Print X^2 in O(logn) - Optimized Method

public class Q57 {
    public static int optimized_Power(int a, int n){
        if(n ==0){
            return 1;
        }
        int halfPower = optimized_Power(a, n/2);
        int halfPowerSq = halfPower*halfPower;
        if(n%2!=0){
            halfPowerSq = a * halfPowerSq;
        }
        return halfPowerSq;
    }
    public static void main(String[] args) {
        int a = 2;
        int n = 5;
        System.out.println(optimized_Power(a, n));
    }
}
