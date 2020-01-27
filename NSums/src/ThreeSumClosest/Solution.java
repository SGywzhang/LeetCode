package ThreeSumClosest;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return -1;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i -1] == nums[i]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - sum) < diff){
                    diff = Math.abs(target - sum);
                    res = sum;
                }

                if(target == sum){
                    return sum;
                }
                else if(target > sum){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return res;
    }
}
