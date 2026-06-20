// Koko Eating Bananas [LC-875]

public class Q48 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile: piles){
            right = Math.max(right, pile);
        }

        while(left<right){
            int mid = left + (right - left)/2;

            if(canEatAll(piles, mid, h)){
                right = mid;   // trying smaller speed
            }
            else{
                left = mid + 1; // need larger speed
            }
        }

        return left;
    }

    private boolean canEatAll(int[] piles, int speed, int h){
        int hours = 0;

        for(int pile: piles){
            hours += pile/speed;

            if(pile%speed != 0){
                hours++;
            }
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        Q48 sol = new Q48();
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println("Minimum eating speed: " + sol.minEatingSpeed(piles1, h1));
    }
}
