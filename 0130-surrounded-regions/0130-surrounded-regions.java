class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n]; 

        //Traverse 1st and last row
        for(int j=0; j<n; j++){
            //first row
            if(vis[0][j] == 0 && board[0][j] == 'O'){
                dfs(0, j, vis, board);
            }

            //last row
            if(vis[m-1][j] == 0 && board[m-1][j] == 'O'){
                dfs(m-1, j, vis, board);
            }
        }

        //Traverse 1st and last col
        for(int i=0; i<m; i++){
            //first col
            if(vis[i][0] == 0 && board[i][0] == 'O'){
                dfs(i, 0, vis, board);
            }

            //last col
            if(vis[i][n-1] == 0 && board[i][n-1] == 'O'){
                dfs(i, n-1, vis, board);
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

    private void dfs(int row, int col, int[][] vis, char[][] board){
        vis[row][col] = 1;

        int m = board.length;
        int n = board[0].length;

        //Check for top, right, bottom, left
        int[][] adj = {{row-1, col}, {row, col+1}, {row+1, col}, {row, col-1}};

        for(int[] neighbour : adj){
            int nRow = neighbour[0];
            int nCol = neighbour[1];

            if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0 && board[nRow][nCol] == 'O'){
                dfs(nRow, nCol, vis, board);
            }
        }
    }
}