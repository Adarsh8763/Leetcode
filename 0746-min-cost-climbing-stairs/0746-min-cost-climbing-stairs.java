// ========= Recursion =========
// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;

//         return recur(n, cost);
//     }
//     private int recur(int n, int[] cost){
//         // Base case
//         if(n == 0 || n == 1){
//             return 0;
//         }

//         int oneStep = cost[n-1] + recur(n-1, cost);
//         int twoStep = cost[n-2] + recur(n-2, cost);
//         return Math.min(oneStep, twoStep);
//     }
// }

// ========= Memoization =========
// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);

//         return recur(n, cost, dp);
//     }
//     private int recur(int n, int[] cost, int[] dp){
//         // Base case
//         if(n == 0 || n == 1){
//             dp[n] = 0;
//             return dp[n];
//         }

//         if(dp[n] != -1){
//             return dp[n];
//         }

//         int oneStep = cost[n-1] + recur(n-1, cost, dp);
//         int twoStep = cost[n-2] + recur(n-2, cost, dp);
//         dp[n] = Math.min(oneStep, twoStep);

//         return dp[n];
//     }
// }

// ========= Tabulation SC - O(n) =========
// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         int[] dp = new int[n + 1];

//         dp[0] = 0;
//         dp[1] = 0;

//         for (int state = 2; state <= n; state++) {
//             int oneStep = cost[state - 1] + dp[state-1];
//             int twoStep = cost[state - 2] + dp[state-2];
//             dp[state] = Math.min(oneStep, twoStep);
//         }
//         return dp[n];
//     }
// }


// ========= Tabulation using SC - O(1) =========
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int prev2 = 0;
        int prev1 = 0;
        int ans = 0;

        for (int state = 2; state <= n; state++) {
            int oneStep = cost[state - 1] + prev1;
            int twoStep = cost[state - 2] + prev2;

            ans = Math.min(oneStep, twoStep);
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}