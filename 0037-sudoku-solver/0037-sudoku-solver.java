class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(0, 0, board);
    }
    private boolean backtrack(int row, int col, char[][] board){
        // base case
        if(col == 9){
            row = row+1;
            col = 0;
        }
        if(row == 9){
            return true;
        }

        // if already filled 
        if(board[row][col] != '.'){
            return backtrack(row, col+1, board);
        }

        for(int d=1; d<=9; d++){
            // (d + '0') -> Give ascii value
            char digit = (char)(d + '0');

            if(isPlacementPossible(digit, row, col, board)){
                board[row][col] = digit;
                // this means agar base case hit kr lega tb hi 'true' return hoga 
                if(backtrack(row, col+1, board)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    private boolean isPlacementPossible(char digit, int row, int col, char[][] board){
        for(int j=0; j<9; j++){
            // current row
            if(board[row][j] == digit){
                return false;
            }

            // current col
            if(board[j][col] == digit){
                return false;
            }

            // Grid
            int r = 3*(row/3) + j/3;
            int c = 3*(col/3) + j%3;
            if(board[r][c] == digit){
                return false;
            }
        }
        return true;
    }
}