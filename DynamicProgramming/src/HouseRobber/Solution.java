package HouseRobber;

class Solution {
    public int rob(int[] nums) {

        int rob = 0;
        int notRob = 0;

        for(int num : nums){
            int pre = Math.max(rob, notRob);
            rob = num + notRob;
            notRob = pre;
        }
        return Math.max(rob, notRob);
    }
}
