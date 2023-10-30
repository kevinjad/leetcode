class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<Integer>[] graph = new List[n];
        for(int i = 0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0;i<n;i++){
            graph[edges[i][0]-1].add(edges[i][1]-1);
            graph[edges[i][1]-1].add(edges[i][0]-1);
        }

        boolean[] onCurrent = new boolean[n];
        boolean[] visited = new boolean[n];
        Set<Integer> cycleList = new HashSet<>();
        for(int i = 0; i<n;i++){
            if(findRedundantConnectionCycleDFS(i, -1,graph, onCurrent, visited, cycleList)){
                for(int j = n-1; j>=0;j--){
                    if(cycleList.contains(edges[j][0]-1) && cycleList.contains(edges[j][1]-1)){
                        return edges[j];
                    }
                }
            }
        }
        return new int[]{};
    }

    private int cycleStart = -1;
    private boolean findRedundantConnectionCycleDFS(int i, int prev,List<Integer>[] graph, boolean[] onCurrent, boolean[] visited, Set<Integer> cycleList) {
        if(visited[i]) return false;
        if(onCurrent[i]){
            cycleStart = i;
            return true;
        }
        onCurrent[i] = true;
        for(int c : graph[i]){
            if(c == prev) continue;
            if(findRedundantConnectionCycleDFS(c, i,graph, onCurrent, visited,cycleList)){
                if(cycleStart != -1){
                    cycleList.add(i);
                }
                if(cycleStart == i) cycleStart = -1;
                return true;
            }
        }
        onCurrent[i] = false;
        visited[i] = true;

        return false;
    }
}