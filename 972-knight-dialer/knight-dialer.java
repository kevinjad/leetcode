class Solution {
    public int knightDialer(int N) {
        int[][] reach = new int[][]{
            { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, 
            { }, { 0, 1, 7 }, { 2, 6 }, { 1, 3 }, { 2, 4 }
        };
        int mod = (int) Math.pow(10, 9) + 7;
        int[][] dp = new int[N][10];
        for(int i = 0;i<10;i++) dp[0][i] = 1;

        for(int i = 1;i<N;i++){
            for(int j = 0;j<10;j++){
                for(int k : reach[j]){
                    dp[i][j] = (dp[i][j]+dp[i-1][k])%mod;
                }
            }
        }
        long total = 0;
        for(int i = 0;i<10;i++) total = (total+dp[N-1][i])%mod;
        return (int) total;
    }
}