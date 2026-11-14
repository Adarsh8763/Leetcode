class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        int minSum = Integer.MAX_VALUE;

        while(l <= r){
            int sum = 0;
            int left = 0;
            int right = 0;

            for(; right<l; right++){
                sum += nums.get(right);
            }

            if(sum > 0){
                minSum = Math.min(minSum, sum);
            }
            
            for(right = l; right<n; right++){
                if(right-left+1 > l){
                    sum -= nums.get(left);
                    left++;
                }
                sum += nums.get(right);
                if(sum > 0){
                    minSum = Math.min(minSum, sum);
                }
            }
            l++;
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}