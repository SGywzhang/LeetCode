package PathSumIII;

import Node.TreeNode;

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    int helper(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.val == sum){
            count++;
        }
        count += helper(root.left, sum - root.val);
        count += helper(root.right, sum - root.val);
        return count;
    }
}
