class Solution {
    public void reverseString(char[] s) {
        for (int i=0; i<s.length/2; i++){
            int j = s.length-1-i;
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}