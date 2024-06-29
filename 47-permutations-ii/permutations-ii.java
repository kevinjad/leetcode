class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> l = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
            permute(nums, l, result, used);
        
        
        return result;
    }

    public void permute(int[] nums, LinkedList<Integer> l, List<List<Integer>> ans, boolean[] used){
        
        if(l.size() == nums.length){
            ans.add(new ArrayList<>(l));
            return;
        }        
        for(int j = 0;j<nums.length;j++){
            if(used[j]) continue;
            if(j>0 && nums[j] == nums[j-1] && !used[j-1]) continue;
            l.add(nums[j]);
            used[j] = true;
            permute(nums, l, ans, used);
            used[j] = false;
            l.removeLast();
        }
        
    }
}