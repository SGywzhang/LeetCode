package SortColor;

class Solution {
    public void sortColors(int[] nums) {
        int p1 = -1;
        int p2 = nums.length;
        int i = 0;
        while(i < p2){
            if(nums[i] == 1){
                i++;
            }
            else if(nums[i] == 2){
                p2--;
                swap(nums, i, p2);
            }
            else{
                p1++;
                swap(nums, i, p1);
                i++;
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
