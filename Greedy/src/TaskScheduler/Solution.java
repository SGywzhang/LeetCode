package TaskScheduler;

import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] record = new int[26];

        for(char ch : tasks){
            record[ch - 'A']++;
        }

        Arrays.sort(record);
        int max_n = record[25] - 1;
        int area = max_n * n;

        for(int i = 24; i >= 0 && record[i] > 0; i--){
            area -= Math.min(max_n, record[i]);
        }
        return area > 0 ? tasks.length + area : tasks.length;
    }
}
