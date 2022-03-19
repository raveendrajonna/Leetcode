class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        util(candidates, 0, target, cur, res);
        return res;
    }
    
    public void util(int[] candidates, int idx, int target, List<Integer> cur, List<List<Integer>> res)
    {
        if(idx == candidates.length)
            return;
        
        if(target == 0)
        {
            res.add(new ArrayList<>(cur));
        }
        
        for(int i=idx; i<candidates.length && target-candidates[i] >= 0 ; i++)
        {
            cur.add(candidates[i]);
            util(candidates, i, target-candidates[i],cur, res);
            cur.remove(cur.size()-1);
        }
    }
}