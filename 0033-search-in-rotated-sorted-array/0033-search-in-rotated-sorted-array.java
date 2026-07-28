class Solution {
    public int search(int[] nums, int target) {
        return modifiedBinarySearch(nums, target, 0, nums.length-1);
    }

    private int modifiedBinarySearch(int[] nums, int target, int start, int end){
        if(start > end) return -1;

        int mid = start + ((end-start)/2);

        if(nums[mid] == target){
            return mid;
        }

        // If left half is sorted
        if(nums[mid] >= nums[start]){
            if(nums[start] <= target && target <= nums[mid]){
                return modifiedBinarySearch(nums, target, start, mid-1);
            }
            else{
                return modifiedBinarySearch(nums, target, mid+1, end);
            }
        }

        // If right half is sorted
        else{
            if(nums[mid] <= target && target <= nums[end]){
                return modifiedBinarySearch(nums, target, mid+1, end);
            }
            else{
                return modifiedBinarySearch(nums, target, start, mid-1);
            }
        }
    }
}