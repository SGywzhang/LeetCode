package BinaryTreeZigzagLevelOrderTraversal;

import Node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        boolean leftToRight = true;
        while(!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            for(int i = 0; i < size; i++){

                if(leftToRight){
                    TreeNode cur = deque.pollFirst();
                    list.add(cur.val);
                    if(cur.left != null) deque.addLast(cur.left);
                    if(cur.right != null) deque.addLast(cur.right);
                }
                else{
                    TreeNode cur = deque.pollLast();
                    list.add(cur.val);
                    if(cur.right != null) deque.addFirst(cur.right);
                    if(cur.left != null) deque.addFirst(cur.left);
                }
            }
            leftToRight = !leftToRight;
            res.add(list);
        }
        return res;
    }
}