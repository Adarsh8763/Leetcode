class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> freqStringMap = new HashMap<>();
        for(String str : strs){

            String freqString = getFreqString(str);

            if(freqStringMap.containsKey(freqString)){
                freqStringMap.get(freqString).add(str);
            }
            else{
                List<String> strList = new ArrayList<>();
                strList.add(str);
                freqStringMap.put(freqString, strList);
            }
        }
        return new ArrayList<>(freqStringMap.values());
    }
    private String getFreqString(String str){
        int[] freq = new int[26];
        for(char ch : str.toCharArray()){
            freq[ch - 'a']++;
        }
        StringBuilder freqString = new StringBuilder();
        char c = 'a';
        for(int i : freq){
            freqString.append(c);
            freqString.append(i);
            c++;
        }
        return freqString.toString();
    }
}