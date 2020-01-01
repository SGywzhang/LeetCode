package TreeTraversal;

import Node.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {

        LinkedList<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        TreeNode temp = null;
        while(!s.empty()){
            temp = s.pop();

            list.addFirst(temp.val);

            if(temp.left != null){
                s.push(temp.left);
            }

            if(temp.right != null){
                s.push(temp.right);
            }
        }
        return list;
    }
}