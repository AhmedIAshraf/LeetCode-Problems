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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        root = insert(root, val);
        return root;
    }

    public TreeNode insert(TreeNode node, int value){
        if (node == null){
            node = new TreeNode(value);
        }
        else if (value > node.val){
            node.right = insert(node.right, value);
        }
        else{
            node.left = insert(node.left, value);
        }
        return node;
    }
}