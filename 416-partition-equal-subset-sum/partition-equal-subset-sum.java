class Solution {
   public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum+=n;
        }
        if(sum%2 != 0) return false;
        int[][] mem = new int[nums.length][(sum/2)+1];
        return canPartitionHelper(nums, 0, sum/2, mem);
    }

    public boolean canPartitionHelper(int[] nums, int i, int sum, int[][] mem){
        if(i >= nums.length) return false;
        if(sum == 0) return true;
        if(sum < 0) return false;
        if(mem[i][sum] == 1) return true;
        if(mem[i][sum] == -1) return false; 
        boolean ans = canPartitionHelper(nums, i+1, sum, mem) || canPartitionHelper(nums, i+1, sum-nums[i], mem);
        if(ans) mem[i][sum] = 1;
        else mem[i][sum] = -1;
        return ans;
    }
}