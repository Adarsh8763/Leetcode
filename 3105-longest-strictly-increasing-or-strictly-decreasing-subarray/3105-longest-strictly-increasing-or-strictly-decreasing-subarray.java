class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int maxCount = 1;

        int incCount = 1;
        for(int i=0; i<n-1; i++){
            if(nums[i] < nums[i+1]){
                incCount++;
                maxCount = Math.max(maxCount, incCount);
            }
            else{
                incCount = 1;
            }
        }

        int decCount = 1;
        for(int i=n-1; i>0; i--){
            if(nums[i-1] > nums[i]){
                decCount++;
                maxCount = Math.max(maxCount, decCount);
            }
            else{
                decCount = 1;
            }
        }

        return maxCount;
    }
}