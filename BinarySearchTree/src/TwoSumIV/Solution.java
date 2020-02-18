package TwoSumIV;

import Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        List<Integer> list = new ArrayList<>();
        inorder(list, root);
        int i = 0;
        int j = list.size() - 1;
        while(i < j){
            if(list.get(i) + list.get(j) == k) return true;
            else if(list.get(i) + list.get(j) < k){
                i++;
            }
            else{
                j--;
            }

        }
        return false;
    }

    private void inorder(List<Integer> list, TreeNode root){
        if(root == null) return;
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }

}
