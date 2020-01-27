package PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), new boolean[nums.length], nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, boolean[] visited, int[] nums){
        if(nums.length == list.size()){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            list.add(nums[i]);
            visited[i] = true;
            helper(res, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}