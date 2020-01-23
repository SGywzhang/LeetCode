package MaxConsecutiveOnes;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;

        for(int i = 0; i < nums.length; i++){
            int cur = 0;
            while(i < nums.length && nums[i] == 1){
                i++;
                cur++;
            }
            max = Math.max(cur, max);
        }
        return max;
    }
}