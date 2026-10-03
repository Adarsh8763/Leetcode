// ======= Recursion ========
// class Solution {
//     public int climbStairs(int n) {
//         if(n <= 2){
//             return n;
//         }
//         return climbStairs(n-1) + climbStairs(n-2);
//     }
// }

// ======== Memoization ========
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return recur(n, dp);
    }
    private int recur(int n, int[] dp){
        if(n <= 2){
            dp[n] = n;
            return dp[n];
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = recur(n - 1, dp) + recur(n - 2, dp);
        return dp[n];
    }
}