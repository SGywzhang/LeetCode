package Subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int k;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        for(k = 0; k < nums.length + 1; k++){
            dfs(nums,0,new ArrayList<>());
        }
        return res;
    }
    void dfs(int[] nums, int index, ArrayList<Integer> list){
        if(list.size() == k){
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = index; i < nums.length; i++){
            list.add(nums[i]);
            dfs(nums,i+1,list);
            list.remove(list.size() - 1);
        }
    }
}


