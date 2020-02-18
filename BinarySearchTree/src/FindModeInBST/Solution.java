package FindModeInBST;

import Node.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    int max = Integer.MIN_VALUE;
    Map<Integer, Integer> map;
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        map = new HashMap<>();
        inorder(root);
        List<Integer> list = new ArrayList<>();
        for(Integer key : map.keySet()){
            if(map.get(key) == max){
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }

    private void inorder(TreeNode root){
        if(root == null) return;
        map.put(root.val, map.getOrDefault(root.val,0) + 1);
        max = Math.max(map.get(root.val), max);
        inorder(root.left);
        inorder(root.right);
    }
}
