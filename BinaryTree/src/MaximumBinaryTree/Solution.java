package MaximumBinaryTree;

import Node.TreeNode;

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    private TreeNode construct(int[] nums, int l, int r){
        if(l == r) return null;
        int maxIndex = getMax(nums, l, r);
        TreeNode cur = new TreeNode(nums[maxIndex]);
        cur.left = construct(nums,l, maxIndex);
        cur.right = construct(nums,maxIndex + 1, r);
        return cur;
    }

    private int getMax(int[] nums, int l, int r){
        int maxIndex = l;
        for(int i = l; i < r; i++){
            if(nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}