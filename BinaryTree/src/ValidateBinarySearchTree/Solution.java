package ValidateBinarySearchTree;

import Node.TreeNode;

import java.util.ArrayList;
import java.util.List;



class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root,list);
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) >= list.get(i + 1)){
                return false;
            }
        }
        return true;
    }
    public void inorderTraversal(TreeNode root, List<Integer> list){
        if(root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}