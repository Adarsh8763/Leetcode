class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int maxPara = 0;
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && ch == ')' && stack.peek() == '('){
                stack.pop();
            }
            if(ch == '('){
                stack.push(ch);
            }
            maxPara = Math.max(maxPara, stack.size());
        }

        return maxPara;

    }
}