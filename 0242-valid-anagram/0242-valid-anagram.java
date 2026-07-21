class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if(sLen != tLen) return false;

        int [] arr = new int[26];
        for (int i=0; i<sLen; i++){
            char ch = s.charAt(i);
            arr[ch-97]++;
        }

        for(int i=0; i<tLen; i++){
            char ch = t.charAt(i);
            arr[ch-97]--;
        }

        for (int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}