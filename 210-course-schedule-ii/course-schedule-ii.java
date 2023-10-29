class Solution {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for(int i = 0;i<numCourses;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] a: prerequisites){
            graph[a[0]].add(a[1]);
        }
        LinkedList<Integer> order = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] onCurrent = new boolean[numCourses];

        for(int i = 0;i<numCourses;i++){
            if(hasCycle(i, graph, order, numCourses, visited, onCurrent)) return new int[]{};
        }
        // Collections.reverse(order);
        return order.stream().mapToInt(Number::intValue).toArray();
    }

    public static boolean hasCycle(int i, List<Integer>[] graph, LinkedList<Integer> path, int numCourses, boolean[] visited, boolean[] onCurrent){
        if(visited[i]) return false;
        if(onCurrent[i]) return true;
        
        onCurrent[i] = true;
        for(int c : graph[i]){
            if(hasCycle(c, graph, path, numCourses, visited, onCurrent)) return true;
        }
        onCurrent[i] = false;
        visited[i] = true;
        path.add(i);
        return false;
    }
}