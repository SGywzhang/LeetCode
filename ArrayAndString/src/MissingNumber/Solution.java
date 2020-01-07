package MissingNumber;

class Solution {
    public int missingNumber(int[] nums) {

        int originSum = 0;
        int curSum = 0;

        for(int i = 0; i <= nums.length; i++){
            originSum += i;
        }
        for(int i = 0; i < nums.length; i++){
            curSum += nums[i];
        }

        return originSum - curSum;
    }
}