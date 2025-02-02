import java.util.Hashtable;

class Solution {
    public void setZeroes(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        Hashtable<Integer, Boolean> rows = new Hashtable<>();
        Hashtable<Integer, Boolean> cols = new Hashtable<>();
        
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (matrix[i][j] == 0){
                    rows.put(i, true);
                    cols.put(j, true);
                }
            }
        }

        for (int r : rows.keySet()){
            clearRow(matrix, r);
        }
        for (int c : cols.keySet()){
            clearCol(matrix, c);
        }

    }

    public void clearRow(int[][] matrix, int row){
        int m = matrix[row].length;
        for (int i=0; i<m; i++)
            matrix[row][i] = 0;
    }
    public void clearCol(int[][] matrix, int col){
        int n = matrix.length;
        for (int i=0; i<n; i++)
            matrix[i][col] = 0;
    }
}