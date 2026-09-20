class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        int freshOrg = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    freshOrg++;
                }
            }
        }

        // If there is no freshOrange
        if(freshOrg == 0){
            return 0;
        }

        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int[] rotOrg = q.poll(); 
                int r = rotOrg[0];
                int c = rotOrg[1];
                int[][] neighbours = {{r-1, c}, {r, c+1}, {r+1, c}, {r, c-1}};
                for(int[] neighbour : neighbours){
                    int nr = neighbour[0];
                    int nc = neighbour[1];
                    if(nr<0 || nr>=m || nc<0 || nc>=n || grid[nr][nc] == 2 || grid[nr][nc] == 0){
                        continue;
                    }
                    q.offer(new int[]{nr, nc});
                    grid[nr][nc] = 2;
                }
            }
            time++;
            freshOrg -= q.size();
            if(freshOrg == 0){
                return time;
            }
        }
        return -1;
    }
}