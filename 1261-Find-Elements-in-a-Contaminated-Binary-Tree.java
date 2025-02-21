import java.util.Hashtable;

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
class FindElements {

    TreeNode head;
    Hashtable<Integer, Boolean> elems;

    public FindElements(TreeNode root) {
        elems = new Hashtable<>();
        head = recoverTree(root, 0);
    }

    TreeNode recoverTree(TreeNode node, int value){
        if (node == null){
            return null;
        }

        node.val = value;
        elems.put(value, true);
        recoverTree(node.left, 2*value+1);
        recoverTree(node.right, 2*value+2);
        
        return node;
    }
    
    public boolean find(int target) {
        return elems.containsKey(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
