class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum = 0;
        int prod = 1;
        while(n > 0){
            int rem = n%10;
            sum += rem;
            prod *= rem;
            n = n/10;
        }
        int finalSum = sum + prod;
        return temp%finalSum == 0;
    }
}