package LongestIncreasingPathInAMatrix;

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(dp[i][j] == 0){
                    dfs(matrix, i ,j, dp, Integer.MIN_VALUE);
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    int dfs(int[][] matrix, int i, int j, int[][] dp, int pre){
        if(i < 0 || i > matrix.length - 1 ||
                j < 0 || j > matrix[0].length - 1 ||
                matrix[i][j] <= pre) return 0;

        if(dp[i][j] != 0) return dp[i][j];

        int left = dfs(matrix, i, j - 1, dp, matrix[i][j]);
        int right = dfs(matrix, i, j + 1, dp, matrix[i][j]);
        int up = dfs(matrix, i - 1, j, dp, matrix[i][j]);
        int down = dfs(matrix, i + 1, j, dp, matrix[i][j]);

        dp[i][j] = Math.max(left, Math.max(right, Math.max(up, down))) + 1;
        return dp[i][j];
    }
}
