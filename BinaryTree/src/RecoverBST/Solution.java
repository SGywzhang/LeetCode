package RecoverBST;

import Node.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorderHelper(root, list1, list2);
        Collections.sort(list2);
        for(int i = 0; i < list2.size(); i++){
            list1.get(i).val = list2.get(i);
        }
    }

    public void inorderHelper(TreeNode root, List<TreeNode> list1, List<Integer> list2){
        if(root == null) return;
        inorderHelper(root.left, list1, list2);
        list1.add(root);
        list2.add(root.val);
        inorderHelper(root.right, list1, list2);
    }
}