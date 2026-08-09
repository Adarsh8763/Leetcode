class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[n1];
        int[] nextMax = new int[n2];

        for(int i=0; i<n2; i++){
            map.put(nums2[i], i);
        }

        for(int i=n2-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                nextMax[i] = stack.peek();
            }
            else{
                nextMax[i] = -1;
            }
            stack.push(nums2[i]);
        }

        for(int i=0; i<n1; i++){
            int idx = map.get(nums1[i]);
            ans[i] = nextMax[idx]; 
        }

        return ans;
    }
}