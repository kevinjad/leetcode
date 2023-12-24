class Solution {
    
    public int networkDelayTime(int[][] times, int n, int k) {
        // signals
        int[][] signals = new int[n+1][n+1];
        //build adjacency list
        List<Integer>[] network = new List[n+1];
        for(int i = 0;i<=n;i++){
            network[i] = new ArrayList<>();
        }

        for(int[] element : times){
            network[element[0]].add(element[1]);
            signals[element[0]][element[1]] = element[2];
        }

        //visitor track
        boolean[] visited = new boolean[n+1];
        int[] mindist = new int[n+1];
        Arrays.fill(mindist, Integer.MAX_VALUE);
        networkDelayTimeDFS(k, network, signals, visited, mindist, 0);
        for(int i = 1;i<=n;i++){
            if(!visited[i]) return -1;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1;i<=n;i++) max = Math.max(max,mindist[i]);

        return max;
    }

    public void networkDelayTimeDFS(int i, List<Integer>[] network, int[][] times, boolean[] visited, int[] minDist, int weight){
        // if(visited[i]) return 0;
        visited[i] = true;
        minDist[i] = weight;
        int min = weight;
        if(network[i] == null || network[i].isEmpty()) return;
        for(int node : network[i]){
            if(minDist[node] > weight+times[i][node]){
                networkDelayTimeDFS(node, network, times, visited, minDist,weight+times[i][node] );
            }
        }
    }
}