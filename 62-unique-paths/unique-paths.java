class Solution {
    public int uniquePaths(int m, int n) {
        int[][] mem = new int[m][n];
        return uniquePathsHelper(0, 0, m, n, mem);
    }
    
    public int uniquePathsHelper(int i, int j, int m, int n, int[][] mem){
        if(i >= m || j>=n) return 0;
        if(i == m-1 && j == n-1) return 1;
        if(mem[i][j] != 0) return mem[i][j];
        int ans = uniquePathsHelper(i+1, j, m, n, mem)+uniquePathsHelper(i, j+1, m, n, mem);
        mem[i][j] = ans;
        return ans;
    }
}