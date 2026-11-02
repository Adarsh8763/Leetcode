class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length;
        int mid = left + (right - left)/2;

        int minMoves = 0;
        for(int i=0; i<right; i++){
            minMoves += Math.abs(nums[mid]-nums[i]);
        }

        return minMoves;
    }
}