class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        // -1 is starting vertex(i.e 0)'s parent
        return dfs(0, -1, adjList, hasApple);
    }
    private int dfs(int src, int parent, List<List<Integer>> adjList, List<Boolean> hasApple){
        int totalTime = 0;

        for(int neighbour : adjList.get(src)){
            if(neighbour == parent){
                continue;
            }

            int timeTakenByChild = dfs(neighbour, src, adjList, hasApple);
            // 2 Cases - 1st When child has apple but parent doesn't.   2nd - When parent has apple but chilren don't.
            // If there is no child of the present node and the present node has apple then totalTime = 0+2
            if(timeTakenByChild > 0 || hasApple.get(neighbour)){
                totalTime += timeTakenByChild + 2;
            }
        }
        return totalTime;
    }
}