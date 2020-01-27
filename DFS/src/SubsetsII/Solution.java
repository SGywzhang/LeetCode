package SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int k;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for(k = 0; k < nums.length + 1; k++){
            helper(res, new ArrayList<>(), nums, 0, new boolean[nums.length]);
        }
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start,boolean[] visited){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < nums.length; i++){
            if(visited[i]) continue;
            if(i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(res, list, nums, i + 1, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
