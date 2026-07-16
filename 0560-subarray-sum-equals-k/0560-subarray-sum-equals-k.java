class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int [] pSum = new int[n];
        pSum[0] = nums[0];

        for (int i=1; i<n; i++){
            pSum[i] = nums[i] + pSum[i-1]; 
        }  

        HashMap <Integer, Integer> map = new HashMap<>();

        for(int j=0; j<n; j++){
            if(pSum[j] == k) count++;

            int val = pSum[j] - k;
            if(map.containsKey(val)){
                count += map.get(val);
            }

            map.put(pSum[j], map.getOrDefault(pSum[j],0) + 1);
        }
        return count;
    }
}