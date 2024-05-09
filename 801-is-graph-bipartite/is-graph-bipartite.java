class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        for(int i = 0;i<n;i++){
            int[] col = new int[n];
            Arrays.fill(col, -1);
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{i,1});
            while(!q.isEmpty()){
                int[] e = q.poll();
                if(col[e[0]] == -1){
                    col[e[0]] = e[1];
                    for(int c : graph[e[0]]){
                        q.add(new int[]{c, e[1]^1});
                    }
                } else {
                    if(e[1] != col[e[0]]) return false;
                }
            }
        }
        
        return true;
    }
}