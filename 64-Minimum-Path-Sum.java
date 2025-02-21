class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] sum = new int[n][m];
        
        return minPath(grid, 0, 0, sum, 0);
    }

    int minPath(int[][] grid, int i, int j, int[][] sum, int cost){
        if (i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        else if (i>=grid.length || j>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if (sum[i][j] > 0){
            return sum[i][j];
        }


        int right = minPath(grid, i, j+1, sum, cost);
        int down = minPath(grid, i+1, j, sum, cost);
        sum[i][j] = grid[i][j] + Math.min(right, down); 
        return sum[i][j];
    }
}