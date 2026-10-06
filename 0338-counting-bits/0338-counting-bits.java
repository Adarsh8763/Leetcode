// ======== TC- O(n log(n)) ========
// class Solution {
//     public int[] countBits(int n) {
//         int[] res = new int[n+1];

//         for(int i=0; i<=n; i++){
//             int count = 0;
//             for(int j=1; j<=i; j=j*2){
//                 if((i&j) != 0){
//                     count++;
//                 }
//             }
//             res[i] = count;
//         }
//         return res;
//     }
// }



// ======== TC- O(n log(n)) ========
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];

        for(int i=0; i<=n; i++){
            int count = 0;
            int num = i;

            while(num > 0){
                num = num & (num-1);
                count++;
            }
            res[i] = count;
        }
        return res;
    }
}

