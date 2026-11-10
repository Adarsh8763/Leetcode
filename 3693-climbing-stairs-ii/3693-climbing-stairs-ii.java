class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+3];
        Arrays.fill(dp, -1);

        return recur(n, costs, dp);
    }
    private int recur(int n, int[] costs, int[] dp){
        if(n <= 0){
            dp[n+2] = 0;
            return dp[n+2];
        }

        if(dp[n+2] != -1){
            return dp[n+2];
        }

        int prev1 = costs[n-1] + 1 + recur(n-1, costs, dp);
        int prev2 = costs[n-1] + 4 + recur(n-2, costs, dp);
        int prev3 = costs[n-1] + 9 + recur(n-3, costs, dp);
        
        dp[n+2] = Math.min(Math.min(prev1, prev2), prev3);
        return dp[n+2];
    }
}