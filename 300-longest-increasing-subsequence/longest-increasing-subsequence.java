class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] mem = new int[nums.length];
        Arrays.fill(mem, -1);
        int max = 0;
        for(int i = 0; i<nums.length;i++){
            max = Math.max(max,lengthOfLISHelper(nums, i, mem));
        }
        return max;
    }

    public int lengthOfLISHelper(int[] nums, int i, int[] mem){
        if(i>=nums.length) return 0;
        if(mem[i] != -1) return mem[i];
        int max = 1;
        for(int j = i+1;j<nums.length;j++){
            if(nums[i] < nums[j]){
                max = Math.max(lengthOfLISHelper(nums, j, mem)+1,max);
            }
        }
        mem[i] = max;
        return max;
    }
}