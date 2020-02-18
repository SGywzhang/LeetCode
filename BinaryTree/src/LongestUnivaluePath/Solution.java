package LongestUnivaluePath;

import Node.TreeNode;

class Solution {
    int max;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root);
        return max;
    }

    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int leftPath = (root.left != null && root.left.val == root.val) ? left : 0;
        int rightPath = (root.right != null && root.right.val == root.val) ? right: 0;
        max = Math.max(leftPath + rightPath, max);
        return Math.max(leftPath, rightPath) + 1;
    }
}
