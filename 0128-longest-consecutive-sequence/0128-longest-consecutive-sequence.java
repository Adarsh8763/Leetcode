class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int maxCount = 1, count = 1;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        Integer []arr = set.toArray(new Integer[0]);
        Arrays.sort(arr);
        for (int i=0; i<arr.length-1; i++){
            if(arr[i]+1 == arr[i+1]){
                count++;
            }
            else{
                count = 1;
            }
            if(maxCount<count){
                maxCount = count;
            }
        }
        return maxCount;
    }
}