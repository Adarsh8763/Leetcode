class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(k > n) return -1;

        int low = 0, high = 0;

        for(int num : nums){
            low = Math.max(low, num);
            high += num;
        }

        int ans = high;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canAllocate(nums, k, mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    private boolean canAllocate(int[] nums, int k, int maxSubArrSum){
        int numOfSubArr = 1;
        int subArrSum = 0;

        for(int num : nums){
            if(num + subArrSum <= maxSubArrSum){
                subArrSum += num;
            }
            else{
                numOfSubArr++;
                subArrSum = num;
            }
        }
        return numOfSubArr <= k;
    }
}