package TreeTraversal;

import Node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.addLast(root);

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.removeFirst();
                list.add(temp.val);
                if(temp.left != null) queue.addLast(temp.left);
                if(temp.right != null) queue.addLast(temp.right);
            }
            res.add(list);
        }
        return res;

    }
}