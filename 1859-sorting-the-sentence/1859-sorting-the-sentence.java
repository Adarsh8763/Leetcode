// ======== My Solution ==========
// class Solution {
//     public String sortSentence(String s) {
//         String[] strArr = s.split(" ");
//         Arrays.sort(strArr, (a, b) -> a.charAt(a.length()-1) - b.charAt(b.length()-1));

//         StringBuilder sb = new StringBuilder();
//         for(int i=0; i<strArr.length; i++){
//             sb.append(strArr[i]);
//             sb.deleteCharAt(sb.length()-1);
//             sb.append(" ");
//         }
//         sb.deleteCharAt(sb.length()-1);
//         return sb.toString();
//     }
// }


// ======= More optimal solution =========
class Solution {
    public String sortSentence(String s) {
        String[] strArr = s.split(" ");
        String[] ans = new String[strArr.length];

        for(String word : strArr){
            int num = Character.getNumericValue(word.charAt(word.length()-1));
            ans[num-1] = word.substring(0, word.length()-1);
        }

        s = String.join(" ", ans);

        return s;
    }
}