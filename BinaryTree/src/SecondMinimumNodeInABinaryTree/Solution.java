package SecondMinimumNodeInABinaryTree;

import Node.TreeNode;

import java.util.PriorityQueue;

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return -1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        preorderTraversal(root, minHeap);
        int first = minHeap.poll();
        while(!minHeap.isEmpty() && first == minHeap.peek()){
            first = minHeap.poll();
        }
        return  minHeap.isEmpty() ? -1 : minHeap.peek();
    }

    private void preorderTraversal(TreeNode root, PriorityQueue<Integer> minHeap){
        if(root == null) return;
        minHeap.offer(root.val);
        preorderTraversal(root.left, minHeap);
        preorderTraversal(root.right, minHeap);
    }
}
