class Solution {
    public String truncateSentence(String s, int k) {
        int len = s.length();
        String[] strArr = s.split(" ");

        StringBuilder sb = new StringBuilder();

        int i = 0;
        for(i=0; i<k-1; i++){
            sb.append(strArr[i] + " ");
        }
        sb.append(strArr[i]);

        return sb.toString();
    }
}