class Solution {
    public int reverseDegree(String s) {

        // ==== My code =====
        // int[] freqArr = new int[26];

        // for(int i=0; i<26; i++){
        //     freqArr[i] = 26-i;
        // }

        // int sum = 0;
        // for(int i=0; i<s.length(); i++){
        //     sum += freqArr[s.charAt(i)-97]*(i+1);
        // }

        // return sum;


        // ===== Optimal code =====


        int sum = 0;
        for(int i=0; i<s.length(); i++){
            int val = 26-(s.charAt(i)-97);
            sum += val*(i+1);
        }
        return sum;
    }

}