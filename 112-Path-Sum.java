/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
       if (root == null) return false;
       return checkSumTraversal(root, targetSum); 
    }

    public boolean checkSumTraversal(TreeNode node, int sum){
        if (node == null){
            return false;
        }

        sum -= node.val;
        if (sum == 0 && node.right == null && node.left ==null){
            return true;
        }

        return checkSumTraversal(node.left, sum) 
        || checkSumTraversal(node.right, sum);
    }
}