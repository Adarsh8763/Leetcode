class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long minCost = Long.MAX_VALUE;
        long c1B = Long.MAX_VALUE;
        long c2B = Long.MAX_VALUE;
        long cB = Long.MAX_VALUE;
        long totalCost = Long.MAX_VALUE;

        if(need1 > need2){
            minCost = Math.min(minCost, (long)need1*costBoth);
            c1B = (long)cost1 * (need1-need2);
            cB = (long)costBoth * need2;
            totalCost = c1B+cB;
        }
        else{
            minCost = Math.min(minCost, (long)need2*costBoth);
            c2B = (long)cost2 * (need2-need1);
            cB = (long)costBoth * need1;
            totalCost = c2B+cB;
        }
        
        minCost = Math.min(minCost, (long)need1*cost1 + (long)need2*cost2);
        minCost = Math.min(minCost, totalCost);

        return minCost;
    }
}