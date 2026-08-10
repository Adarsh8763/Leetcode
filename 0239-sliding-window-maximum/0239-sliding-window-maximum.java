class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        // Deque will store indices not values
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[n-k+1]; 

        // Set up deque for first k elems
        for(int i=0; i<k; i++){
            //Remove all smaller elem from back
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        result[0] = nums[deque.peekFirst()];

        //Process the remaining elems
        for(int i=k; i<n; i++){
            //Remove the elem which has slid out of window
            if(deque.peekFirst() < i-k+1){
                deque.pollFirst();
            }

            //Remove all element smaller than the incoming elem
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }

            //Add current elem idx
            deque.offerLast(i);

            result[i-k+1] = nums[deque.peekFirst()];
        }
        return result;
    }
}