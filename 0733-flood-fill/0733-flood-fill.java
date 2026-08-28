class Solution {
    // ===== DFS ======

    // int rows;
    // int cols;
    // public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    //     rows = image.length;
    //     cols = image[0].length;
    //     // boolean[][] visited = new boolean[rows][cols];

    //     dfs(sr, sc, image, color, image[sr][sc]);

    //     return image;
    // }
    // private void dfs(int row, int col, int[][] image, int newColor, int currColor){
    //     if(row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] == newColor || image[row][col] != currColor){
    //         return;
    //     }
    //     // visited[row][col] = true;
    //     image[row][col] = newColor;

    //     int[][] adj = {{row-1, col}, {row, col+1}, {row+1, col}, {row, col-1}};

    //     // if after increasing or decreasing row/col if idx out of bound hua tb dfs call hoga and dfs starting condition mei hi stop ho jyega
    //     for(int[] neighbour : adj){
    //         //Jo starting node ka color h wo chalta aayega aur aise hi dfs mei bhejata rahega
    //         dfs(neighbour[0], neighbour[1], image, newColor, currColor);
    //     }
    // }

    // ======= BFS =======
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        int currColor = image[sr][sc];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            int row = node[0];
            int col = node[1];

            image[row][col] = color;

            int[][] adj = {{row-1, col}, {row, col+1}, {row+1, col}, {row, col-1}};

            for(int[] neighbour : adj){
                int r = neighbour[0];
                int c = neighbour[1];

                if(r < 0 || r >= rows || c < 0 || c >= cols || image[r][c] == color || image[r][c] != currColor){
                    continue;
                }

                image[r][c] = color;
                queue.offer(new int[]{r, c});

            }
        }

        return image;
    }
}