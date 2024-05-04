class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(isConnected[i][j] == 1){
                    union(parent, i, j);
                }
            }
        }
        int result = 0;
        for(int i = 0;i<n;i++){
            if(parent[i] == i) result++;
        }
        return result;
    }

    public void union(int[] parent, int i, int j){
        int a = find(parent, i);
        int b = find(parent, j);
        parent[a] = b;
    }

    public int find(int[] parent, int i){
        if(i == parent[i]) return i;
        else return find(parent, parent[i]);
    }
}