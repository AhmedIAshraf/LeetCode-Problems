class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int n = nums.size();
        int toSwapPtr=n-1;
        int valPtr=0;
        while(valPtr<=toSwapPtr){
            while(toSwapPtr>=0 && nums[toSwapPtr]==val){
                toSwapPtr--;
            }
            while(valPtr<n && nums[valPtr]!=val){
                valPtr++;
            }
            if (toSwapPtr<0)
                return 0;
            if (valPtr>=n)
                return n;
            if (valPtr<toSwapPtr){
                swap(nums[toSwapPtr], nums[valPtr]);
            }
        }
        return toSwapPtr+1;
;    }
};