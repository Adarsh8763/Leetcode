class Solution {
    int rows;
    int cols;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        // boolean[][] visited = new boolean[rows][cols];

        dfs(sr, sc, image, color, image[sr][sc]);

        return image;
    }
    private void dfs(int row, int col, int[][] image, int newColor, int currColor){
        if(row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] == newColor || image[row][col] != currColor){
            return;
        }
        // visited[row][col] = true;
        image[row][col] = newColor;

        int[][] adj = {{row-1, col}, {row, col+1}, {row+1, col}, {row, col-1}};

        // if after increasing or decreasing row/col if idx out of bound hua tb dfs call hoga and dfs starting condition mei hi stop ho jyega
        for(int[] neighbour : adj){
            //Jo starting node ka color h wo chalta aayega aur aise hi dfs mei bhejata rahega
            dfs(neighbour[0], neighbour[1], image, newColor, currColor);
        }
    }
}