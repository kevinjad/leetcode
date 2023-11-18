class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] mem = new int[amount+1];
        return coinChangeHelper(coins, amount, mem);
    }

    public int coinChangeHelper(int[] coins, int amount, int[] mem){
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(mem[amount] != 0) return mem[amount];
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int numOfCoins = coinChangeHelper(coins, amount-coin, mem);
            if(numOfCoins != -1){
                min = Math.min(numOfCoins+1, min);
            } 
        }
        min = min == Integer.MAX_VALUE ? -1 : min;
        mem[amount] = min;
        return min;
    }
}