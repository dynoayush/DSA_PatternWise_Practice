// Number of Recent Calls [LC - 933]

import java.util.*;

public class Q92 {

    static class RecentCounter {

        Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {

            if (queue.size() == 0) {
                queue.add(t);
                return 1;
            } else {

                if (t <= 3000) {
                    queue.add(t);
                } else {

                    int margin = t - 3000;

                    while (queue.size() != 0 && queue.peek() < margin) {
                        queue.poll();
                    }

                    queue.add(t);
                }

                return queue.size();
            }
        }
    }

    public static void main(String[] args) {

        RecentCounter recentCounter = new RecentCounter();

        System.out.println(recentCounter.ping(1));     // 1
        System.out.println(recentCounter.ping(100));   // 2
        System.out.println(recentCounter.ping(3001));  // 3
        System.out.println(recentCounter.ping(3002));  // 3
    }
}