class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        if(days > n) return -1;

        int low = 0, high = 0;
        for(int weight : weights){
            low = Math.max(low, weight);
            high += weight;
        }

        int ans = high;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canShipIn(weights, days, mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    private boolean canShipIn(int[] weights, int days, int maxWeight){
        int d = 1;
        int totalWeight = 0;

        for(int weight : weights){
            if(totalWeight + weight <= maxWeight){
                totalWeight += weight;
            }
            else{
                d++;
                totalWeight = weight;
            }
        }
        return d <= days;
    }
}