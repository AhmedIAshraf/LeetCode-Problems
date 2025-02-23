class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        int max = -1;
        int memo[] = new int[n+1];

        for (int i=1; i<=n; i++){
            int robCurrent = nums[i-1];
            if (i > 1){
                robCurrent += memo[i-2];
            }
            memo[i] = Math.max(robCurrent, memo[i-1]);
        }

        return memo[n];
    }
}