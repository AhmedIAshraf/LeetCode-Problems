import java.util.Hashtable;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        int n = grid.length;
        int sum = 0;
        Hashtable<Integer, Boolean> exists = new Hashtable<>(); 
        int[] ans = new int[2];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (exists.containsKey(grid[i][j])){
                    ans[0] = grid[i][j];
                }
                else{
                    sum += grid[i][j];
                    exists.put(grid[i][j], true);
                }
            }
        }

        long nSquared = (long)Math.pow(n,2); 
        ans[1] = (int)((nSquared)*(nSquared+1)/2 - sum);
        return ans;
    }
}