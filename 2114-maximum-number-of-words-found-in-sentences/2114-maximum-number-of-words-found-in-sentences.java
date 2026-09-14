class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxLen = 0;
        for(String sentence : sentences){
            String[] str = sentence.split(" ");
            maxLen = Math.max(maxLen, str.length);
        }
        return maxLen;
    }
}