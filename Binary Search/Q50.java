// Minimum Number of days to make m bouquets [LC-1482]

public class Q50 {
    public int minDays(int[] bloomDay, int m, int k) {

        int startDay = 0;
        int endDay = 0;

        for (int day : bloomDay) {
            endDay = Math.max(endDay, day);
        }

        int minDays = -1;

        while (startDay <= endDay) {

            int mid = startDay + (endDay - startDay) / 2;

            if (canMakeBouquet(bloomDay, mid, k) >= m) {

                minDays = mid;
                endDay = mid - 1;

            } else {

                startDay = mid + 1;
            }
        }

        return minDays;
    }

    private int canMakeBouquet(int[] bloomDay, int day, int k) {

        int bouquetCount = 0;
        int consecutiveCount = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {

                consecutiveCount++;

            } else {

                consecutiveCount = 0;
            }

            if (consecutiveCount == k) {

                bouquetCount++;
                consecutiveCount = 0;
            }
        }

        return bouquetCount;
    }

    public static void main(String[] args) {

        Q50 sol = new Q50();

        // Example 1
        int[] bloomDay1 = {1, 10, 3, 10, 2};
        int m1 = 3;
        int k1 = 1;

        System.out.println(sol.minDays(bloomDay1, m1, k1));
    }
}

