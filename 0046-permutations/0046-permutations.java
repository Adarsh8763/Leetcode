class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        permutations(nums, curr, res);
        return res;
    }
    private void permutations(int[] nums, List<Integer> curr, List<List<Integer>> res){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(curr.contains(nums[i])){
                continue;
            }

            curr.add(nums[i]);
            permutations(nums, curr, res);
            curr.remove(curr.size()-1);
        }
    }
}