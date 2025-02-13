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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        rightView(root, -1, 0, nodes);
        return nodes;
    }
    
    public int rightView (TreeNode node, int maxDepth, int currDepth, List<Integer> nodes){
        
        if (node == null){
            return 0;
        }
        if (currDepth > maxDepth){
            nodes.add(node.val);
            maxDepth = currDepth;
        }

        int maxRightDepth = rightView (node.right, maxDepth, currDepth+1, nodes);
        maxDepth = Math.max(maxDepth, maxRightDepth);
        int maxLeftDepth = rightView (node.left, maxDepth, currDepth+1, nodes);
        maxDepth = Math.max(maxDepth, maxLeftDepth);

        return maxDepth;

    }
}