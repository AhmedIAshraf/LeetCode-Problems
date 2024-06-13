class Solution {
public:
    void sortColors(vector<int>& nums) {
        int l=0,r=nums.size()-1;
        for (int i=0;i<=r;i++){
            if (nums[i]==0) {
                nums[i]=nums[l];
                nums[l++]=0;
            }
            else if (nums[i]==2) {
                nums[i--]=nums[r];
                nums[r--]=2;
            }
        }
    }
};