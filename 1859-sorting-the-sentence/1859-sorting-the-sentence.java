class Solution {
    public String sortSentence(String s) {
        String[] strArr = s.split(" ");
        Arrays.sort(strArr, (a, b) -> a.charAt(a.length()-1) - b.charAt(b.length()-1));

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strArr.length; i++){
            sb.append(strArr[i]);
            sb.deleteCharAt(sb.length()-1);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}