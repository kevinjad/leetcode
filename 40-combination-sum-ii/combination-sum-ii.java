class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> l = new LinkedList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, l, result);
        return result;
    }

    public void helper(int[] candidates, int i, int target, LinkedList<Integer> ll, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(ll));
            return;
        }
        if(target<0) return;
        for(int j = i;j<candidates.length; j++){
            if(j>i && candidates[j] == candidates[j-1]) continue;
            ll.add(candidates[j]);
            helper(candidates, j+1, target-candidates[j], ll, result);
            ll.removeLast();
        }
    }
}