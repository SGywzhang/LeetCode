package MaximumSubarray;

class Solution {
    public int maxSubArray(int[] nums) {

        int sum = nums[0];
        int max = nums[0];
        for(int f = 1;  f< nums.length; f++){

            if(nums[f] > sum + nums[f]){
                sum = nums[f];
            }
            else{
                sum += nums[f];
            }
            if(sum > max) max =sum;
        }
        return max;
    }
}