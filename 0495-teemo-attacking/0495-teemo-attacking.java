class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int totalTime = 0;

        for(int i=0; i<n-1; i++){
            if(timeSeries[i]+duration > timeSeries[i+1]){
                totalTime += timeSeries[i+1] - timeSeries[i];
            }
            else{
                totalTime += duration;
            }
        }
        totalTime += duration;        
        return totalTime;
    }
}