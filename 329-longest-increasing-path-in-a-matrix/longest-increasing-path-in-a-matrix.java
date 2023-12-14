class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int[][] mem = new int[matrix.length][matrix[0].length];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                max = Math.max(max, liphelper(matrix, i, j, mem));
            }
        }
        return max;
    }

    public int liphelper(int[][] matrix, int i, int j, int[][] mem){
        if(mem[i][j] != 0) return mem[i][j];
        int pathLength = 1;
        int max = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] dir : dirs){
            if(i+dir[0] >= 0 && i+dir[0] <matrix.length && j+dir[1] >= 0 && j+dir[1] < matrix[0].length && matrix[i][j] < matrix[i+dir[0]][j+dir[1]]){
                max = Math.max(max, liphelper(matrix, i+dir[0], j+dir[1], mem));
            }
        }
        mem[i][j] = pathLength+max;
        return mem[i][j];
    }
}