/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* bstToGst(TreeNode* root) {
        accumulate(root, 0);
        return root;
    }
    
    int accumulate(TreeNode* n, int sum){

        if (n->right != NULL) 
            sum = accumulate(n->right, sum);
        
        n->val += sum;
        sum = n->val ;

        if (n->left != NULL) 
            sum = accumulate(n->left, sum);

        return sum;
    }
};