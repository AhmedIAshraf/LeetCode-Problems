class Solution {
    public void rotate(int[][] matrix) {

        Stack<Integer> stk = new Stack<>();
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                stk.push(matrix[i][j]);
            }
        }

        for (int i=0; i<m; i++){
            for (int j=n-1; j>=0; j--){
                matrix[j][i] = stk.pop();
            }
        }

    }
}