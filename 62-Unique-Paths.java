class Solution {
    public int uniquePaths(int m, int n) {

        int[][] numberOfPossiblePath = new int[m][n];
        numberOfPossiblePath[m-1][n-1] = 1;

        for (int i=m-1; i>=0; i--){
            for (int j=n-1; j>=0; j--){
                if (i==m-1 && j==n-1){
                    continue;
                }
                
                int waysByGoingRight = (j+1 < n) ? numberOfPossiblePath[i][j+1] : 0;
                int waysByGoingDown = (i+1 < m) ? numberOfPossiblePath[i+1][j] : 0;
                numberOfPossiblePath[i][j] = waysByGoingRight + waysByGoingDown;  
            }
        }

        return numberOfPossiblePath[0][0];
    }
}
