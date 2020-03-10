package QueueReconstructionByHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] res = new int[people.length][2];

        Arrays.sort(people, (a, b) ->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            else{
                return b[0] - a[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        for(int[] arr : people){
            list.add(arr[1], arr);
        }

        return list.toArray(new int[list.size()][2]);
    }
}