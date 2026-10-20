class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] seen = new boolean[nums.length];

        permutations(nums, seen, curr, res);
        return res;
    }
    private void permutations(int[] nums, boolean[] seen, List<Integer> curr, List<List<Integer>> res){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++){
            // If seen, then skip
            if(seen[i]){
                continue;
            }

            // Avoid duplicate from the same level
            if(i > 0 && nums[i] == nums[i-1] && seen[i-1] == false){
                continue;
            }

            curr.add(nums[i]);
            seen[i] = true;

            permutations(nums, seen, curr, res);

            curr.remove(curr.size()-1);
            seen[i] = false;
        }
    }
    
}