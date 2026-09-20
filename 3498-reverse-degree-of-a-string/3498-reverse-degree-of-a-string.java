class Solution {
    public int reverseDegree(String s) {
        int[] freqArr = new int[26];

        for(int i=0; i<26; i++){
            freqArr[i] = 26-i;
        }

        int sum = 0;
        for(int i=0; i<s.length(); i++){
            sum += freqArr[s.charAt(i)-97]*(i+1);
        }

        return sum;
    }
}