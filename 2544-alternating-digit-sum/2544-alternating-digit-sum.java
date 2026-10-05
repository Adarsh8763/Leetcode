class Solution {
    public int alternateDigitSum(int n) {
        String str = String.valueOf(n);
        int toggle = 0;
        int ans = 0;

        for(char ch : str.toCharArray()){
            int num = ch - '0';
            if(toggle == 0){
                ans += num;
                toggle = 1;
            }
            else{
                ans -= num;
                toggle = 0;
            }
        }
        return ans;
    }
}