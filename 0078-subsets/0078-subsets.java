class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        subsequences(nums, 0, curr, res);
        return res;
    }
    private void subsequences(int[] nums, int idx, List<Integer> curr, List<List<Integer>> res){
        if(idx == nums.length){
            // We are creating copy bcoz if curr changes then that change will also we seen in res if reference is passed
            res.add(new ArrayList<>(curr));
            return;
        }

        //include
        curr.add(nums[idx]);
        // pick
        subsequences(nums, idx+1, curr, res);

        //remove
        curr.remove(curr.size()-1);
        // noPick
        subsequences(nums, idx+1, curr, res);
    }
}