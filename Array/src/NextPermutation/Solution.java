package NextPermutation;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {

        int replaceIndex = nums.length -2;

        while(replaceIndex >= 0){
            if(nums[replaceIndex] < nums[replaceIndex +1]) break;
            replaceIndex--;
        }

        if(replaceIndex < 0){
            Arrays.sort(nums);
            return;
        }

        int tempIndex = replaceIndex + 1;

        while(tempIndex < nums.length && nums[tempIndex] > nums[replaceIndex]){
            tempIndex++;
        }

        int temp = nums[replaceIndex];
        nums[replaceIndex] = nums[tempIndex - 1];
        nums[tempIndex - 1] = temp;

        Arrays.sort(nums,replaceIndex + 1, nums.length);
    }
}