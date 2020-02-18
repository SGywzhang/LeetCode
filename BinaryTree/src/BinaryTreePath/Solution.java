package BinaryTreePath;

import Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, res, "");
        return res;
    }

    private void helper(TreeNode root, List<String> res, String path){
        if(root == null) return;
        if(root.left == null && root.right==null){
            res.add(path + root.val);
            return;
        }

        if(root.left != null){
            String temp = path + root.val + "->";
            helper(root.left, res, temp);
        }
        if(root.right != null){
            String temp = path + root.val + "->";
            helper(root.right, res, temp);
        }
    }
}
