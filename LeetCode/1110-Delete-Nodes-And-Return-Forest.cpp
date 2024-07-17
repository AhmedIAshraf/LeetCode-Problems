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

    vector<TreeNode*> ans;
    map<int, bool> mp;

    bool traverse(TreeNode* n, bool start){
        if (mp[n->val]){
            if (n->right){
                traverse(n->right, 1);
                n->right=NULL;
            }
            if (n->left){
                traverse(n->left, 1);
                n->left=NULL;
            }
            return true;
        }
        else{
            if (start) ans.push_back(n);
            if (n->right){
                if(traverse(n->right, 0)){
                    n->right=NULL;
                }
            }
            if (n->left){
                if(traverse(n->left, 0)){
                    n->left=NULL;
                }
            }
        }
        return false;
    }

    vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) {
        for (int i : to_delete) mp[i]=1;
        traverse(root, 1);
        return ans;
    }
};