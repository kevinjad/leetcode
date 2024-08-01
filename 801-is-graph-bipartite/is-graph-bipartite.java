class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] odd = new int[n]; // 0 not visited 1 odd -1 even
        for(int i = 0; i<n; i++){
            if(odd[i] != 0) continue;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            odd[i] = -1;
            //unique way of preventing cycles (check in foring the children before adding to the visit tracker)
            while(!q.isEmpty()){
                int e = q.poll();
                for(int c : graph[e]){
                    if(odd[c] == 0){
                    q.add(c);
                    odd[c] = odd[e]*-1;
                    } else {
                    if(odd[c] == odd[e]) return false;
                    }
                }
            }
        }
        return true;
    }
}