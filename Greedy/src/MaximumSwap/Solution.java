package MaximumSwap;

class Solution {
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int[] temp = new int[10];
        for(int i = 0; i < nums.length; i++){
            temp[nums[i] - '0'] = i;
        }

        for(int i = 0; i < nums.length; i++){
            for(int j = 9; j > nums[i] - '0'; j--){
                if(temp[j] > i){
                    swap(nums, temp[j], i);
                    return Integer.parseInt(new String(nums));
                }
            }
        }
        return num;
    }

    void swap(char[] nums, int i, int j){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}