class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for(int i = 0; i< n; i++){
            if(!visited[i]){
                dfs(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] g, int i, boolean[] visited) {
        for(int j = 0;j<g.length;j++){
            if(g[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(g, j, visited);
            }
        }
    }
}