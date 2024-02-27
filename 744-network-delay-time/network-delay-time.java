class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       int[] cost = new int[n+1];
       Arrays.fill(cost,Integer.MAX_VALUE);
       cost[k] = 0;
       cost[0] = 0;
        for(int i = 1; i<n;i++){
            for(int[] t : times){
                int src = t[0]; int dst = t[1]; int signal = t[2];
                if(cost[src] == Integer.MAX_VALUE) continue;
                cost[dst] = Math.min(cost[dst], cost[src]+signal);
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int c : cost){
            answer = Math.max(answer, c);
        }
        return answer == Integer.MAX_VALUE? -1 : answer;
    }
}