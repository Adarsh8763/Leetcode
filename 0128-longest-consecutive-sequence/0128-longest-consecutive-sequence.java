class Solution {
    public int longestConsecutive(int[] nums) {

        // MY LOGIC ---

        // if (nums.length == 0) return 0;
        // int maxCount = 1, count = 1;
        // Set<Integer> set = new HashSet<>();

        // for (int num : nums) {
        //     set.add(num);
        // }
        // Integer []arr = set.toArray(new Integer[0]);
        // Arrays.sort(arr);
        // for (int i=0; i<arr.length-1; i++){
        //     if(arr[i]+1 == arr[i+1]){
        //         count++;
        //     }
        //     else{
        //         count = 1;
        //     }
        //     if(maxCount<count){
        //         maxCount = count;
        //     }
        // }
        // return maxCount;

        // OPTIMIZED ---

        // if(nums.length == 0) return 0;

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums){
            map.put(num, false);
        }
        
        int maxCount = 0;

        for(int num : nums){
            int count = 1;

            map.put(num, true);

            int nextNum = num+1;
            while(map.containsKey(nextNum) && map.get(nextNum) == false){
                map.put(nextNum, true);
                count++;
                nextNum++;
            }
            
            int  prevNum = num-1;
            while(map.containsKey(prevNum) && map.get(prevNum) == false){
                map.put(prevNum, true);
                count++;
                prevNum--;
            }

            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }
}