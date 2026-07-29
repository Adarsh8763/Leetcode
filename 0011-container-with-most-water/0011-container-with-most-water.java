class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxArea = 0;

        while(left < right){
            int dist = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = dist * minHeight;
            maxArea = Math.max(maxArea, area);

            if(height[left] > height[right]) right--;
            else left++;
        }
        return maxArea;
    }
}