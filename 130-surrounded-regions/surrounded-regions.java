class Solution {
    public void solve(char[][] board) {
        //from vertical edge do dfs and change O to *
        for(int i = 0; i<board.length; i++){
            if(board[i][0] == 'O') solveDFS(board, i, 0);
            if(board[i][board[0].length-1] == 'O') solveDFS(board, i, board[0].length-1);
        }
        // from horizontal edge do dfs and change O to *
        for(int j = 0;j<board[0].length;j++){
            if(board[0][j] == 'O') solveDFS(board, 0, j);
            if(board[board.length-1][j] == 'O') solveDFS(board,  board.length-1, j);
        }
        //change every other O to X
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        //change * to O
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }
    
    public void solveDFS(char[][] board, int i, int j){
        if(i<0 || j<0 || i>= board.length || j >= board[0].length || board[i][j] == '*' || board[i][j] == 'X') return;
        board[i][j] = '*';
        solveDFS(board, i+1, j);
        solveDFS(board, i-1, j);
        solveDFS(board, i, j+1);
        solveDFS(board, i, j-1);
    }
}