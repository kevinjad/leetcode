class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                edges.add(new int[]{i,j,getDistance(points[i],points[j])});
            }
        }
        Collections.sort(edges, (a,b) -> a[2]-b[2]);
        UnionFind uf = new UnionFind(n);
        int count = 0;
        for(int[] e : edges){
            if(uf.find(e[0]) == uf.find(e[1])) continue;
            uf.union(e[0],e[1]);
            count+= e[2];
        }
        return count;
    }

    public int getDistance(int[] a, int[] b)  {
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }

    class UnionFind {   
        int[] parent;
        UnionFind(int n) {
            this.parent = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }		
        public void union(int a, int b) {
            parent[find(a)] = parent[find(b)];
        }
        public int find(int x) {
            if(parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}