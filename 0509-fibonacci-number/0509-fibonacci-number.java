class Solution {
    //===== Recursion =======
    // public int fib(int n) {
    //     if(n <= 1) return n;

    //     return fib(n-2) + fib(n-1);
    // }


    //===== Memoization with SC=O(n) =======
    // public int fib(int n) {
    //     if(n <= 1) return n;
    //     int[] memoArr = new int[n+1];

    //     memoArr[0] = 0;
    //     memoArr[1] = 1;

    //     for(int i=2; i<=n; i++){
    //         memoArr[i] = memoArr[i-2] + memoArr[i-1];
    //     } 

    //     return memoArr[n];
    // }

    //===== Memoization with SC=O(1) =======
    public int fib(int n) {
        if(n <= 1) return n;

        int num1 = 0;
        int num2 = 1;
        int res = 1;

        for(int i=2; i<=n; i++){
            res = num1 + num2;
            num1 = num2;
            num2 = res;
        } 

        return res;
    }
}