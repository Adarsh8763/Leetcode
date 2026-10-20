class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder curr = new StringBuilder();
        List<String> res = new ArrayList<>();

        backtrack(n, 0, 0, curr, res);
        return res;
    }
    private void backtrack(int n, int openCount, int closeCount, StringBuilder curr, List<String> res){
        if(openCount == n && closeCount == n){
            res.add(curr.toString());
            return;
        }

        // if(openCount < closeCount){
        //     continue;
        // }
        if(openCount != n){
            curr.append('(');
            openCount++;
            backtrack(n, openCount, closeCount, curr, res);
            openCount--;
            curr.deleteCharAt(curr.length()-1);
        }
        if(openCount > closeCount && closeCount != n){
            curr.append(')');
            closeCount++;
            backtrack(n, openCount, closeCount, curr, res);
            closeCount--;
            curr.deleteCharAt(curr.length()-1);
        }
    }
}