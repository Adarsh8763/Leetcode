class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;

        int left = 0;
        for (int right = 0; right < n; right++) {
            while(left <= right && ((nums[left] % 2 == 0 && left % 2 == 0) || (nums[left] % 2 != 0 && left % 2 != 0))) {
                left++;
            }
            if((nums[right] % 2 != 0 && right % 2 == 0) || (nums[right] % 2 == 0 && right % 2 != 0)){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}