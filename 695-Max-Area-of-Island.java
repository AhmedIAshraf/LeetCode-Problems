class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int maxArea = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    maxArea = Math.max(maxArea, visitIsland(grid, visited, i, j, 0));
                }
            }
        }

        return maxArea;
    }

    public int visitIsland(int[][] grid, boolean[][] visited, int i, int j, int area){
        
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return area;
        }
        if (grid[i][j] == 0 || visited[i][j]){
            return area;
        }

        visited[i][j] = true;
        int maxArea = area + 1;
        maxArea = Math.max(maxArea, visitIsland(grid, visited, i+1, j, maxArea));
        maxArea = Math.max(maxArea, visitIsland(grid, visited, i-1, j, maxArea));
        maxArea = Math.max(maxArea, visitIsland(grid, visited, i, j+1, maxArea));
        maxArea = Math.max(maxArea, visitIsland(grid, visited, i, j-1, maxArea));

        return maxArea;
    }
}
