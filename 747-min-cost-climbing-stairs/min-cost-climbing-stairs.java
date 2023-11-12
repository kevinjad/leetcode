class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] mem = new int[cost.length];
        return Math.min(minCostClimbingStairsHelper(cost, 0, mem), minCostClimbingStairsHelper(cost, 1, mem));
    }

    public int minCostClimbingStairsHelper(int[] cost, int i, int[] mem){
        if(i == cost.length) return 0;
        if(i == cost.length-1) return cost[i];
        if(mem[i] != 0) return mem[i];
        int result = Math.min(minCostClimbingStairsHelper(cost,i+1,mem),minCostClimbingStairsHelper(cost,i+2,mem))+cost[i];
        mem[i] = result;
        return result;
    }
}