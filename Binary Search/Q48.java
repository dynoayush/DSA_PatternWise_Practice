// Koko Eating Bananas [LC - 875]

public class Q48{
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;                            // Minimum speed of Koko
        int right = 0;

        for(int pile:piles){
            right = Math.max(right, pile);       // Maximum in an hour how much is speed of Koko who is having bananas
        }

        while(left<=right){
            int mid = left + (right - left)/2;
            int hours = 0;

            for(int pile:piles){
                hours+=(pile + mid - 1)/mid;
            }

            if(hours<=h){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Q48 sol = new Q48();
        int[] piles = {3,6,7,11};
        int h = 8;

        int result = sol.minEatingSpeed(piles, h);

        System.out.println("Minimum eating speed: " + result);
    }
}