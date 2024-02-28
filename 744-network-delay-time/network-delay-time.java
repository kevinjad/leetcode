class Solution {
    public int networkDelayTime(int[][] times, int N, int k) {
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
        dist[0] = 0;
        boolean[] visited = new boolean[N+1];
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] t : times){
            adj.putIfAbsent(t[0], new ArrayList<>());
            adj.get(t[0]).add(new int[]{t[1],t[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] e = pq.poll();
            int x = e[0];
            visited[x] = true;
            dist[x] = Math.min(dist[x], e[1]);
            if(adj.get(x) == null) continue;
            for(int[] yy : adj.get(x)){
                int d = yy[1];
                if(dist[yy[0]] > d+e[1] && !visited[yy[0]])
                pq.add(new int[]{yy[0],d+e[1]});
            }
        }
        int minVal = Integer.MIN_VALUE;
        for(int p : dist){
            minVal = Math.max(minVal, p);
        }
        return minVal == Integer.MAX_VALUE ? -1 : minVal;
    }
}