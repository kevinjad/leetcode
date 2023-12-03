class Solution {
    public int maxProfit(int[] prices) {
        int[][] mem = new int[3][prices.length];
        for(int[] a : mem){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        return maxProfitHelper(prices, 0, 0, mem);
    }

    public  int maxProfitHelper(int[] prices, int i, int state, int[][] mem){ // 1 2 3 0 2
        if(i >= prices.length) return 0;
        int ans = 0;
        if(mem[state][i] != Integer.MAX_VALUE) return mem[state][i];
        if(state == 0){
            ans = Math.max(maxProfitHelper(prices,i+1,0, mem), -prices[i]+maxProfitHelper(prices, i+1, 1, mem));
        }
        else if(state == 1){

            ans = Math.max(maxProfitHelper(prices,i+1,1, mem), prices[i]+maxProfitHelper(prices, i+1, 2, mem));

        } else if(state == 2){
            ans = maxProfitHelper(prices,i+1,0,mem);
        }
        mem[state][i] = ans;
        return ans;
    }
}