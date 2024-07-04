class Solution {
    // public int networkDelayTime(int[][] times, int N, int k) {
    //     int[] dist = new int[N+1];
    //     Arrays.fill(dist,Integer.MAX_VALUE);
    //     dist[k] = 0;
    //     dist[0] = 0;
    //     boolean[] visited = new boolean[N+1];
    //     Map<Integer, List<int[]>> adj = new HashMap<>();
    //     for(int[] t : times){
    //         adj.putIfAbsent(t[0], new ArrayList<>());
    //         adj.get(t[0]).add(new int[]{t[1],t[2]});
    //     }
    //     PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
    //     pq.add(new int[]{k,0});
    //     while(!pq.isEmpty()){
    //         int[] e = pq.poll();
    //         int x = e[0];
    //         if (visited[x]) continue;
    //         visited[x] = true;
    //         dist[x] = Math.min(dist[x], e[1]);
    //         if(adj.get(x) == null) continue;
    //         for(int[] yy : adj.get(x)){
    //             int d = yy[1];
    //             if(dist[yy[0]] > d+e[1] && !visited[yy[0]])
    //             pq.add(new int[]{yy[0],d+e[1]});
    //         }
    //     }
    //     int minVal = Integer.MIN_VALUE;
    //     for(int p : dist){
    //         minVal = Math.max(minVal, p);
    //     }
    //     return minVal == Integer.MAX_VALUE ? -1 : minVal;
    // }

    public int networkDelayTime(int[][] times, int N, int k) {
        int[][] signal = new int[N+1][N+1];
        List<Integer>[] graph = new List[N+1];
        for(int i = 0;i<=N;i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int[] t : times){
            graph[t[0]].add(t[1]);
            signal[t[0]][t[1]] = t[2];
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (a[1]-b[1]));
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] e = pq.poll();
            int s = e[0]; int w = e[1];
            for(int c : graph[s]){
                if(dist[c] >  w+signal[s][c]){
                    dist[c] = w+signal[s][c];
                    pq.add(new int[]{c, dist[c]});
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int p : dist){
            max = Math.max(max, p);
        }
        return max == Integer.MAX_VALUE ? -1 : max;

    }
    public int networkDelayTime1(int[][] times, int N, int k) {
        int[] dist = new int[N+1]; // min dist from k to 1 to n
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        dist[k] = 0;
        for(int i = 0;i<N;i++){
            for(int[] t : times){
                int s = t[0]; int d = t[1]; int w = t[2];
                if(dist[s] == Integer.MAX_VALUE) continue;
                dist[d] = Math.min(dist[d], dist[s]+w);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int p : dist){
            max = Math.max(max, p);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
        
    }

    // public int networkDelayTime(int[][] times, int N, int k) {
    //     int[] dist = new int[N+1];
    //     Arrays.fill(dist,Integer.MAX_VALUE);
    //     dist[k] = 0;
    //     dist[0] = 0;
    //     //non intuitive
    //     for(int i = 0; i<N;i++){
    //         for(int[] e : times){
    //             int m = e[0]; int n = e[1]; int signal = e[2];
    //             if(dist[m] == Integer.MAX_VALUE) continue;
    //             dist[n] = Math.min(dist[n],dist[m]+signal);
    //         }
    //     }
    //     int minVal = Integer.MIN_VALUE;
    //     for(int p : dist){
    //         minVal = Math.max(minVal, p);
    //     }
    //     return minVal == Integer.MAX_VALUE ? -1 : minVal;
    // }

//     public int networkDelayTime(int[][] times, int N, int K) {
//     Map<Integer, List<int[]>> graph = new HashMap<>();
//     for (int[] edge: times) {
//         graph.putIfAbsent(edge[0], new ArrayList<>());
//         graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
//     }
//     PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
//     boolean[] visited = new boolean[N + 1];
//     int[] minDis = new int[N + 1];
//     Arrays.fill(minDis, Integer.MAX_VALUE);
//     minDis[K] = 0;
//     pq.offer(new int[]{0, K});
//     int max = 0;
//     while (!pq.isEmpty()) {
//         int[] curr = pq.poll();
//         int currNode = curr[1];
//         if (visited[currNode]) continue;
//         visited[currNode] = true;
//         int currDis = curr[0];
//         max = currDis;
//         N--;
//         if (!graph.containsKey(currNode)) continue;
//         for (int[] next : graph.get(currNode)) {
//             if (!visited[next[0]] && currDis + next[1] < minDis[next[0]])
//                 pq.offer(new int[]{currDis + next[1], next[0]});
//         }
//     }
//     return N == 0 ? max : -1;
// }
}