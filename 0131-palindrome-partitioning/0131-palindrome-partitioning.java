class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        
        backtrack(0, s, res, curr);
        return res;
    }
    private void backtrack(int partIdx, String s, List<List<String>> res, List<String> curr){
        int n = s.length();
        // Base case
        if(partIdx == n){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int end=partIdx; end<n; end++){
            if(isPalindrome(partIdx, end, s)){
                curr.add(s.substring(partIdx, end+1));
                backtrack(end+1, s, res, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    private boolean isPalindrome(int start, int end, String s){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}