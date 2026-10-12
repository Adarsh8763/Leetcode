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
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        return recur(amount, coins, n-1, dp);
    }
    private int recur(int amt, int[] coins, int idx, int[][] dp){
        if(idx == 0){
            if(amt % coins[0] == 0){
                dp[idx][amt] = 1;
                return dp[idx][amt];
            }
            dp[idx][amt] = 0;
            return dp[idx][amt];
        }
        if(amt == 0){
            dp[idx][amt] = 1;
            return dp[idx][amt];
        }

        if(dp[idx][amt] != -1){
            return dp[idx][amt];
        }

        int pick = 0;
        if(coins[idx] <= amt){
            pick = recur(amt-coins[idx], coins, idx, dp);
        }

        int noPick = recur(amt, coins, idx-1, dp);

        dp[idx][amt] = pick + noPick;

        return dp[idx][amt];
    }
}