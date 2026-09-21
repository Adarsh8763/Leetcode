class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, List<String>> adjMap = new HashMap<>();

        for(List<String> account : accounts){
            String firstEmail = account.get(1);

            for(int i=2; i<account.size(); i++){
                String email = account.get(i);
                
                if(!adjMap.containsKey(firstEmail)){
                    adjMap.put(firstEmail, new ArrayList<>());
                }
                adjMap.get(firstEmail).add(email);

                if(!adjMap.containsKey(email)){
                    adjMap.put(email, new ArrayList<>());
                }
                adjMap.get(email).add(firstEmail);
            }
        }

        List<List<String>> res = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();

        for(List<String> account : accounts){
            String firstEmail = account.get(1);

            // Using 1st email we can traverse the while adjMap whether the firstEmail matches with any email id or not.
            if(!visited.contains(firstEmail)){
                List<String> subList = new ArrayList<>();
                dfs(firstEmail, visited, adjMap, subList);

                Collections.sort(subList);

                subList.add(0, account.get(0));
                res.add(subList);
            }
        }
        return res;
    }
    private void dfs(String srcEmail, HashSet<String> visited, HashMap<String, List<String>> adjMap, List<String> subList){

        visited.add(srcEmail);
        subList.add(srcEmail);

        if(!adjMap.containsKey(srcEmail)){
            return;
        }

        for(String neighbour : adjMap.get(srcEmail)){
            if(!visited.contains(neighbour)){
                dfs(neighbour, visited, adjMap, subList);
            }
        }
    }
}