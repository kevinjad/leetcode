class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] main = new int[n];
        Arrays.fill(main, Integer.MAX_VALUE);
        main[src] = 0;
        for(int i = 0;i<=k;i++){
            int[] temp = Arrays.copyOf(main,n);
            for(int[] f : flights){
                if(main[f[0]] == Integer.MAX_VALUE) continue;
                temp[f[1]] = Math.min(main[f[0]]+f[2], temp[f[1]]);
            }
            main = temp;
        }
        return main[dst] == Integer.MAX_VALUE ? -1 : main[dst];
    }
}