package InsertIntoBST;

import Node.TreeNode;

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
        }
        helper(root, val);
        return root;
    }
    public void helper(TreeNode root, int val){
        if(root == null) return;
        if(root.val < val){
            if(root.right == null){
                root.right = new TreeNode(val);
            }
            else{
                helper(root.right,val);
            }
        }
        else{
            if(root.left == null){
                root.left = new TreeNode(val);
            }
            else{
                helper(root.left,val);
            }
        }
    }
}