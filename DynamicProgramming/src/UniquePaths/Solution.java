package UniquePaths;

import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[] arr = new int[m];
        Arrays.fill(arr,1);

        for(int j = 1; j < n; j++){
            for(int i = 1; i < m; i++){
                arr[i] = arr[i] + arr[i - 1];
            }
        }
        return arr[m - 1];
    }
}
