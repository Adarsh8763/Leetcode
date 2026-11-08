class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] count = new int[1];
        int sum = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    dfs(i, j, grid, count);
                    if(count[0] != 1){
                        sum += count[0];
                    }
                    count[0] = 0;
                }
                else if(grid[i][j] == 0){
                    grid[i][j] = 2;
                }
            }
        }
        return sum;
    }
    private void dfs(int r, int c, int[][] grid, int[] count){
        // if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length){
        //     return;
        // }
        grid[r][c] = 2;
        count[0]++;

        for(int i=0; i<grid.length; i++){
            if(grid[i][c] == 1){
                dfs(i, c, grid, count);
            }
            else if(grid[i][c] == 0){
                grid[i][c] = 2;
            }
        }
        for(int j=0; j<grid[0].length; j++){
            if(grid[r][j] == 1){
                dfs(r, j, grid, count);
            }
            else if(grid[r][j] == 0){
                grid[r][j] = 2;
            }
        }
    }
}