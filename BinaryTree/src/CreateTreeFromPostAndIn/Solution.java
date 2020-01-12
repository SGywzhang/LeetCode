package CreateTreeFromPostAndIn;

import Node.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode helper(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight){
        if(inLeft > inRight || postLeft > postRight) return null;
        else{
            TreeNode cur = new TreeNode(postorder[postRight]);
            int i = inLeft;
            while(i <= inRight){
                if(postorder[postRight] == inorder[i]) break;
                i++;
            }
            cur.left = helper(inorder, inLeft, i - 1, postorder, postLeft, i - inLeft + postLeft - 1);
            cur.right = helper(inorder, i + 1, inRight, postorder, i - inLeft + postLeft, postRight - 1);
            return cur;
        }
    }
}