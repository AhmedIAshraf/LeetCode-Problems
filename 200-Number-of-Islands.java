class Solution {

    public int numIslands(char[][] grid) {
        int num=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    num++;
                    dfs(grid,i,j);
                }
            }
        }
        return num;
    }
    
    void dfs(char[][] g, int i, int j){

        if (g[i][j]=='0') return;
        g[i][j]='0';

        if (j<g[0].length-1) dfs(g,i,j+1);
        
        if (i<g.length-1) dfs(g,i+1,j);

        if (j>0) dfs(g,i,j-1);
        
        if (i>0) dfs(g,i-1,j);
    }

}