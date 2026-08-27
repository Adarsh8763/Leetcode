class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = edges.length;

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            map.put(u, map.getOrDefault(u, 0)+1);
            map.put(v, map.getOrDefault(v, 0)+1);

            if(map.get(u) == len) return u;
            if(map.get(v) == len) return v;
        }
        return -1;
    }
}