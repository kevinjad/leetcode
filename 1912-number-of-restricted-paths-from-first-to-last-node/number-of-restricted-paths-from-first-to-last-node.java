class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        List<int[]>[] graph = new List[n+1];
        for(int i = 0;i<=n;i++){
            graph[i] = new ArrayList<int[]>();
        }
        for(int[] e : edges) {
            graph[e[0]].add(new int[]{e[1],e[2]});
            graph[e[1]].add(new int[]{e[0],e[2]});
        }

        int[] dist = dijkstra(n, graph);
        boolean[] visited = new boolean[n+1];
        Integer[] mem = new Integer[n+1];
        return dfs(graph, n, -1, visited, dist, mem);
    }

    public int dfs(List<int[]>[] graph, int i, int w, boolean[] visited, int[] dist, Integer[] mem) {
        if(mem[i] != null) return mem[i];
        if(i == 1) return 1;
        visited[i] = true;
        int ans = 0;
        for(int[] e : graph[i]){
            if(!visited[e[0]] && w<dist[e[0]]){
                ans = (ans + dfs(graph, e[0], dist[e[0]], visited, dist, mem)) % 1000000007;
            }
        }
        visited[i] = false;
        mem[i] = ans;
        return ans;
    }

    public int[] dijkstra(int n, List<int[]>[] graph) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[n] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.offer(new int[]{n, 0});
        while(!q.isEmpty()){
            int[] e = q.poll();
            int u = e[0];
            int w = e[1];
            for(int[] c : graph[u]){
                if(dist[u]+c[1] < dist[c[0]]){
                    dist[c[0]] = dist[u]+c[1];
                    q.offer(new int[] {c[0], dist[c[0]]});
                }
            } 
        }
        return dist;
    }
}