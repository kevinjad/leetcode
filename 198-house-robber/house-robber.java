class Solution {
    public int rob(int[] nums) {
        int[] mem = new int[nums.length];
        Arrays.fill(mem,-1);
        return robHelper(nums, mem,0);
    }
    
    public int robHelper(int[] nums, int[] mem, int i){
        if(i >= nums.length) return 0;
        if(mem[i] != -1) return mem[i];
        int result = Math.max(robHelper(nums,mem,i+2)+nums[i], robHelper(nums,mem,i+1));
        mem[i] = result;
        return result;
    }
}