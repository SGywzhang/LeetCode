package BinarySearchTreeIterator;

import Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class BSTIterator {
    private List<Integer> list;
    private int count;

    private void inorderTraversal (TreeNode root, List<Integer> list){
        if(root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorderTraversal(root, list);
    }


    /** @return the next smallest number */
    public int next() {
        return list.get(count++);
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(count < list.size()) return true;
        return false;
    }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */