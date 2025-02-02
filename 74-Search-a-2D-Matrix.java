class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        return findCol(matrix, target, row) != -1;
    }

    public int findRow(int[][] matrix, int t){
        int l=0, r=matrix.length-1;
        while(r > l){
            int m =(r+l)/2;
            if (matrix [m+1][0] == t)
                return m+1;
            else if (matrix[m][0] <= t && matrix[m+1][0] > t)
                return m;
            else if (matrix[m][0] > t)
                r = m-1;
            else
                l = m+1;
        }
        return l;
    }

    public int findCol(int[][] matrix, int t, int row){
        int l=0, r=matrix[row].length-1;
        while(r > l){
            int m =(r+l+1)/2;
            if (matrix[row][m] == t)
                return m;
            else if (matrix[row][m] > t)
                r = m-1;
            else
                l = m+1;
        }
        return (l == r && matrix[row][l] == t) ? l : -1;
    }
}