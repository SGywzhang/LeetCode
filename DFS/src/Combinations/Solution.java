package Combinations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0 || k == 0) return res;
        helper(k, n, 1, res, new ArrayList<>());
        return res;
    }

    public void helper(int k, int n, int start, List<List<Integer>> res, List<Integer> cur){
        if(k == 0){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        else{
            for(int i = start; i <= n; i++){
                cur.add(i);
                helper(k-1, n, i + 1, res, cur);
                cur.remove(cur.size() -1);
            }
        }
    }
}