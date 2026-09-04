class Solution {
    //===== Recursion =======
    // public int fib(int n) {
    //     if(n <= 1) return n;

    //     return fib(n-2) + fib(n-1);
    // }


    //===== Memoization =======
    public int fib(int n) {
        if(n <= 1) return n;
        int[] memoArr = new int[n+1];

        memoArr[0] = 0;
        memoArr[1] = 1;

        for(int i=2; i<=n; i++){
            memoArr[i] = memoArr[i-2] + memoArr[i-1];
        } 

        return memoArr[n];
    }
}