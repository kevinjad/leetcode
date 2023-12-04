class Solution {
    public int change(int amount, int[] coins) {
        int[][] mem = new int[coins.length+1][amount+1];
        for(int[] arr : mem) Arrays.fill(arr, 0);
        mem[0][0] = 1;
        for(int i = 1;i<=coins.length;i++){
            mem[i][0] = 1;
            for(int j = 1;j<=amount;j++){
                mem[i][j] = mem[i-1][j] + (j>=coins[i-1] ? mem[i][j-coins[i-1]] : 0);
            }
        }
        return mem[coins.length][amount];
    }
    // public int change(int amount, int[] coins) {
    //     int[][] mem = new int[coins.length][amount+1];
    //     for(int[] arr : mem) Arrays.fill(arr, -1);
    //     return changeHelper(amount, coins, 0, mem);
    // }

    // public int changeHelper(int amount, int[] coins, int i, int[][] mem){
    //     if(amount == 0) return 1;
    //     if(amount < 0) return 0;

    //     if(i >= coins.length) return 0;
    //     if(mem[i][amount] != -1) return mem[i][amount];

    //     int ans =  changeHelper(amount-coins[i],coins, i, mem) + changeHelper(amount, coins, i+1, mem);
    //     mem[i][amount] = ans;
    //     return ans;
    // }
}