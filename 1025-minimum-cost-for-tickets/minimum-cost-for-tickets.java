class Solution {
    public int mincostTickets(int[] days, int[] cost) {
        Set<Integer> dayset = new HashSet<Integer>();
        for(int d : days) dayset.add(d);
        int[] dp = new int[366];
        for(int i = 1; i<366;i++){
            if(!dayset.contains(i)) {
                dp[i] = dp[i-1];
                continue;
            }
            int before7 = i-7 < 0 ? 0 : i-7;
            int before30 = i-30 < 0 ? 0 : i-30;
            dp[i] = Math.min(Math.min(dp[i-1]+cost[0], dp[before7]+cost[1]),dp[before30]+cost[2]);
        }
        return dp[365];
    }
}