class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = s1.length()-1;
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];
        s1Freq = resetFreq(s1, s1Freq);

        for(; right<s2.length(); right++){
            boolean flag = false;
            s2Freq = resetFreq(s2.substring(left,right+1), s2Freq);

            for(int i=0; i<26; i++){
                if(s1Freq[i] != s2Freq[i]){
                    flag = true;
                }
            }
            if(flag == false){
                return true;
            }
            left++;
        }
        return false;
    }
    private int[] resetFreq(String s, int[] freq){
        Arrays.fill(freq, 0);
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        return freq;
    }
}