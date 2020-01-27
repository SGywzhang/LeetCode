package CombinationSum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, 0, new ArrayList<Integer>(), target, candidates);
        return res;
    }

    void helper(List<List<Integer>> res, int start, List<Integer> list, int target, int[] candidates){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            helper(res, i, list, target - candidates[i], candidates);
            list.remove(list.size() - 1);
        }
    }
}