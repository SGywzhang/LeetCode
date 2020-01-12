package DiameterOfBinaryTree;

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
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}