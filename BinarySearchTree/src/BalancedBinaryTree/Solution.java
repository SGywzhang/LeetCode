package BalancedBinaryTree;

import Node.TreeNode;

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth (TreeNode node){
        if(node == null) return 0;
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }
}
