// Climbing Stairs (Memoization)

public class Q71_b {
        public int countWays(int n,int[] ways){
        if( n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        if(ways[n] != 0){
            return ways[n];
        }

        ways[n] = countWays(n-1, ways) + countWays(n-2,ways);
        return ways[n];
    }
    public static void main(String[] args) {
        Q71_b sol = new Q71_b();
        int n = 5;
        int ways[] = new int[n+1];
        System.out.println(sol.countWays(n,ways));
    }
}
