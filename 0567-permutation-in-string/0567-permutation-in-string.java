class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int left = 0;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char ch : s1.toCharArray()){
            freq1[ch - 'a']++;
        }

        for(int right=0; right<s2.length(); right++){
            char ch = s2.charAt(right);
            freq2[ch - 'a']++;

            if(s1.length() < right-left+1){
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }

            if(s1.length() == right-left+1){
                boolean isMatch = true;
                for(int i=0; i<26; i++){
                    if(freq1[i] != freq2[i]){
                        isMatch = false;
                        break;
                    }
                }
                if(isMatch){
                    return true;
                }
            }
        }
        return false;
    }
}