class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        if(n<=1) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int[] pSum = new int[n];
        int sum = 0;

        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
            sum += nums[i];
            pSum[i] = sum;
        }

        int maxLen = 0;
        for(int j=0; j<n; j++){
            int val = pSum[j];
            if(pSum[j] == 0){
                maxLen = Math.max(maxLen, j+1);
            }
            else{
                if(map.containsKey(val)){
                    int range = j-map.get(val);
                    maxLen = Math.max(maxLen, range);
                }
            }
            if(!map.containsKey(val)){
                map.put(pSum[j], j);
            }
        }
        return maxLen;
    }
}