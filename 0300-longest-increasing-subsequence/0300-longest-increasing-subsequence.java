// ========= Actual Code of this qs ==========
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;

//         int[] lis = new int[n];
//         Arrays.fill(lis, 1);

//         int maxLen = 1;
//         for(int i=1; i<n; i++){
//             for(int p=0; p<i; p++){
//                 if(nums[p] < nums[i]){
//                     lis[i] = Math.max(lis[i], 1 + lis[p]);
//                 }
//             }
//             if(lis[i] > maxLen){
//                 maxLen = lis[i];
//             }
//         }

//         return maxLen;
//     }
// }


// ========= Code for printing the lis ==========
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] lis = new int[n];
        int[] prev = new int[n];

        for(int i=0; i<n; i++){
            lis[i] = 1;
            prev[i] = i;
        }

        int maxLen = 1;
        int maxIdx = 0;
        for(int i=1; i<n; i++){
            for(int p=0; p<i; p++){
                if(nums[p] < nums[i]){
                    if(lis[i] < 1 + lis[p]){
                        lis[i] = 1 + lis[p];
                        prev[i] = p;
                    }
                }
            }
            if(lis[i] > maxLen){
                maxLen = lis[i];
                maxIdx = i;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(nums[maxIdx]);
        while(prev[maxIdx] != maxIdx){
            maxIdx = prev[maxIdx];
            res.add(0, nums[maxIdx]); // For reversing the res. We'll always entering elem at 0 idx, so all elems will be shifted to right side and newly entered elem will be stored in starting.
        }

        // Collections.reverse(res);
        print(res);
        return maxLen;
    }
    private void print(ArrayList<Integer> res){
        for(int num : res){
            System.out.print(num + " ");
        }
    }
}