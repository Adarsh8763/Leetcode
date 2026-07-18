class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums[0];
        int votes = 1;

        for (int i=1; i<nums.length; i++){
            if(votes == 0){
                maj = nums[i];
                votes = 1;
            }
            else if(maj == nums[i]){
                votes++;
            }
            else{
                votes--;
            }
        }
        return maj;
    }
}