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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelTraversal(root, 0, ans);
        return ans;
    }

    public void levelTraversal(TreeNode node, int level, List<List<Integer>> levels){
        if (node == null) return;
        
        if (levels.size() <= level){
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(node.val);
        
        levelTraversal(node.left, level+1, levels);
        levelTraversal(node.right, level+1, levels);
    }
}