class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(0, target, curr, res, candidates);
        return res;
    }

    private void backtrack(int idx, int target, List<Integer> curr, List<List<Integer>> res, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        int n = candidates.length;
        if (idx == n) {
            return;
        }

        for (int i = idx; i < n; i++) {
            // i == idx -> Hr ek recursive call ka pahala elem aaye ho accept kr lo and agar pahala cond i == idx chal gya then it doesn't care about cand[i] != cand[i-1]. So, index bound of nhi hoga
            // Next level pr i == idx true ho jyega so if cand[i] == cand[i-1], then also chalega. So, next level pr same elem bhi ho ga tb bhi koi dikaat nhi h
            // Same lvl pr if i != idx and cand[i] == cand[i-1], then skip
            if((i == idx || candidates[i] != candidates[i-1]) && candidates[i] <= target ){
                curr.add(candidates[i]);
                backtrack(i+1, target - candidates[i], curr, res, candidates);
                curr.remove(curr.size() - 1);
            }
        }
    }

}