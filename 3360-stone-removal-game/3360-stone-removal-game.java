class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10) return false;

        int count = 10;
        while(n >= count){
            n = n-count;
            count--;
            if(n < count){
                return true;
            }
            else{
                n -= count;
            }
            count--;
        }
        return false;
    }
}