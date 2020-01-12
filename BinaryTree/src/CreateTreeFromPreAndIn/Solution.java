package CreateTreeFromPreAndIn;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0 , inorder.length -1);
    }

    public TreeNode helper(int[] preorder, int preLeft, int preRight,int[] inorder, int inLeft, int inRight){
        if(inLeft > inRight || preLeft > preRight) return null;
        else{

            TreeNode cur = new TreeNode(preorder[preLeft]);
            int i = 0;
            while(i <= inRight){
                if(preorder[preLeft] == inorder[i]) break;
                i++;
            }
            cur.left = helper(preorder, preLeft + 1, preLeft + i - inLeft, inorder, inLeft , i - 1);
            cur.right = helper(preorder, preLeft + i + 1 - inLeft, preRight, inorder, i + 1 , inRight);
            return cur;
        }
    }
}