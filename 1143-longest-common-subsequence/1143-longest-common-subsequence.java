// ======== Recursion =========
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();

//         return recur(n-1, m-1, text1, text2);
//     }
//     private int recur(int i, int j, String text1, String text2){
//         if(i<0 || j<0){
//             return 0;
//         }

//         if(text1.charAt(i) == text2.charAt(j)){
//             return 1 + recur(i-1, j-1, text1, text2);
//         }
//         else{
//             int case1 = 0 + recur(i, j-1, text1, text2);
//             int case2 = 0 + recur(i-1, j, text1, text2);
//             return Math.max(case1, case2);
//         }
//     }
// }

// ========= Memoization ==========
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();

//         // Shifting logic lagega taki base case mei -1 index ko handle kr paye isliye +1 n aur m mei add kr diye h
//         int[][] dp = new int[n+1][m+1];

//         for(int i=0; i<=n; i++){
//             Arrays.fill(dp[i], -1);
//         }

//         return recur(n, m, text1, text2, dp);
//     }
//     private int recur(int i, int j, String text1, String text2, int[][] dp){
//         if(i == 0 || j == 0){
//             dp[i][j] = 0;
//             return dp[i][j];
//         }

//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }

//         if(text1.charAt(i-1) == text2.charAt(j-1)){
//             return 1 + recur(i-1, j-1, text1, text2, dp);
//         }
//         else{
//             int case1 = 0 + recur(i, j-1, text1, text2, dp);
//             int case2 = 0 + recur(i-1, j, text1, text2, dp);

//             dp[i][j] = Math.max(case1, case2);
//             return dp[i][j];
//         }
//     }
// }

// ========== Tabulation ==========
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // Shifting logic lagega taki base case mei -1 index ko handle kr paye isliye +1 n aur m mei add kr diye h
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    int case1 = 0 + dp[i][j-1];
                    int case2 = 0 + dp[i-1][j];
                    dp[i][j] = Math.max(case1, case2);
                }
            }
        }
        return dp[n][m];
    }
}