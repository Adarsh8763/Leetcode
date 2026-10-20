class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        subsequences(nums, 0, curr, res);
        return res;
    }
    private void subsequences(int[] nums, int idx, List<Integer> curr, List<List<Integer>> res){
        if(idx == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        //include
        curr.add(nums[idx]);
        // pick
        subsequences(nums, idx+1, curr, res);

        //remove
        curr.remove(curr.size()-1);
        // Avoid all duplicates 
        while((idx+1) < nums.length && nums[idx] == nums[idx+1]){
            idx++;
        }
        // noPick
        subsequences(nums, idx+1, curr, res);
    }
}