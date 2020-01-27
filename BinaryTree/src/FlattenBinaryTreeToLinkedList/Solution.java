package FlattenBinaryTreeToLinkedList;

import Node.TreeNode;

import java.util.Stack;

class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.right != null){
                stack.push(cur.right);
            }

            if(cur.left != null){
                stack.push(cur.left);
            }

            if(!stack.isEmpty()){
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }
}