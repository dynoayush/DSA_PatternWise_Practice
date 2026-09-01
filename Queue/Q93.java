// Dota2 Senate [LC - 649]

import java.util.*;

public class Q93 {

    public static String predictPartyVictory(String senate) {

        int n = senate.length();

        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        // Store indices of Radiant and Dire senators
        for (int i = 0; i < n; i++) {

            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }

        // Compare the next Radiant and Dire senator
        while (!radiant.isEmpty() && !dire.isEmpty()) {

            int r = radiant.poll();
            int d = dire.poll();

            // Radiant acts first
            if (r < d) {
                radiant.add(r + n);
            }

            // Dire acts first
            else {
                dire.add(d + n);
            }
        }

        if (radiant.isEmpty()) {
            return "Dire";
        }

        return "Radiant";
    }

    public static void main(String[] args) {

        String senate = "RDD";

        String result = predictPartyVictory(senate);

        System.out.println("Senate: " + senate);
        System.out.println("Winner: " + result);
    }
}