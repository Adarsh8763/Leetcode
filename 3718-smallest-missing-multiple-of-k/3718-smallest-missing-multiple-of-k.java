class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int multiple = k;
        int i = 2;

        while(set.contains(multiple)){
            multiple = k*i;
            i++;
        }

        return multiple;
    }
}