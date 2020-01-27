package CheckCompletenessOfABinaryTree;

import Node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null){
                flag = true;
            }
            else{
                if(flag) return false;
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return true;
    }
}
