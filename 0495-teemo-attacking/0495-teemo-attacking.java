class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int totalTime = 0;

        for(int i=0; i<n-1; i++){
            // Since its inclusive So, [1,4] collides with [4,7] (collison point 4) 
            if(timeSeries[i]+duration-1 >= timeSeries[i+1]){
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