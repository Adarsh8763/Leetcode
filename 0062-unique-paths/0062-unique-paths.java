// ======= Recursion =======
// class Solution {
//     public int uniquePaths(int m, int n) {
//         return recur(m-1, n-1);
//     }
//     private int recur(int m, int n){
//         if(m == 0 && n == 0){
//             return 1;
//         }
//         else if(m<0 || n<0){
//             return 0;
//         }

//         int ways = recur(m-1, n) + recur(m, n-1);
//         return ways;
//     }
// }

// ========= Memoization ========
// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m+1][n+1];
//         for(int i=0; i<=m; i++){
//             Arrays.fill(dp[i], -1);
//         }

//         return recur(m, n, dp);
//     }
//     private int recur(int m, int n, int[][] dp){
//         if(m == 1 && n == 1){
//             dp[m][n] = 1;
//             return dp[m][n];
//         }
//         else if(m == 0 || n == 0){
//             dp[m][n] = 0;
//             return dp[m][n];
//         }

//         if(dp[m][n] != -1){
//             return dp[m][n];
//         }

//         int ways = recur(m-1, n, dp) + recur(m, n-1, dp);
//         dp[m][n] = ways;

//         return dp[m][n];
//     }
// }


// ========= Tabulation =========
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            dp[i][0] = 0;
        }

        for(int j=0; j<=n; j++){
            dp[0][j] = 0;
        }

        dp[1][1] = 1;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(i == 1 && j == 1){
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}