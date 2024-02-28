class Solution {
    public int networkDelayTime(int[][] times, int N, int k) {
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
        dist[0] = 0;
        //non intuitive
        for(int i = 0; i<N;i++){
            for(int[] e : times){
                int m = e[0]; int n = e[1]; int signal = e[2];
                if(dist[m] == Integer.MAX_VALUE) continue;
                dist[n] = Math.min(dist[n],dist[m]+signal);
            }
        }
        int minVal = Integer.MIN_VALUE;
        for(int p : dist){
            minVal = Math.max(minVal, p);
        }
        return minVal == Integer.MAX_VALUE ? -1 : minVal;
    }
}