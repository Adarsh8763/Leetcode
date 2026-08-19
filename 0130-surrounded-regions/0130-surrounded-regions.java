class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        int[][] vis = new int[m][n]; 

        //Traverse 1st and last row
        for(int j=0; j<n; j++){
            //first row
            if(vis[0][j] == 0 && board[0][j] == 'O'){
                dfs(0, j, vis, board, delRow, delCol);
            }

            //last row
            if(vis[m-1][j] == 0 && board[m-1][j] == 'O'){
                dfs(m-1, j, vis, board, delRow, delCol);
            }
        }

        //Traverse 1st and last col
        for(int i=0; i<m; i++){
            //first col
            if(vis[i][0] == 0 && board[i][0] == 'O'){
                dfs(i, 0, vis, board, delRow, delCol);
            }

            //last col
            if(vis[i][n-1] == 0 && board[i][n-1] == 'O'){
                dfs(i, n-1, vis, board, delRow, delCol);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col, int[][] vis, char[][] board, int[] delRow, int[] delCol){
        vis[row][col] = 1;

        int m = board.length;
        int n = board[0].length;

        //Check for top, right, bottom, left
        for(int i=0; i<4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0 && board[nRow][nCol] == 'O'){
                dfs(nRow, nCol, vis, board, delRow, delCol);
            }
        }
    }
}