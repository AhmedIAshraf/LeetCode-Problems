class Solution {
public:

    pair<int, int> recurse (vector<int>& v, int l, int r){
        if (l==r) return {v[l], 1};
        int m = (r+l)/2; 
        pair<int, int> left, right;
        left = recurse (v, l, m);
        right = recurse (v, m+1, r);
        if (left.first == right.first) return {left.first, left.second+right.second};
        if (left.second > right.second) return left;
        else if (left.second < right.second) return right;
        else return {left.first, 0};
    }

    int majorityElement(vector<int>& nums) {
        return recurse(nums, 0, nums.size()-1).first;
    }
};