package Permutations;

import java.util.*;

class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 1) return res;
        helper(res, new ArrayList<>(), new boolean[nums.length], nums);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, boolean[] visited, int[] nums){
        if(nums.length == list.size()){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            list.add(nums[i]);
            System.out.println(list);
            visited[i] = true;
            helper(res, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
}