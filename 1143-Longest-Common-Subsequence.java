class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n = text1.length();
        int m = text2.length();
        int[][] lcms = new int[n+1][m+1];

        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    lcms[i][j] = lcms[i-1][j-1]+1;
                }
                else{
                    lcms[i][j] = Math.max(lcms[i][j-1], lcms[i-1][j]);
                }
            }
        }

        return lcms[n][m];

    }
}