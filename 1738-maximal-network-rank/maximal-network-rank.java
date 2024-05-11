class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Set<Integer>[] rs= new HashSet[n];
        for(int i = 0;i<n;i++){
            rs[i] = new HashSet<Integer>();
        }
        for(int i = 0;i<roads.length;i++){
            int[] a = roads[i];
            if(rs[a[0]] == null) rs[a[0]] = new HashSet<Integer>();
            if(rs[a[1]] == null) rs[a[1]] = new HashSet<Integer>();
            rs[a[0]].add(a[1]);
            rs[a[1]].add(a[0]);
        }
        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i == j) continue;
                int val = rs[i].size() + rs[j].size();
                if(rs[i].contains(j)) val--;
                max = Math.max(max, val);
            }
        }
        return max;
    }
}