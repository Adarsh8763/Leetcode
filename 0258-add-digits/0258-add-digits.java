class Solution {
    public int addDigits(int num) {
        if(num/10 == 0) return num;
        int sum = 0;
        while (num > 9) {
            sum = 0;
            while (num > 0) {
                int rem = num % 10;
                sum += rem;
                num = num / 10;
            }
            num = sum;
        }
        return sum;
    }
}