package Permutations;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new LinkedList<>();

        dfsHelper(res, nums, new HashSet<>(), new LinkedList<>());

        return res;
    }

    public static void dfsHelper(List<List<Integer>> res, int[] nums, Set<Integer> hashSet, List<Integer> list) {

        if (nums.length == hashSet.size()) {
            res.add(new LinkedList<>(list));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!hashSet.contains(nums[i])) {
                    hashSet.add(nums[i]);
                    list.add(nums[i]);
                    int last = list.size() - 1;
                    dfsHelper(res, nums, hashSet, list);
                    hashSet.remove(nums[i]);
                    list.remove(last);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}