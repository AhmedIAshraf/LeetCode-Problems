class Solution {
    int[][] dp;
    int r,c;
    public int uniquePaths(int m, int n) {
        r=m;
        c=n;
        dp = new int[m][n];
        return numberOfPaths(0,0);
    }
    
    public int numberOfPaths(int i, int j){
        if (i==r||j==c) return 0;
        if (dp[i][j]!=0) return dp[i][j];
        if (i==r-1 && j==c-1) return 1;
        int r1=0,r2=0;

        r1 += numberOfPaths(i+1,j);
        r2 += numberOfPaths(i,j+1);

        return dp[i][j]=r1+r2;
    }
}