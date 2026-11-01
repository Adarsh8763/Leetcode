class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();

        for(String word : words){
            sb.append(word);

            if(sb.toString().equals(s)){
                return true;
            }
            if(!s.startsWith(sb.toString())){
                return false;
            }
        }

        return false;
    }
}