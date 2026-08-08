class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            left[i] = sum;
        }

        sum = 0;
        for(int i=n-1; i>=0; i--){
            sum += nums[i];
            right[i] = sum;
        }

        for(int i=0; i<n; i++){
            if(right[i] == left[i]){
                return i;
            }
        }
        return -1;
    }
}