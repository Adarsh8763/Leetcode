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
// class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);

//         return recur(n, dp);
//     }
//     private int recur(int n, int[] dp){
//         if(n <= 2){
//             dp[n] = n;
//             return dp[n];
//         }
//         if(dp[n] != -1){
//             return dp[n];
//         }
//         dp[n] = recur(n - 1, dp) + recur(n - 2, dp);
//         return dp[n];
//     }
// }

// // ======== Tabulation using SC- O(n)=========
// class Solution {
//     public int climbStairs(int n) {
//         if(n <= 2){
//             return n;
//         }
//         int[] dp = new int[n+1];

//         dp[1] = 1;
//         dp[2] = 2; 
//         for(int state=3; state<=n; state++){
//             dp[state] = dp[state-1] + dp[state-2];
//         }
//         return dp[n];
//     }
// }


// ======== Tabulation using SC- O(1)=========
class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }

        int prev1 = 1;
        int prev2 = 2;
        int ans = 0;

        for(int state=3; state<=n; state++){
            ans = prev1 + prev2;
            prev1 = prev2;
            prev2 = ans;
        }
        return ans;
    }
}