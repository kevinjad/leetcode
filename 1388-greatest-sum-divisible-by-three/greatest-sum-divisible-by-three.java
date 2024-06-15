class Solution {
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length][3];
        for(int[] d : dp){
            Arrays.fill(d, 0);
        }
        int r = nums[0]%3;
        if(r == 0){
            dp[0][0] = nums[0];
        }else if(r == 1){
            dp[0][1] = nums[0];
        } else {
            dp[0][2] = nums[0];
        }
        
        for(int i = 1;i<nums.length;i++){
            int x = dp[i-1][0]+nums[i];
            int y = dp[i-1][1]+nums[i];
            int z = dp[i-1][2]+nums[i];
            dp[i] = dp[i-1];
            dp[i][x%3] = Math.max(dp[i][x%3], x);
            dp[i][y%3] = Math.max(dp[i][y%3], y);
            dp[i][z%3] = Math.max(dp[i][z%3], z);
        }
        return dp[nums.length-1][0];
    }

    public void printdp(int[] dp){
        for(int n : dp){
            System.out.print(n+" ");
        }
        System.out.println();
    }
}