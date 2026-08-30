class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int smallNumIdx = 0; 
        int largeNumIdx = 0; 

        for(int i=0; i<n; i++){
            if(nums[smallNumIdx] > nums[i]) smallNumIdx = i;
            if(nums[largeNumIdx] < nums[i]) largeNumIdx = i;
        }
        int smallIdx = Math.min(smallNumIdx, largeNumIdx);
        int largeIdx = Math.max(smallNumIdx, largeNumIdx);

        int leftDeletion = largeIdx+1;
        int rightDeletion = n-smallIdx;
        int leftRightDeletion = n-largeIdx + smallIdx+1;

        return Math.min(Math.min(leftDeletion, rightDeletion), leftRightDeletion);
    }
}