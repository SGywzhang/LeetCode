package UniqueBSTII;

import Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if(n == 0) return res;
        return helper(1,n);
    }

    List<TreeNode> helper(int start, int end){

        List<TreeNode> list =  new ArrayList<>();

        if(start > end){
            list.add(null);
            return list;
        }

        for(int i = start; i <= end; i++){
            List<TreeNode> leftNodes = helper(start, i - 1);
            List<TreeNode> rightNodes = helper(i + 1, end);
            for(TreeNode left : leftNodes){
                for(TreeNode right : rightNodes){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}