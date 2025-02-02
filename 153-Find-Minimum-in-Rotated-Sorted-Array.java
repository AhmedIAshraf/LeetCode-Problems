class Solution {
    public int findMin(int[] nums) {
        int l=0, r=nums.length-1;
        while (r > l){
            int m = (r+l)/2;
            if (nums[l] < nums[r]){
                return nums[l];
            }
            else if (nums[m] >= nums[l]){
                l = m+1;
            }
            else{
                r = m;
            }
        }
        return nums[l];
    }
}