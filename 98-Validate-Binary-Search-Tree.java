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
    public boolean isValidBST(TreeNode root) {
        return checkerTraversal(root, (long) Integer.MIN_VALUE-1, (long) Integer.MAX_VALUE+1);
    }

    public boolean checkerTraversal(TreeNode node, long lowerBound, long upperBound){
        
        if (node == null){
            return true;
        }
        if (node.val <= lowerBound || node.val >= upperBound){
            return false;
        }

        return checkerTraversal(node.right, node.val, upperBound) 
            && checkerTraversal(node.left, lowerBound, node.val);
    }
}