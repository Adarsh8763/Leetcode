class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for(char ch : t.toCharArray()){
            mapT.put(ch, mapT.getOrDefault(ch, 0)+1);
        }

        int right = 0, left = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for( ; right<s.length(); right++){
            char rightCh = s.charAt(right);
            mapS.put(rightCh, mapS.getOrDefault(rightCh, 0)+1);

            while(contains(mapS, mapT)){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    minStart = left;
                }
                char leftCh = s.charAt(left);
                if(mapS.get(leftCh) == 1){
                    mapS.remove(leftCh);
                }
                else{
                    mapS.put(leftCh, mapS.get(leftCh)-1);
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLen);
    }
    private boolean contains(HashMap<Character, Integer> mapS, HashMap<Character, Integer> mapT){
        for(char ch : mapT.keySet()){
            if(mapS.getOrDefault(ch, 0) < mapT.get(ch)){
                return false;
            }
        }
        return true;
    }
}