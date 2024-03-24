class Solution {
    public int snakesAndLadders(int[][] board) {
        boolean leftToRight = true;
        int n = board.length;
        int target = n*n-1;
        int[] translatedBoard = new int[board.length*board[0].length];
        for(int i = n-1;i>=0;i--){
            for(int j = 0; j<board.length;j++){
                if(leftToRight){
                    translatedBoard[(n-1-i)*n+j] = board[i][j];
                } else{
                    translatedBoard[(n-1-i)*n+j] = board[i][n-j-1];
                }
            }
            leftToRight = !leftToRight;
        }

        // 1 1 -1
        //  1 1 1
        //  -1 1 1

        Queue<Integer> q = new LinkedList<>();
        if(translatedBoard[0] > -1){
            q.add(translatedBoard[0] -1);
        } else q.add(0);
        int step = 0;
        boolean[] visited = new boolean[n*n];
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int t = q.poll();
                visited[t] = true;
                if(t >= target) return step;
                for(int j = t+1;j<=t+6 && j<=target;j++){
                    if(translatedBoard[j] != -1){
                        if(!visited[translatedBoard[j]-1]){
                            visited[translatedBoard[j]-1] = true;
                            q.add(translatedBoard[j]-1);
                        }
                    } else{
                        if(!visited[j])
                        {
                            visited[j] = true;
q.add(j);
                        }
                        
                    }

                }
            }
            step++;
        }
        return -1;
    }
}