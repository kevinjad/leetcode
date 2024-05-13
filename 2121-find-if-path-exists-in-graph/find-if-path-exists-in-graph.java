class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new List[n];
        for(int i = 0;i<n;i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        //bfs
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while(!q.isEmpty()){
            int p = q.poll();
            if(p == destination) return true;
            for(int c : graph[p]){
                if(c == destination) return true;
                if(!visited[c]){
                    visited[c] = true;
                    q.add(c);
                }
            }
        }
        return false;
    }
}