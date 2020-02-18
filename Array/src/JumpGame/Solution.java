package JumpGame;

class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > max) return false;
            int cur = i + nums[i];
            max = Math.max(cur,max);
        }
        return true;
    }
}
