class Solution {
    public int climbStairs(int n) {
        return climbStairsHelper(n, new int[n+1]);
    }

    public int climbStairsHelper(int n, int[] mem){
        if(n==1) return 1;
        if(n == 2) return 2;
        if(mem[n] != 0) return mem[n];
        mem[n] = climbStairsHelper(n-1,mem)+climbStairsHelper(n-2,mem);
        return mem[n];
    }
}