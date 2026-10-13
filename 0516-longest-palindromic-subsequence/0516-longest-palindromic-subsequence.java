// ========== Method - 1 ==========
// class Solution {
//     public int longestPalindromeSubseq(String s) {
//         int n = s.length();
//         return recur(0, n-1, s);
//     }
//     private int recur(int i, int j, String s){
//         if(i == j){
//             return 1;
//         }
//         else if(j < i){
//             return 0;
//         }

//         if(s.charAt(i) == s.charAt(j)){
//             return 2 + recur(i+1, j-1, s);
//         }
//         else{
//             int case1 = 0 + recur(i+1, j, s);
//             int case2 = 0 + recur(i, j-1, s);
//             return Math.max(case1, case2);
//         }
//     }
// }



// // ========== Method - 2 ==========
// ======== Recursion ========
// class Solution {
//     public int longestPalindromeSubseq(String s) {
//         int n = s.length();
//         StringBuilder sb = new StringBuilder(s);
//         String rev = sb.reverse().toString();

//         return recur(n-1, n-1, s, rev);
//     }
//     private int recur(int i, int j, String s, String rev){
//         if(i < 0 || j < 0){
//             return 0;
//         }

//         if(s.charAt(i) == rev.charAt(j)){
//             return 1 + recur(i-1, j-1, s, rev);
//         }
//         else{
//             int case1 = 0 + recur(i-1, j, s, rev);
//             int case2 = 0 + recur(i, j-1, s, rev);
//             return Math.max(case1, case2);
//         }
//     }
// }


// ========= Memoization =========
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();

        int[][] dp = new int[n+1][n+1];

        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }

        return recur(n, n, s, rev, dp);
    }
    private int recur(int i, int j, String s, String rev, int[][] dp){
        if(i == 0 || j == 0){
            dp[i][j] = 0;
            return dp[i][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i-1) == rev.charAt(j-1)){
            dp[i][j] = 1 + recur(i-1, j-1, s, rev, dp);
            return dp[i][j];
        }
        else{
            int case1 = 0 + recur(i-1, j, s, rev, dp);
            int case2 = 0 + recur(i, j-1, s, rev, dp);
            dp[i][j] = Math.max(case1, case2);
            return dp[i][j];
        }
    }
}
