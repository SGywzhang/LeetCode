package CombinationSumII;

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, 0, new ArrayList<Integer>(), target, candidates,new boolean[candidates.length]);
        return res;
    }

    void helper(List<List<Integer>> res, int start, List<Integer> list, int target, int[] candidates,boolean[] visited){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(visited[i]) continue;
            if(i > 0 && candidates[i - 1] == candidates[i] && !visited[i - 1]) continue;
            visited[i] = true;
            list.add(candidates[i]);
            helper(res, i + 1, list, target - candidates[i], candidates, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}