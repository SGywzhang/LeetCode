package LargestNumberAtLeastTwiceOfOthers;

class Solution {
    public int dominantIndex(int[] nums) {

        if(nums.length == 1) return 0;

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int firstIndex = 0;

        for(int i = 0; i < nums.length; i++){

            if(nums[i] > first){
                second = first;
                first = nums[i];
                firstIndex = i;
            }
            else if(nums[i] > second && nums[i] != first){
                second = nums[i];
            }
        }

        if(first >= second * 2){
            return firstIndex;
        }
        else{
            return -1;
        }
    }
}