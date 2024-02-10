class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> grid[a[0]][a[1]]));
        int level = 0;
        queue.add(new int[]{0,0});
        int[][] directions = {{0,-1},{0,1}, {1,0}, {-1,0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while(!queue.isEmpty()){
            int[] a = queue.poll();
            level = Math.max(level, grid[a[0]][a[1]]);

            if (a[0] == n - 1 && a[1] == n - 1){
                break;
            }

            for(int[] d : directions){
                int x = a[0] + d[0];
                int y = a[1] + d[1];
                if (!(x < 0|| x > n - 1 || y < 0 || y > n - 1)  && !visited[x][y]){
                    queue.add(new int[]{x, y});
                }
                
            }
            visited[a[0]][a[1]] = true;
        }
        return level;
    }
}