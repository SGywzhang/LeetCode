package DeleteNodeInBST;

import Node.TreeNode;

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val >  key){
            root.left = deleteNode(root.left,key);
        }
        else if(root.val < key){
            root.right =  deleteNode(root.right,key);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            TreeNode min = findRightMinNode(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }
        return root;
    }

    TreeNode findRightMinNode(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}

