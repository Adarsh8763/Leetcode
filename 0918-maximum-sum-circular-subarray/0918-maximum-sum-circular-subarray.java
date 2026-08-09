class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        //Total Sum
        for(int i=0; i<n; i++){
            totalSum += nums[i];
        }

        //MAX Sum (Normal Case)
        int maxSum = kadaneMax(nums);

        //MIN Sum (For Circular Case)
        int minSum = kadaneMin(nums);

        int circularMaxSum = totalSum - minSum;

        if(maxSum > 0) return Math.max(maxSum, circularMaxSum);

        return maxSum;
    }
    private int kadaneMax(int[] nums){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }
    private int kadaneMin(int[] nums){
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            minSum = Math.min(minSum, sum);
            if(sum > 0){
                sum = 0;
            }
        }
        return minSum;
    }
}