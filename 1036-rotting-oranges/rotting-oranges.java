class Solution {
     public static int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int count = 0;
        for(int i = 0;i< grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) q.offer(new int[]{i, j});
            }
        }
        if(fresh == 0) return 0;
        while(!q.isEmpty() && fresh > 0){
            count++;
            int size = q.size();
            for(int i = 0; i<size;i++){
                int[] p = q.poll();
                if (p[0] + 1 < grid.length && grid[p[0] + 1][p[1]] == 1) {
                    fresh--;
                    grid[p[0] + 1][p[1]] = 2;
                    q.offer(new int[]{p[0] + 1, p[1]});
                }
                if (p[0] - 1 >= 0 && grid[p[0] - 1][p[1]] == 1) {
                    fresh--;
                    grid[p[0] - 1][p[1]] = 2;
                    q.offer(new int[]{p[0] - 1, p[1]});
                }
                if (p[1] + 1 < grid[0].length && grid[p[0]][p[1] + 1] == 1) {
                    fresh--;
                    grid[p[0]][p[1] + 1] = 2;
                    q.offer(new int[]{p[0], p[1] + 1});
                }
                if (p[1] - 1 >= 0 && grid[p[0]][p[1] - 1] == 1) {
                    fresh--;
                    grid[p[0]][p[1] - 1] = 2;
                    q.offer(new int[]{p[0], p[1] - 1});
                }
                if(fresh == 0) return count;
            }
        }
        return -1;
    }
}