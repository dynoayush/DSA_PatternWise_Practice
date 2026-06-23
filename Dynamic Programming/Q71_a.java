// Climbing Stairs (Recursion)

public class Q71_a {
    public int countWays(int n){

        if( n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        return countWays(n-1) + countWays(n-2);
    }
    public static void main(String[] args) {
        Q71_a sol = new Q71_a();
        int n = 5;
        System.out.println(sol.countWays(n));
    }
}
