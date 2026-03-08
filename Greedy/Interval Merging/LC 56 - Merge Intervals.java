import java.util.*;

class Activity{
    int start,end;
    Activity(int s, int e){
        start = s;
        end = e;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length<=1) {
            return intervals;
            }
        
        ArrayList<Activity> list  = new ArrayList<>();
        for(int i = 0;i<intervals.length;i++){
            list.add(new Activity(intervals[i][0],intervals[i][1]));
        }

        list.sort(new Comparator<Activity>(){
            public int compare(Activity a,Activity b){
                return Integer.compare(a.start,b.start);
            }
        });

        ArrayList<Activity> merged = new ArrayList<>();
        Activity current = list.get(0);
        merged.add(current);

        for(int i=1;i<list.size();i++){
            Activity next = list.get(i);
            if(next.start <= current.end){
                current.end = Math.max(current.end,next.end);
            } else {
                current = next;
                merged.add(current);
            }
        }

        int m = merged.size();
        int[][] result = new int[m][2];
        for(int i = 0;i<m;i++){
            result[i][0] = merged.get(i).start;
            result[i][1] = merged.get(i).end;
        }

        return result;

    }
}