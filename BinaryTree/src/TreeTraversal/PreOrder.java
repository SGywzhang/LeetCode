package TreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Node.TreeNode;



public class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.empty()){
            TreeNode temp = s.pop();
            list.add(temp.val);
            if(temp.right != null ){
                s.push(temp.right);
            }
            if(temp.left != null){
                s.push(temp.left);
            }
        }
        return list;
    }
}

