package FindBottomLeftTreeValue;

import Node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(cur.right != null) queue.offer(cur.right);
            if(cur.left != null) queue.offer(cur.left);
        }
        return cur.val;
    }
}
