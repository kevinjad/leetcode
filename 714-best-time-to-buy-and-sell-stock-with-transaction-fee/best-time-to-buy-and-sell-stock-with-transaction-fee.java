class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[] s0 = new int[prices.length];
        int[] s1 = new int[prices.length];

        s0[0] = 0;
        s1[0] = -prices[0];

        for(int i = 1;i<prices.length;i++){
            s0[i] = Math.max(s0[i-1], s1[i-1]-fee+prices[i]);
            s1[i] = Math.max(s1[i-1], s0[i-1]-prices[i]);
        }
        return s0[prices.length-1];
    }
}