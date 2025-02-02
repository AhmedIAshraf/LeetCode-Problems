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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagOrder = new ArrayList<>();
        zigzagTraversal(root, zigzagOrder, 0);
        return zigzagOrder;
    }

    public void zigzagTraversal(TreeNode node, List<List<Integer>> list, int level){
        if (node == null) 
            return;
        if (list.size() <= level)
            list.add(new ArrayList<Integer>());
        
        if (level % 2 == 0){
            list.get(level).add(0, node.val);
        }
        else{
            list.get(level).add(node.val);
        }

        zigzagTraversal(node.right, list, level+1);
        zigzagTraversal(node.left, list, level+1);
        // Right then left is a must so that the right child initiates the list as we only control
        // the position of the left child.
    }
}