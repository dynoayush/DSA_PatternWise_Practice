// Capacity to ship packages within D days [LC-1011]

public class Q49{
    public int shipWithinDays(int[] weights, int days){
        int left = 0;
        int right = 0;

        for(int weight: weights){
            left = Math.max(left, weight);
            right += weight;
        }

        while(left<right){
            int mid = left+(right-left)/2;

            if(canShip(weights, mid, days)){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }

    private boolean canShip(int[] weights, int capacity, int days){
        int usedDays = 1;
        int currentLoad = 0;

        for(int weight: weights){
            if(currentLoad + weight>capacity){
                usedDays++;
                currentLoad=0;
            }
            currentLoad += weight;
        }
        return usedDays <= days;
    }

    public static void main(String[] args) {
        Q49 sol = new Q49();
        int[] input = {3,2,2,4,1,4};
        int days = 3;
        System.out.println("Minimum shipping capacity: " + sol.shipWithinDays(input, days));
    }
}