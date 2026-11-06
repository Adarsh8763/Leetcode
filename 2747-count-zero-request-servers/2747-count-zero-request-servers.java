//  =============== My appraoch (Brute Force - TLE) ===========
// class Solution {
//     public int[] countServers(int n, int[][] logs, int x, int[] queries) {
//         int qLen = queries.length;
//         int[] ans = new int[qLen];

//         for(int i=0; i<qLen; i++){
//             HashSet<Integer> set = new HashSet<>();

//             int startTime = queries[i]-x;
//             int endTime = queries[i];
            
//             int count = 0;
//             for(int[] log : logs){
//                 int id = log[0];
//                 int receivedTime = log[1];
                
//                 if(!set.contains(id)){
//                     if(startTime <= receivedTime && receivedTime <= endTime){
//                         set.add(id);
//                         count++;
//                     }
//                 }
//             }

//             ans[i] = n - count;
//         }
        
//         return ans;
//     }
// }


// ========= Optimized approach =========
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[1]-b[1]);

        int qLen = queries.length;
        int[][] sortedQueries = new int[qLen][2];

        for(int i=0; i<qLen; i++){
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0]-b[0]);

        int[] ans = new int[qLen];
        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        for(int i=0; i<qLen; i++){
            int startTime = sortedQueries[i][0] - x;
            int endTime = sortedQueries[i][0];

            while(r < logs.length && logs[r][1] <= endTime){
                int id = logs[r][0];
                map.put(id, map.getOrDefault(id, 0)+1);
                r++;
            }

            while(l < r && logs[l][1] < startTime){
                int id = logs[l][0];
                map.put(id, map.get(id)-1);
                if(map.get(id) == 0){
                    map.remove(id);
                }
                l++;
            }
            int pos = sortedQueries[i][1];
            ans[pos] = n - map.size();
        }
        
        return ans;
    }
}
