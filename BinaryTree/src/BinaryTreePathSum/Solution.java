package BinaryTreePathSum;

import Node.TreeNode;

class Solution {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}