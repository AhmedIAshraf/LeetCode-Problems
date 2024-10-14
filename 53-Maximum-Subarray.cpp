class Solution {
public:

    int maxCrossSum(vector<int>&v, int l, int r){
        int m = (l+r)/2;
        int sum = 0, leftSum = INT_MIN;
        for (int i=m;i>=l;i--){
            sum += v[i];
            if (sum>leftSum) leftSum=sum;
        }
        int rightSum = INT_MIN;
        sum = 0;
        for (int i=m+1;i<=r;i++){
            sum += v[i];
            if (sum>rightSum) rightSum=sum;
        }
        return leftSum+rightSum;
    }

    int maxSubArray(vector<int>&v, int l, int r){
        if (l==r) return v[l];
        int m=(l+r)/2;
        int leftSum = maxSubArray(v, l, m);
        int rightSum = maxSubArray(v, m+1, r);
        int crossSum = maxCrossSum(v,l,r);
        return max(crossSum, max(leftSum, rightSum));
    }

    int maxSubArray(vector<int>& nums) {
        return maxSubArray(nums, 0, nums.size()-1);
    }
};