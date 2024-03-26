class Solution {
    public int maxProfit(int[] prices) {
        int currRise = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int profit = 0;
        for(int p : prices){
            if(p<max){
                profit += (max-min);
                min = p;
                max = p;
            } else{
                min = Math.min(min,p);
                max = Math.max(max,p);
            }
        }
        return profit+(max-min);
    }
}