package BinaryTreeMaximumPathSum;

import Node.TreeNode;

class Solution {
    int max;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    int dfs(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        max = Math.max(max, root.val + left + right);
        return Math.max(left, right) + root.val;
    }
}