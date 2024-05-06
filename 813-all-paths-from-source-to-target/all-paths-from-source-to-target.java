class Solution {
    int count = 0;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        temp.add(0);
        dfs(graph, 0, visited ,graph.length-1, temp, result);
        return result;
    }

    public void dfs(int[][] g, int i, boolean[] visited, int n, LinkedList<Integer> temp, List<List<Integer>> result) {
        for(int j = 0;j<g[i].length;j++){
            int v = g[i][j];
            temp.add(v);
            if(v == n) result.add(new ArrayList<>(temp));
            dfs(g, g[i][j], visited, n, temp, result);
            temp.removeLast();
        }
    }
}