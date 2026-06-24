// Min Cost Climbing Stairs [LC - 746]

public class Q72 {

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        int[] minCost = new int[n + 1];

        minCost[0] = 0;
        minCost[1] = 0;

        for(int i = 2; i <= n; i++) {

            minCost[i] = Math.min(
                    cost[i - 1] + minCost[i - 1],
                    cost[i - 2] + minCost[i - 2]
            );
        }

        return minCost[n];
    }

    public static void main(String[] args) {

        Q72 sol = new Q72();

        int[] cost = {10, 15, 20};

        System.out.println(sol.minCostClimbingStairs(cost));
    }
}

