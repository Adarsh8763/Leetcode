class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }

        List<List<String>> res = new ArrayList<>();
        backtrack(0, board, res);
        return res;
    }
    private void backtrack(int col, char[][] board, List<List<String>> res){
        int n = board.length;
        if(col == n){
            constructRes(board, res);
            return;
        }

        // for each queen hm hmesha usko 0th row se start krenge upto n 
        for(int row=0; row<n; row++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                backtrack(col+1, board, res);
                board[row][col] = '.';
            }
        }
    }
    private boolean isSafe(char[][] board, int r, int c){
        for(int k=1; k<=c; k++){
            int col = c-k;

            // UD
            int row = r-k;
            // Aisa nhi ki subtract krne ke baad out of bound chal jye that's why we applied this check
            if(row >= 0){
                if(board[row][col] == 'Q'){
                    return false;
                }
            }
            // LD
            row = r+k;
            if(row < board.length){
                if(board[row][col] == 'Q'){
                    return false;
                }
            }

            //SR
            row = r;
            // Same row h that means jo bhi row hoga wo valid hi hoga so out of bound jane ka koi chance nhi h. Moreover, col to pahale hi handle ho ja rha h and we have to check only the row so here jo bhi row aaya hoga wo valid hi hoga 
            if(board[row][col] == 'Q'){
                return false;
            }

        }
        return true;
    }

    private void constructRes(char[][] board, List<List<String>> res){
        List<String> curr = new ArrayList<>();

        for(int i=0; i<board.length; i++){
            // Directly converts char array to String
            String row = new String(board[i]);
            curr.add(row);
        }
        res.add(curr);
    }
}