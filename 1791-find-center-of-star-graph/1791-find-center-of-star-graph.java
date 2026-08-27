class Solution {
    public int findCenter(int[][] edges) {
        // Map<Integer, Integer> map = new HashMap<>();
        // int len = edges.length;

        // for(int[] edge : edges){
        //     int u = edge[0];
        //     int v = edge[1];

        //     map.put(u, map.getOrDefault(u, 0)+1);
        //     map.put(v, map.getOrDefault(v, 0)+1);

        //     if(map.get(u) == len) return u;
        //     if(map.get(v) == len) return v;
        // }
        // return -1;

        int[] pair1 = edges[0]; // u1,v1
        int[] pair2 = edges[1]; // (u1,v2 or v2,u1) ya (u2,v1 or v1,u2)

        if(pair1[0] == pair2[0] || pair1[0] == pair2[1]) return pair1[0];
        
        return pair1[1];
    }
}