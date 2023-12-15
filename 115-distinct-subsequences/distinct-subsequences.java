class Solution {
    public int numDistinct(String s, String t) {
        int[][] mem = new int[s.length()][t.length()];
        for(int[] m : mem){
            Arrays.fill(m,-1);
        }
        return numDistinctHelper(s.toCharArray(), t.toCharArray(), 0, 0, mem);
    }

    public int numDistinctHelper(char[] s, char[] t, int i, int k, int[][] mem){
        if(k >= t.length) return 1;
        if(i >= s.length) return 0;
        if(mem[i][k] != -1) return mem[i][k]; 
        int ans = 0;
        if(s[i] == t[k]){
            ans = numDistinctHelper(s, t, i+1, k+1, mem)+numDistinctHelper(s, t, i+1, k, mem);
        } else{
            ans = numDistinctHelper(s, t, i+1, k, mem);
        }
        mem[i][k] = ans;
        return ans;
    }
}