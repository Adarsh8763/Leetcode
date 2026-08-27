class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];

        for(int[] edge : roads){
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Arrays.sort(degree);

        long total = 0;
        long label = 1;
        for(int i=0; i<n; i++){
            total += degree[i]*label;
            label++;
        }

        return total;
    }
}