class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        //prepare adj list
        List<Integer>[] adj = new List[quiet.length];
        int[] indegree = new int[quiet.length];
        int[] answer = new int[quiet.length];
        for(int i = 0;i<quiet.length;i++){
            answer[i] = i;
        }
        for(int[] r : richer){
            indegree[r[1]]++;
            if(adj[r[0]] == null){
                adj[r[0]] = new ArrayList<>();
            }
            adj[r[0]].add(r[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i< quiet.length;i++){
            if(indegree[i] == 0) q.offer(i);
        }
        int[] ordered = new int[quiet.length];
        int i = 0;
        while(!q.isEmpty()){
            int e = q.poll();
            ordered[i++] = e;

            if(adj[e] == null) continue;
            for(int x : adj[e]){
                if(quiet[answer[e]] < quiet[answer[x]]){
                    answer[x] = answer[e];
                }
                indegree[x]--;
                if(indegree[x]==0) q.offer(x);
            }
        }
        return answer;
    }
}