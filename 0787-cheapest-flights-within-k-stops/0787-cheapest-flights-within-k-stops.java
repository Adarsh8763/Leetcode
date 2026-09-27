// ======== Using Bellman Ford ======
// class Solution {
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         int[] price = new int[n];
//         Arrays.fill(price, Integer.MAX_VALUE);
//         price[src] = 0;

//         int[] temp = Arrays.copyOf(price, n);

//         for(int i=0; i<k+1; i++){
//             for(int[] flight : flights){
//                 int u = flight[0];
//                 int v = flight[1];
//                 int w = flight[2];

//                 if(price[u] != Integer.MAX_VALUE && price[u] + w < temp[v]){
//                     temp[v] = price[u] + w;
//                 }
//             }
//             price = Arrays.copyOf(temp, n);
//         }

//         return (price[dst] == Integer.MAX_VALUE) ? -1 : price[dst];
//     }
// }

// ======== Using Dijkstra Algo =========
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];

            adjList.get(u).add(new int[] { v, w });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        pq.offer(new int[] { src, 0, 0 });

        while (!pq.isEmpty()) {
            int[] triplet = pq.poll();
            int u = triplet[0];
            int p = triplet[1];
            int f = triplet[2]; // f -> Flight

            if (f > stops[u] || f > k + 1)
                continue;

            stops[u] = f;

            if(u == dst)
                return p;

            for (int[] neighbour : adjList.get(u)) {
                int v = neighbour[0];
                int w = neighbour[1];
                pq.offer(new int[] { v, p + w, f + 1 });
            }
        }
        return -1;
    }
}