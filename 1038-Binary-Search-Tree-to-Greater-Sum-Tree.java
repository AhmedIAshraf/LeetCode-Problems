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
    public TreeNode bstToGst(TreeNode root) {
        greaterSum(root,0);
        return root;
    }

    public int greaterSum(TreeNode n, int sum){

        if (n.right!=null){
            sum=greaterSum(n.right,sum);
        }

        sum+=n.val;
        n.val=sum;

        if (n.left!=null){
            sum=greaterSum(n.left,sum);
        }

        return sum;
    }
}