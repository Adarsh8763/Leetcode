class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adjList.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int[] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.offer(new int[]{k, 0});
        dist[k] = 0;

        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            int u = pair[0];
            int d = pair[1];

            if(d > dist[u]) continue;

            for(int[] neighbour : adjList.get(u)){
                int v = neighbour[0];
                int w = neighbour[1];
                if(dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        int reqTime = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            reqTime = Math.max(reqTime, dist[i]);
        }

        return reqTime;
    }
}