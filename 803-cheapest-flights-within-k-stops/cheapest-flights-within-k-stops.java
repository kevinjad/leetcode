class Solution {
    // public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    //     int[] main = new int[n];
    //     Arrays.fill(main, Integer.MAX_VALUE);
    //     main[src] = 0;
    //     for(int i = 0;i<=k;i++){
    //         int[] temp = Arrays.copyOf(main,n);
    //         for(int[] f : flights){
    //             if(main[f[0]] == Integer.MAX_VALUE) continue;
    //             if(main[f[0]]+f[2] < main[f[1]]) temp[f[1]] = main[f[0]]+f[2];
    //         }
    //         main = temp;
    //     }
    //     return main[dst] == Integer.MAX_VALUE ? -1 : main[dst];
    // }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
    {
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        for(int i=0;i<=K;i++)
        {
            int[] temp= Arrays.copyOf(cost,n);
            for(int[] f: flights)
            {
                int curr=f[0],next=f[1],price=f[2];
                if(cost[curr]==Integer.MAX_VALUE)
                    continue;
                temp[next]=Math.min(temp[next],cost[curr]+price);
            }
            cost=temp;
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }
}