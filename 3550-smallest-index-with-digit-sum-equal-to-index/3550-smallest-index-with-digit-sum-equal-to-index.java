class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            int num = nums[i];

            int newNum = 0;
            while(num > 0){
                int rem = num%10;
                newNum += rem;
                num = num/10;
            }

            if(newNum == i){
                return i;
            }
        }
        return -1;
    }
}