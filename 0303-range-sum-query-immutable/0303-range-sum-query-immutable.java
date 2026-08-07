class NumArray {
    int[] nums;
    int[] pSum;

    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        pSum = new int[n];

        int sum = nums[0];
        pSum[0] = nums[0];
        for(int i=1; i<n; i++){
            sum += nums[i];
            pSum[i] += sum;
        }
    }
    
    public int sumRange(int left, int right) {
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