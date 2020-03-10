package LongestIncreasingSubsequence;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int len = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    len = Math.max(len, dp[j] + 1);
                }
            }
            dp[i] = len;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}