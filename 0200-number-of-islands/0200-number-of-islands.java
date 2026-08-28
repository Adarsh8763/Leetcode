class Solution {
    int rows;
    int cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int islands = 0;

        boolean[][] visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(grid, visited, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void dfs(char[][] grid, boolean[][] visited, int row, int col){
        if(row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || grid[row][col] == '0'){
            return;
        }
        visited[row][col] = true;

        int[][] adj = {{row-1, col}, {row, col+1}, {row+1, col}, {row, col-1}};
        for(int[] neighbour : adj){
            int r = neighbour[0];
            int c = neighbour[1];
            dfs(grid, visited, r, c);
        }
    }
}