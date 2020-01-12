package ConvertSortedArrayToBinarySearchTree;

import Node.TreeNode;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length -1, nums);
    }

    public TreeNode helper(int left, int right, int[] nums){
        if(left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(left, mid - 1, nums);
        node.right = helper(mid + 1, right, nums);
        return node;
    }
}