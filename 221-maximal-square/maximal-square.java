class Solution {
    public int maximalSquare(char[][] matrix) {
        int width = matrix.length;
        int length = matrix[0].length;
        int[][] dp = new int[width+1][length+1];
        int max = 0;
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j],dp[i+1][j]),dp[i][j+1])+1;
                    max = Math.max(max,dp[i+1][j+1]);
                }
            }
        }
        return max*max;
    }
}