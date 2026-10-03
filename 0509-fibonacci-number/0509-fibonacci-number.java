//===== Recursion =======
// class Solution {
    // public int fib(int n) {
    //     if(n <= 1) return n;

    //     return fib(n-2) + fib(n-1);
    // }
// }

// ======= Memoization ========
// class Solution {
//     public int fib(int n) {
//         int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);

//         return recur(n, dp);
//     }
//     private int recur(int n, int[] dp){
//         // Base case
//         if(n <= 1){
//             dp[n] = n;
//             return dp[n];
//         }

//         if(dp[n] != -1){
//             return dp[n];
//         }

//         dp[n] = fib(n-1) + fib(n-2);
//         return dp[n];
//     }
// }

// ======= Tabulation using SC-O(n) =======
// class Solution {
//     public int fib(int n) {
//         if(n <= 1){
//             return n;
//         }

//         int[] dp = new int[n+1];

//         //Base Case
//         dp[0] = 0;
//         dp[1] = 1;
         
//         for(int state=2; state<=n; state++){
//             dp[state] = dp[state-1] + dp[state-2];
//         }
//         return dp[n];
//     }
// }


// ======= Tabulation using SC-O(1) =======
class Solution {
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        
        //Base Case
         int prev1 = 0;
         int prev2 = 1;
         int ans = 0;

        for(int state=2; state<=n; state++){
            ans = prev1 + prev2;
            prev1 = prev2;
            prev2 = ans;
        }
        return ans;
    }
}