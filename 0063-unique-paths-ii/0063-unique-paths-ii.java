// // ========= Memoization ========
// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;

//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 0; i <= m; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return recur(m, n, obstacleGrid, dp);
//     }

//     private int recur(int m, int n, int[][] obstacleGrid, int[][] dp) {
//         if (m == 1 && n == 1) {
//             dp[m][n] = 1;
//             return dp[m][n];
//         } 
//         else if (m == 0 || n == 0) {
//             dp[m][n] = 0;
//             return dp[m][n];
//         }
//         else if(obstacleGrid[m-1][n-1] == 1){
//             return 0;
//         }

//         if (dp[m][n] != -1) {
//             return dp[m][n];
//         }

//         int ways = recur(m - 1, n, obstacleGrid, dp) + recur(m, n - 1, obstacleGrid, dp);
//         dp[m][n] = ways;

//         return dp[m][n];
//     }
// }


// ========= Tabulation with space optimization =========
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] prev = new int[n+1];

        for(int j=0; j<=n; j++){
            prev[j] = 0;
        }

        for(int i=1; i<=m; i++){
            int[] curr = new int[n+1];
            curr[0] = 0;
            
            for(int j=1; j<=n; j++){
                if(i == 1 && j == 1 && obstacleGrid[i-1][j-1] != 1){
                    curr[1] = 1;
                }
                else if(obstacleGrid[i-1][j-1] == 1){
                    curr[j] = 0;
                }
                else{
                    curr[j] = prev[j] + curr[j-1];
                }
            }
            prev = curr;
        }
        return prev[n];
    }
}


