package BinaryTreeRightSideView;

import Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, res, 0);
        return res;
    }

    void helper(TreeNode root, List<Integer> res, int level){
        if(root == null) return;
        if(level == res.size()){
            res.add(root.val);
        }
        helper(root.right, res, level + 1);
        helper(root.left, res, level + 1);
    }
}
