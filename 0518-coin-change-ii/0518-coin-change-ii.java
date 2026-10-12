// ======== Recursion ========
// class Solution {
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         return recur(amount, coins, n-1);
//     }
//     private int recur(int amt, int[] coins, int idx){
//         if(idx == 0){
//             if(amt % coins[0] == 0){
//                 return 1;
//             }
//             return 0;
//         }
//         if(amt == 0){
//             return 1;
//         }

//         int pick = 0;
//         if(coins[idx] <= amt){
//             pick = recur(amt-coins[idx], coins, idx);
//         }

//         int noPick = recur(amt, coins, idx-1);

//         return pick + noPick;
//     }
// }

// ======== Memoization ========
// class Solution {
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         int[][] dp = new int[n][amount+1];

//         for(int i=0; i<n; i++){
//             Arrays.fill(dp[i], -1);
//         }

//         return recur(amount, coins, n-1, dp);
//     }
//     private int recur(int amt, int[] coins, int idx, int[][] dp){
//         if(idx == 0){
//             if(amt % coins[0] == 0){
//                 dp[idx][amt] = 1;
//                 return dp[idx][amt];
//             }
//             dp[idx][amt] = 0;
//             return dp[idx][amt];
//         }
//         if(amt == 0){
//             dp[idx][amt] = 1;
//             return dp[idx][amt];
//         }

//         if(dp[idx][amt] != -1){
//             return dp[idx][amt];
//         }

//         int pick = 0;
//         if(coins[idx] <= amt){
//             pick = recur(amt-coins[idx], coins, idx, dp);
//         }

//         int noPick = recur(amt, coins, idx-1, dp);

//         dp[idx][amt] = pick + noPick;

//         return dp[idx][amt];
//     }
// }

// ======== Tabulation ========
// class Solution {
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         int[][] dp = new int[n][amount + 1];

//         for (int i = 0; i < n; i++) {
//             dp[i][0] = 1;
//         }

//         for (int j = 1; j < amount + 1; j++) {
//             if (j % coins[0] == 0) {
//                 dp[0][j] = 1;
//             } else {
//                 dp[0][j] = 0;
//             }
//         }

//         for (int i = 1; i < n; i++) {
//             for (int j = 1; j < amount + 1; j++) {
//                 int pick = 0;
//                 if (coins[i] <= j) {
//                     pick = dp[i][j-coins[i]];
//                 }

//                 int noPick = dp[i-1][j];

//                 dp[i][j] = pick + noPick;
//             }
//         }

//         return dp[n-1][amount];
//     }
// }


// ======== Tabulation with space optimization ========
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount + 1];

        prev[0] = 1;

        for (int j = 1; j < amount + 1; j++) {
            if (j % coins[0] == 0) {
                prev[j] = 1;
            } else {
                prev[j] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount+1];
            curr[0] = 1;

            for (int j = 1; j < amount + 1; j++) {
                int pick = 0;
                if (coins[i] <= j) {
                    pick = curr[j-coins[i]];
                }

                int noPick = prev[j];

                curr[j] = pick + noPick;
            }
            prev = curr;
        }

        return prev[amount];
    }
}