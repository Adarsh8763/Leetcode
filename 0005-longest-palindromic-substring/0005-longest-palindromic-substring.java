class Solution {
    public String longestPalindrome(String s) {

        // =========
        // Brute Force
        // =========

        // String res = "";

        // for(int i=0; i<s.length(); i++){
        //     for(int j=i; j<s.length(); j++){
        //         if(isPalindrome(s, i, j) == true){
        //             if(res.length() < (j-i+1)){
        //                 res = s.substring(i, j+1);
        //             }
        //         }
        //     }
        // }
        // return res;


        // =========
        // Optimized one
        // =========

        int sLen = s.length();
        int start = 0, end = 0;

        for(int i=0; i<sLen; i++){
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int len = Math.max(len1, len2);

            if(len > (end-start+1)){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start, end+1);
    }

    public int expand(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    // public boolean isPalindrome(String s, int i, int j){
    //     while(i<j){
    //         if(s.charAt(i) == s.charAt(j)){
    //             i++;
    //             j--;
    //         }
    //         else return false;
    //     }
    //     return true;
    // }
}