class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        priority_queue <int> pq;
        int mn=INT_MAX, mx=INT_MIN, l=0;
        for (int i=0;i<nums.size();i++){
            bool re = false;
            mn = min(mn, nums[i]);
            mx = max(mx, nums[i]);
            while (mx-mn>limit && l<=i){
                if(nums[l]==mx) mx=nums[l+1];
                else if(nums[l]==mn) mn=nums[l+1];
                l++; re=true;
            }
            if (re){
                for (int k=l; k<=i; k++){
                    mn = min(mn, nums[k]);
                    mx = max(mx, nums[k]);
                }
            }
            if (mx-mn<=limit) pq.push(i-l+1);
        }
        return pq.top();
    }
};