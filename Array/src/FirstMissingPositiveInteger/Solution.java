package FirstMissingPositiveInteger;

class Solution {
    public int firstMissingPositive(int[] nums) {

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0 ){
                nums[i] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]);
            if(index <= nums.length){
                nums[index - 1] = - Math.abs(nums[index -1]);
            }
        }

        for(int i = 0; i< nums.length; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}