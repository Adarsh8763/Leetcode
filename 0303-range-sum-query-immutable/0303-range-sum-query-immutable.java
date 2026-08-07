class NumArray {
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        int n = nums.length;
        int[] pSum = new int[n];

        int sum = nums[0];
        pSum[0] = nums[0];
        for(int i=1; i<n; i++){
            sum += nums[i];
            pSum[i] += sum;
        }
        if(left == 0){
            return pSum[right];
        }
        else{
            int reqSum = pSum[right] - pSum[left-1];
            return reqSum;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */