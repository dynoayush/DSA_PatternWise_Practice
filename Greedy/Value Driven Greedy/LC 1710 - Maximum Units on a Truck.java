import java.util.*;
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));   // Descending order sorting
        int units = 0;
        int i = 0;
        while (i < boxTypes.length && truckSize > 0) {
            int[] curr = boxTypes[i];
            int take = Math.min(curr[0], truckSize);
            units += take * curr[1];
            truckSize -= take;
            i++;
        }
        return units;
    }
}