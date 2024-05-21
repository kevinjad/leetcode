class Solution {
    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n+1];
        //dp[i] represents the win for the player who plays it first.
        dp[0] = false;
        dp[1] = false;
        // i know it is not needed but i am explicit, and i know the solution n%2 or n&1 == 0
        for(int i = 2;i<=n;i++){
            for(int j = 1;j<i;j++){
                if(i%j == 0){
                    if(!dp[i-j]){
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[n];
    }
}