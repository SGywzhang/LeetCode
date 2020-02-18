package HouseRobberIII;

import Node.TreeNode;

class Solution {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int n1 = root.val;
        if(root.left != null) n1 += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) n1 += rob(root.right.left) + rob(root.right.right);
        int n2 = rob(root.left) + rob(root.right);
        return Math.max(n1, n2);
    }
}