class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int least = nums[0], r=0;
        for (int i=1; i<nums.size(); i++){
            if (nums[i]==nums[i-1]) r++, nums[i]++;
            else if (nums[i]<nums[i-1])  r+=nums[i-1]-nums[i]+1, nums[i]=nums[i-1]+1;
        }
        return r; 
    }
};
