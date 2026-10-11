// ======== Recursion =========
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
        
//         int res = recur(coins, amount, n-1);
//         if(res == (int)1e9){
//             return -1;
//         }
//         return res;
//     }
//     public int recur(int[] coins, int amt, int idx){
//         if(idx == 0){
//             if(amt % coins[0] == 0){
//                 return amt/coins[0];
//             }
//             return (int)1e9;
//         }

//         // If pick not possible, then by default val of pick that is 1e9 will be assigned to pick
//         int pick = (int)1e9;
//         if(coins[idx] <= amt){
//             pick = 1 + recur(coins, amt-coins[idx], idx);
//         }

//         int noPick = 0 + recur(coins, amt, idx-1);
//         return Math.min(pick, noPick);
//     }
// }


// ======== Memoization =======
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int[][] dp = new int[n][amount+1];

//         for(int i=0; i<n; i++){
//             Arrays.fill(dp[i], -1);
//         }
        
//         int res = recur(coins, amount, n-1, dp);
//         if(res == (int)1e9){
//             return -1;
//         }
//         return res;
//     }
//     public int recur(int[] coins, int amt, int idx, int[][] dp){
//         if(idx == 0){
//             if(amt % coins[0] == 0){
//                 dp[idx][amt] = amt/coins[0];
//                 return dp[idx][amt];
//             }
//             dp[idx][amt] = (int)1e9;
//             return dp[idx][amt];
//         }

//         if(dp[idx][amt] != -1){
//             return dp[idx][amt];
//         }

//         // If pick not possible, then by default val of pick that is 1e9 will be assigned to pick
//         int pick = (int)1e9;
//         if(coins[idx] <= amt){
//             pick = 1 + recur(coins, amt-coins[idx], idx, dp);
//         }

//         int noPick = 0 + recur(coins, amt, idx-1, dp);

//         dp[idx][amt] = Math.min(pick, noPick);
//         return dp[idx][amt];
//     }
// }


// ========= Tabulation ==========
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         int[][] dp = new int[n][amount+1];

//         for(int i=0; i<n; i++){
//             dp[i][0] = 0;
//         }

//         for(int j=0; j<amount+1; j++){
//             if(j % coins[0] == 0){
//                 dp[0][j] = j/coins[0];
//             }
//             else{
//                 dp[0][j] = (int)1e9;
//             }
//         }

//         for(int i=1; i<n; i++){
//             for(int j=1; j<amount+1; j++){
//                 int pick = (int)1e9;
//                 if(coins[i] <= j){
//                     pick = 1 + dp[i][j-coins[i]];
//                 }

//                 int noPick = 0 + dp[i-1][j];
//                 dp[i][j] = Math.min(pick, noPick);
//             }
//         }
        
//         int res = dp[n-1][amount];
//         if(res == (int)1e9){
//             return -1;
//         }
//         return res;
//     }
// }


// ========= Tabulation using space optimization =========
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];

        for(int j=0; j<amount+1; j++){
            if(j % coins[0] == 0){
                prev[j] = j/coins[0];
            }
            else{
                prev[j] = (int)1e9;
            }
        }

        for(int i=1; i<n; i++){
            int[] curr = new int[amount+1];
            curr[0] = 0;
            for(int j=1; j<amount+1; j++){
                int pick = (int)1e9;
                if(coins[i] <= j){
                    pick = 1 + curr[j-coins[i]];
                }

                int noPick = 0 + prev[j];
                curr[j] = Math.min(pick, noPick);
            }
            prev = curr;
        }
        
        int res = prev[amount];
        if(res == (int)1e9){
            return -1;
        }
        return res;
    }
}