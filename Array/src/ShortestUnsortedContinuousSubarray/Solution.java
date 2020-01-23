package ShortestUnsortedContinuousSubarray;

import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] numsClone = nums.clone();
        Arrays.sort(numsClone);
        int left = nums.length;
        int right = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != numsClone[i]){
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }
        return (right - left > 0) ? right - left + 1 : 0;
    }
}
