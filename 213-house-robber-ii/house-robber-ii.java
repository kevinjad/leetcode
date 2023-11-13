class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] mem = new int[nums.length];
        int[] mem2 = new int[nums.length];
        Arrays.fill(mem,-1);
        Arrays.fill(mem2,-1);
        return Math.max(robHelper(nums, mem,0, nums.length-1), robHelper(nums, mem2,1, nums.length));
    }

    public int robHelper(int[] nums, int[] mem, int i, int len){
        if(i >= len) return 0;
        if(mem[i] != -1) return mem[i];
        int result = Math.max(robHelper(nums,mem,i+2, len)+nums[i], robHelper(nums,mem,i+1,len));
        mem[i] = result;
        return result;
    }
}