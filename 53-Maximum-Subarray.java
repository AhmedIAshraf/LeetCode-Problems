class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i=0; i<n; i++){
            if (sum + nums[i] > 0){
                sum += nums[i];
                max = Math.max(max, sum);
            }
            else{
                max = Math.max(max, sum + nums[i]);
                sum = 0;
            }
        }

        return max;
    }
}