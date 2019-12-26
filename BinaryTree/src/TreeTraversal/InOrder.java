package TreeTraversal;

import Node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> s = new Stack<>();

        TreeNode temp = root;

        while(!s.empty() || temp != null){
            while(temp != null){
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            list.add(temp.val);
            temp = temp.right;
        }
        return list;
    }
}