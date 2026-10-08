// ========= Recursion ==========
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         return recur(nums, n-1);
//     }
//     private int recur(int[] nums, int idx){
//         if(idx == 0){
//             return nums[0];
//         }
//         else if(idx == -1){
//             return 0;
//         }

//         int pick = nums[idx] + recur(nums, idx-2);
//         int noPick = 0 + recur(nums, idx-1);

//         return Math.max(pick, noPick);
//     }
// }


// ======== Memoization ======== 
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return recur(nums, dp, n-1);
    }
    private int recur(int[] nums, int[] dp, int idx){
        if(idx == 0){
            dp[idx+1] = nums[0];
            return dp[idx+1];
        }
        else if(idx == -1){
            dp[idx+1] = 0;
            return dp[idx+1];
        }

        if(dp[idx+1] != -1){
            return dp[idx+1];
        }

        int pick = nums[idx] + recur(nums, dp, idx-2);
        int noPick = 0 + recur(nums, dp, idx-1);
        dp[idx+1] = Math.max(pick, noPick);

        return dp[idx+1];
    }
}