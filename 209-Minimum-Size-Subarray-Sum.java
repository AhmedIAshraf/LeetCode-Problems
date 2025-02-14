class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int l=0;
        int n = nums.length;
        int minSub = Integer.MAX_VALUE;
        int currentSum = 0;

        for(int i=0; i<n; i++){
            currentSum += nums[i];
            if (currentSum >= target){
                while (l <= i && currentSum - nums[l] >= target){
                    currentSum -= nums[l++];
                }
                minSub = Math.min(minSub, i-l+1);
            }
        }

        return minSub == Integer.MAX_VALUE ? 0 : minSub;
    }
}