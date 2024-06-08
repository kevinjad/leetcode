class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> a[1]- b[1]);
        int[] mem = new int[pairs.length];
        Arrays.fill(mem, -1);
        return helper(pairs.length, pairs, 0, Integer.MIN_VALUE, mem);
    }

    public int helper(int n, int[][] pairs, int i, int prevEndingValue, int[] mem){
        if(i>=n) return 0;
        if(mem[i] != -1) return mem[i];
        int startValue = pairs[i][0];
        int ans;
        if(startValue > prevEndingValue){
            ans = Math.max(1+helper(n, pairs, i+1, pairs[i][1], mem), helper(n, pairs, i+1, prevEndingValue, mem));
        } else {
            ans = helper(n, pairs, i+1, prevEndingValue, mem);
        }
        mem[i] = ans;
        return ans;
    }
}