import java.util.*;

class Activity{
    int start,end;
    Activity(int s, int e){
        start = s;
        end = e;
    }
}
class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;

        ArrayList<Activity> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(new Activity(pairs[i][0],pairs[i][1]));
        }

        list.sort(new Comparator<Activity>(){ 
            public int compare(Activity a, Activity b){ 
                return Integer.compare(a.end, b.end); 
            } 
        });

        int count = 1; 
        int lastEnd = list.get(0).end; 
        for(int i=1;i<n;i++){ 
            if(list.get(i).start>lastEnd){ 
                count++; 
                lastEnd = list.get(i).end; 
            } 
        } 
    return count;
    }
}