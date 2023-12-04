class Solution {
    public int change(int amount, int[] coins) {
        int[][] mem = new int[coins.length][amount+1];
        for(int[] arr : mem) Arrays.fill(arr, -1);
        return changeHelper(amount, coins, 0, mem);
    }

    public int changeHelper(int amount, int[] coins, int i, int[][] mem){
        if(amount == 0) return 1;
        if(amount < 0) return 0;

        if(i >= coins.length) return 0;
        if(mem[i][amount] != -1) return mem[i][amount];

//        for(;i<coins.length;i++){
//            ans = changeHelper(amount-coins[i],coins, i);
//        }

        int ans =  changeHelper(amount-coins[i],coins, i, mem) + changeHelper(amount, coins, i+1, mem);
        mem[i][amount] = ans;
        return ans;
    }
}