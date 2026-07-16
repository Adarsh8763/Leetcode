class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xSum = 0;
        for (int i=0; i<n; i++){
            xSum = xSum ^ nums[i];
        }
        for (int i=0; i<n+1; i++){
            xSum = xSum ^ i;
        }
        return xSum;
    }
}