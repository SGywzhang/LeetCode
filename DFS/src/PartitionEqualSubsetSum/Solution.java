package PartitionEqualSubsetSum;

import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if(sum % 2 != 0) return false;
        sum /= 2;
        return helper(nums, 0, sum);
    }

    boolean helper(int[] nums, int index, int target){
        if(target == 0) return true;
        if(index == nums.length || target < 0) return false;
        if(helper(nums, index + 1, target - nums[index])){
            return true;
        }
        int j = index + 1;
        while(j < nums.length && nums[index] == nums[j]){
            j++;
        }
        return helper(nums, j, target);
    }
}