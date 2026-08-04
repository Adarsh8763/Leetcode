class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        //Right smallest nearest
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                right[i] = stack.peek();
            }
            else{
                right[i] = n;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            stack.pop();
        }

        //Left smallest nearest
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                left[i] = stack.peek();
            }
            else{
                left[i] = -1;
            }
            stack.push(i);
        }

        int maxArea = 0;
        for(int i=0; i<n; i++){
            int width = right[i]-left[i]-1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}