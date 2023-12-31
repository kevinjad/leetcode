class Solution {
   public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int[] vis = new int[n];
        Arrays.fill(vis, Integer.MAX_VALUE);
        for(int[] f : flights) {
            map.putIfAbsent(f[0], new ArrayList<>());
            map.get(f[0]).add(new int[]{f[1],f[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        int min = Integer.MAX_VALUE;

        int step = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0;i<size;i++){
                int[] e = q.poll();
                if(e[0] == dst) {
                    min = Math.min(e[1],min);
                }
                if(!map.containsKey(e[0])) continue;
                for(int[] c : map.get(e[0])){
                    if(vis[c[0]] > e[1]+c[1] && min > e[1]+c[1]){
                        q.offer(new int[]{c[0],c[1]+e[1]});
                        vis[c[0]] = e[1]+c[1];
                    }
                }
            }
            if(step++ > k) break;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}