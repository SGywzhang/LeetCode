package BinaryTreeVerticalOrder;

import Node.TreeNode;

import javax.print.attribute.IntegerSyntax;
import java.util.*;

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        helper(root, map);
        return new ArrayList<>(map.values());
    }

    void helper(TreeNode root, Map<Integer, List<Integer>> map){
        if(root == null) return;
        Queue<Integer> orderQueue = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        orderQueue.offer(0);
        queue.offer(root);

        while(!queue.isEmpty()){
            int order = orderQueue.poll();
            TreeNode cur = queue.poll();

            List<Integer> list = map.get(order);
            if(list == null){
                list = new ArrayList<>();
                map.put(order, list);
            }
            list.add(root.val);

            if(root.left != null){
                queue.offer(root.left);
                orderQueue.offer(order - 1);
            }

            if(root.right != null){
                queue.offer(root.right);
                orderQueue.offer(order + 1);
            }
        }
    }
}
