class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n-1] > 0){
            return Math.max(nums[0]*nums[1], nums[n-2]*nums[n-3]) * nums[n-1];
        }
        else{
            return nums[n-1]*nums[n-2]*nums[n-3];
        }
    }
}