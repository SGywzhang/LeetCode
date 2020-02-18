package ConvertBSTToGreaterTree;

import Node.TreeNode;

class Solution {
    int sum;
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            sum+= root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}