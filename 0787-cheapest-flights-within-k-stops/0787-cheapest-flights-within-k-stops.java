class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;

        int[] temp = Arrays.copyOf(price, n);

        for(int i=0; i<k+1; i++){
            for(int[] flight : flights){
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];

                if(price[u] != Integer.MAX_VALUE && price[u] + w < temp[v]){
                    temp[v] = price[u] + w;
                }
            }
            price = Arrays.copyOf(temp, n);
        }

        return (price[dst] == Integer.MAX_VALUE) ? -1 : price[dst];
    }
}