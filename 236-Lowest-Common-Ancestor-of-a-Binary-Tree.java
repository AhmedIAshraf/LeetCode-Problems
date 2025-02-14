/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root, p, q);
    }

    public TreeNode LCA(TreeNode node, TreeNode p, TreeNode q){
        
        if (node == null){
            return null;
        } 
        if (node == p || node == q){
            return node;
        }

        TreeNode right = LCA(node.right, p, q);
        TreeNode left = LCA(node.left, p, q);
        
        if (right != null && left != null){
            return node;
        }
        else if (right != null){
            return right;
        }
        else if (left != null){
            return left;
        }
        return null;


    }
}