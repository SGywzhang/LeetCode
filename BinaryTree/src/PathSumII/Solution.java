package PathSumII;

import Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), sum, root);
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> temp, int sum, TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(root.val == sum){
                temp.add(root.val);
                res.add(new ArrayList<Integer>(temp));
                temp.remove(temp.size() - 1);
            }
            return;
        }
        temp.add(root.val);
        dfs(res, temp, sum - root.val, root.left);
        dfs(res, temp, sum - root.val, root.right);
        temp.remove(temp.size() - 1);
    }
}
