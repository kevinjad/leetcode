class Solution {
    public int integerBreak(int n) {
        /*
        1 5
        2 4
        3 3
        4 2


        1 3
        2 2
         */

        if(n == 2) return 1;
        if(n == 3) return 2;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i = 4;i<=n;i++){
            int maxp = 0;
            for(int j = 1;j<=i/2;j++){
                maxp = Math.max(maxp, dp[j]*dp[i-j]);
            }
            dp[i] = maxp;
        }
        return dp[n];
    }
}