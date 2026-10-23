class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(0, target, curr, res, candidates);
        return res;
    }
    private void backtrack(int idx, int target, List<Integer> curr, List<List<Integer>> res, int[] candidates){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(idx == candidates.length){
            return;
        }

        // Pick
        if(candidates[idx] <= target){
            curr.add(candidates[idx]);
            backtrack(idx, target-candidates[idx], curr, res, candidates);
            curr.remove(curr.size()-1);
        }

        // noPick
        backtrack(idx+1, target, curr, res, candidates);
    }
}