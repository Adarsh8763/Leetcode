class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeftBound(nums, target);
        int right = findRightBound(nums, target);

        return new int[]{left, right};
    }
    private int findLeftBound(int[] nums, int target){
        int start = 0, end = nums.length-1;
        int index = -1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                index = mid;
                end = mid-1;
            }
            else if(target < nums[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return index;
    }

    private int findRightBound(int[] nums, int target){
        int start = 0, end = nums.length-1;
        int index = -1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                index = mid;
                start = mid+1;
            }
            else if(target < nums[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return index;
    }
}