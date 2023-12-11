class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap[] mem = new HashMap[nums.length];
        for(int i = 0;i<nums.length;i++) mem[i] = new HashMap<Integer,Integer>();
        return findTargetSumWaysHelper(nums, target, 0, mem);
    }

    public int findTargetSumWaysHelper(int[] nums, int target, int i, HashMap<Integer,Integer>[] mem){
        if(target == 0 && i >= nums.length) return 1;
        if(i>= nums.length) return 0;
        if(mem[i].containsKey(target)) return mem[i].get(target);
        mem[i].put(target, findTargetSumWaysHelper(nums, target-nums[i], i+1, mem) + findTargetSumWaysHelper(nums, target+nums[i], i+1, mem));
        return mem[i].get(target);
    }
}