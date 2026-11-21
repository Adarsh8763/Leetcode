class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(!map.containsKey(num)){
                map.put(num, new int[3]);
                map.get(num)[0]++;
                map.get(num)[1] = i;
                map.get(num)[2] = i;
            }
            else{
                map.get(num)[0]++;
                map.get(num)[2] = i;
            }
        } 

        int maxFreq = Integer.MIN_VALUE;
        int minSubArr = Integer.MAX_VALUE;
        for(int key : map.keySet()){
            if(maxFreq < map.get(key)[0]){
                maxFreq = map.get(key)[0];
                minSubArr = map.get(key)[2] - map.get(key)[1] + 1;
            }
            else if(maxFreq == map.get(key)[0]){
                minSubArr = Math.min(minSubArr, map.get(key)[2] - map.get(key)[1] + 1);
            }
        }
        return minSubArr;
    }
}