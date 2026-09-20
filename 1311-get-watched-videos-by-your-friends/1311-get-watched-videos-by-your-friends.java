class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        q.offer(id);
        visited.add(id);
        int currLvl = 0;

        while(!q.isEmpty()){
            int size = q.size();

            //Iterate level by level. We are using loop so that all the elements in desired level are visited
            for(int i=0; i<size; i++){
                int currId = q.poll();
                for(int friend : friends[currId]){
                    if(!visited.contains(friend)){
                        q.offer(friend);
                        visited.add(friend);
                    }
                }
            }
            currLvl++;
            if(currLvl == level){
                break;
            }
        }

        HashMap<String, Integer> freqMap = new HashMap<>();

        //Queue mei baaki rhega desired level ka nodes so uske corresponding we'll take out videos
        while(!q.isEmpty()){
            int currId = q.poll();
            for(String video : watchedVideos.get(currId)){
                freqMap.put(video, freqMap.getOrDefault(video, 0)+1);
            }
        }

        List<String> videoList = new ArrayList<>(freqMap.keySet());

        videoList.sort((a, b) -> {
            //here Integer is auto converted into int for comparision
            if(freqMap.get(a) == freqMap.get(b)){
                //Here differnce will be returned and sort will auto sort them according to the difference it will get
                return a.compareTo(b);
            }

            return freqMap.get(a) - freqMap.get(b);
        });

        return videoList;
    }
}