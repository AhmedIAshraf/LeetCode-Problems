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

    class nodeWithCurrIndex{
        TreeNode node;
        int i;

        nodeWithCurrIndex(TreeNode node, int i){
            this.node = node;
            this.i = i;
        }
    } 

    public TreeNode recoverFromPreorder(String traversal) {
        nodeWithCurrIndex tree = constructTree(traversal.split("-"), 0, 0);
        return tree.node;
    }

    nodeWithCurrIndex constructTree(String[] traversal, int level, int i){

        TreeNode node = new TreeNode(Integer.parseInt(traversal[i]));
        if (i == traversal.length-1){
            return new nodeWithCurrIndex(node, i);
        }
        
        int j = i+1;
        int n = traversal.length;
        while (j < n && traversal[j].equals("")){
            j++;
        }

        if (level == j-i-1 && j<n){
            nodeWithCurrIndex left = constructTree(traversal, level+1, j);
            node.left = left.node;
            i = left.i;
        }
        else {
            return new nodeWithCurrIndex(node, i);
        }

        j = i+1;
        while (j < n && traversal[j].equals("")){
            j++;
        }

        if (level == j-i-1 && j<n){
            nodeWithCurrIndex right = constructTree(traversal, level+1, j);
            node.right = right.node;
            i = right.i;
        }

        return new nodeWithCurrIndex(node, i);
    }
}