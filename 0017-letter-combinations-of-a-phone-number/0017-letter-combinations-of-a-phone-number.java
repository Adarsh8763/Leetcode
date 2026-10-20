// =========== Without using StringBuilder =============
class Solution {
    public List<String> letterCombinations(String digits) {

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();

        combinations(digits, 0, "", res, map);
        return res;
    }
    private void combinations(String digits, int idx, String curr, List<String> res, HashMap<Character, String> map){
        if(idx == digits.length()){
            res.add(curr.toString());
            return;
        }

        String alphabets = map.get(digits.charAt(idx));
        for(char ch : alphabets.toCharArray()){
            curr = curr + ch;
            combinations(digits, idx+1, curr, res, map);
            curr = curr.substring(0, curr.length()-1);
        }
    }
}

// ======== Using StringBuilder ============
// class Solution {
//     public List<String> letterCombinations(String digits) {

//         HashMap<Character, String> map = new HashMap<>();
//         map.put('2', "abc");
//         map.put('3', "def");
//         map.put('4', "ghi");
//         map.put('5', "jkl");
//         map.put('6', "mno");
//         map.put('7', "pqrs");
//         map.put('8', "tuv");
//         map.put('9', "wxyz");

//         List<String> res = new ArrayList<>();
//         StringBuilder curr = new StringBuilder();

//         combinations(digits, 0, curr, res, map);
//         return res;
//     }
//     private void combinations(String digits, int idx, StringBuilder curr, List<String> res, HashMap<Character, String> map){
//         if(idx == digits.length()){
//             res.add(curr.toString());
//             return;
//         }

//         String alphabets = map.get(digits.charAt(idx));
//         for(char ch : alphabets.toCharArray()){
//             curr.append(ch);
//             combinations(digits, idx+1, curr, res, map);
//             curr.deleteCharAt(curr.length()-1);
//         }
//     }
// }