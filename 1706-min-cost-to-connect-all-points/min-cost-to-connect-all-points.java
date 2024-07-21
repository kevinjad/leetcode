class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int ans = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);

        pq.add(new int[]{0, 0});
        while(!pq.isEmpty()){
            int[] e = pq.poll();
            if(visited[e[0]]) continue;
            visited[e[0]] = true;
            ans += e[1];
            for(int i = 0;i<n;i++){
                if(visited[i]) continue;
                int[] p = points[i];
                int[] q = points[e[0]];
                int dist = getDistance(p, q);
                pq.add(new int[]{i, dist});
            }
        }
        return ans;
    }

    public int getDistance(int[] a, int[] b)  {
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
}