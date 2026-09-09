class Solution {
    public long countCommas(long n) {
        long commaCount = 0;
        
        if(n >= 1000){
            commaCount += n-1000+1;
        }
        if(n >= 1000000){
            commaCount += n-1000000+1;
        }
        if(n >= 1000000000){
            commaCount += n-1000000000+1;
        }
        if(n >= 1000000000000L){
            commaCount += n-1000000000000L+1;
        }
        if(n >= 1000000000000000L){
            commaCount++;
        }

        return commaCount;
    }
}