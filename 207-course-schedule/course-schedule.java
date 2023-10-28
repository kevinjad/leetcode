class Solution {
   public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for(int i = 0;i<numCourses;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] a: prerequisites){
            graph[a[0]].add(a[1]);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] onCurrent = new boolean[numCourses];
        
        for(int i = 0; i<numCourses; i++){
            if(checkCycle(i, graph, visited, onCurrent)) return false;
        }
        return true;
    }

    private boolean checkCycle(int i, List<Integer>[] graph, boolean[] visited, boolean[] onCurrent) {
        if(visited[i]) return false;
        if(onCurrent[i]) return true;
        
        onCurrent[i] = true;
        
        for (int v : graph[i]){
            if(checkCycle(v, graph, visited, onCurrent)) return true;
        }
        onCurrent[i] = false;
        visited[i] = true;
        return false;
    }
}