class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int[] aggCost = new int[n];
        aggCost[n-1] = cost[n-1];
        aggCost[n-2] = cost[n-2];

        for (int i=n-3; i>=0; i--){
            aggCost[i] = Math.min(aggCost[i+1], aggCost[i+2]);
            aggCost[i] += cost[i];
        }
        
        return Math.min(aggCost[0], aggCost[1]);

    }
}