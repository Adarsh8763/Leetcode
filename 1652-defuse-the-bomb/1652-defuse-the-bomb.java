class Solution {
    public int[] decrypt(int[] code, int k) {
        //Brute Force approach

        // int n = code.length;
        // int[] ans = new int[n];
        // int count = 0;

        // if(k == 0) return ans;

        // for(int i=0; i<n; i++){
        //     if(k < 0){
        //         for(int j = i-Math.abs(k); j<i; j++){
        //             ans[i] += code[(j+n) % n]; 
        //         }
        //     }
        //     else{
        //         for(int j = i+k; j>i; j--){
        //             ans[i] += code[j%n];
        //         }
        //     }
        // }
        // return ans;


        //Sliding Window Approach

        int n = code.length;
        int ans[] = new int[n];

        int i = -1, j = -1;
        if(k > 0){
            i = 1;
            j = k;
        }
        else{
            i = n-Math.abs(k);
            j = n-1;
        }

        int windowSum = 0;
        for(int ptr=i; ptr<=j; ptr++){
            windowSum += code[ptr];
        }

        for(int m=0; m<n; m++){
            ans[m] = windowSum;

            windowSum -= code[i % n];
            i++;

            windowSum += code[(j+1) % n];
            j++;
        }

        return ans;
    }
}