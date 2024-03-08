class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] lowestFromLeft = new int[prices.length];
        int mi = Integer.MAX_VALUE;
        lowestFromLeft[0] = mi;
        for(int i = 1;i<n;i++){
            lowestFromLeft[i] = Math.min(lowestFromLeft[i-1], prices[i-1]);
        }
        int maxProfit = 0;
        for(int i = 1;i<n;i++){
            maxProfit = Math.max(maxProfit, prices[i]-lowestFromLeft[i]);
        }
        return maxProfit;
    }
}