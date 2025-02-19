import java.util.Hashtable;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Hashtable<Integer, Boolean>[] rows = new Hashtable[9];
        Hashtable<Integer, Boolean>[] cols = new Hashtable[9];
        Hashtable<Integer, Boolean>[] blocks = new Hashtable[9];

        for (int i=0; i<9; i++){
            rows[i] = new Hashtable<>();
            cols[i] = new Hashtable<>();
            blocks[i] = new Hashtable<>();
        }

        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (!Character.isDigit(board[i][j])){
                    continue;
                }

                boolean exists = rows[i].containsKey(board[i][j]-'0') ||
                                cols[j].containsKey(board[i][j]-'0') ||
                                blocks[3*(i/3) + j/3].containsKey(board[i][j]-'0');

                if (exists){
                    return false;
                }
                else{
                    rows[i].put(board[i][j]-'0', true);
                    cols[j].put(board[i][j]-'0', true);
                    blocks[3*(i/3) + j/3].put(board[i][j]-'0', true);
                }
            }
        }

        return true;

    }
}