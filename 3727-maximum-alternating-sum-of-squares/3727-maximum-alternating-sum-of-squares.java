class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        int[] odd = new int[n/2];
        int[] even = new int[n-n/2];

        for(int i=0; i<n; i++){
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);
        
        int i = 0;
        for(; i<n/2; i++){
            odd[i] = nums[i];
        }

        int j = 0;
        for(; i<n; i++){
            even[j++] = nums[i];
        }

        long maxSum = 0;
        int a = 0;
        int e = 0;
        for(int k=0; k<n; k++){
            if(k%2 == 0){
                maxSum += even[e]*even[e];
                e++; 
            }
            else{
                maxSum -= odd[a]*odd[a];
                a++;
            }
        }

        return maxSum;
    }
}