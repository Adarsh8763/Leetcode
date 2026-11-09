class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }

        int provinces = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i, adj, visited);
                provinces++;
            }
        }
        return provinces;
    }
    private void bfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int neighbour : adj.get(node)){
                if(!visited[neighbour]){
                    q.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
}