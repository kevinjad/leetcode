class Solution {
   public static int longestCommonSubsequence(String text1, String text2) {
        int[][] mem = new int[text1.length()][text2.length()];
        for(int[] arr : mem)
            Arrays.fill(arr,-1);
        return longestCommonSubsequenceHelper(text1,text2,0,0,mem);
    }

    public static int longestCommonSubsequenceHelper(String text1, String text2, int i, int j, int[][] mem){
        if(i>=text1.length() || j >= text2.length()) return 0;
        int ans;
        if(mem[i][j] != -1) return mem[i][j];
        if(text1.charAt(i) == text2.charAt(j)){
            ans = 1+longestCommonSubsequenceHelper(text1,text2,i+1,j+1, mem);
        } else{
            ans = Math.max(longestCommonSubsequenceHelper(text1,text2, i, j+1, mem), longestCommonSubsequenceHelper(text1, text2, i+1, j, mem));
        }
        mem[i][j] = ans;
        return ans;
    }
}