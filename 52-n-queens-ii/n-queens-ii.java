class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        helper(board,0,n);
        return count;
    }

    public void helper(int[][] board, int i, int n){
        if(i>=n){
            count++;
            return;
        }
        for(int j = 0;j<n;j++){
            if(canPlace(i,j,board,n)){
                board[i][j] = 1;
                helper(board,i+1,n);
            }
            board[i][j] = 0;
        }
    }

    public boolean canPlace(int i, int j, int[][] board, int n){
        int I,J;
        for(I = 0;I<=i;I++){
            if(board[I][j] == 1) return false;
        }
        I = i;
        J = j;
        while(I>=0 && J>=0){
            if(board[I][J] == 1) return false;
            I--;
            J--;
        }
        I = i;
        J = j;
        while(I>=0 && J<n){
            if(board[I][J] == 1) return false;
            I--;
            J++;
        }
        return true;
    }
}