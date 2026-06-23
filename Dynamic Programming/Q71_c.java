// Climbing Stairs (Tabulation)

public class Q71_c {
    public int countWays(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i] = dp[i-1];
            }
            else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
    return dp[n];
    }
    public static void main(String[] args) {
        Q71_c sol = new Q71_c();
        int n = 5;
        System.out.println(sol.countWays(n));
    }
}

