package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length ==0) return intervals;
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int[] cur = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] > cur[1]){
                res.add(cur);
                cur = intervals[i];
            }
            else{
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
        }
        res.add(cur);

        return res.toArray(new int[res.size()][2]);

    }
}
