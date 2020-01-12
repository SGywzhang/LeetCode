package ContainsDuplicateIII;

import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k <= 0 || t < 0) return false;

        TreeSet<Integer> set = new  TreeSet<>();
        for(int i = 0 ; i <  nums.length; i ++){

            Integer floor = set.floor(nums[i]);
            if(floor != null && Math.abs(Long.valueOf(nums[i]) - Long.valueOf(floor)) <= t){
                return true;
            }

            Integer ceil = set.ceiling(nums[i]);
            if(ceil != null && Math.abs(Long.valueOf(nums[i]) - Long.valueOf(ceil)) <= t){
                return true;
            }

            set.add(nums[i]);

            if(i >= k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}