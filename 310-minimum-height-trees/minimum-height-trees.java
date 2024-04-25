class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return List.of(0);
        Set<Integer>[] g = new Set[n];
        for(int i = 0;i<n;i++){
            g[i] = new HashSet<>();
        }
        for(int[] e : edges){
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(g[i].size() == 1) leaves.add(i);
        }
        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int l : leaves){
                int j = g[l].iterator().next();
                g[j].remove(l);
                if(g[j].size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}