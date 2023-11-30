class Solution {
   public static int longestCommonSubsequence(String text1, String text2) {
        int[][] mem = new int[text1.length()+1][text2.length()+1];
        for(int[] arr : mem)
            Arrays.fill(arr,0);
        for(int i = text1.length()-1;i>=0;i--){
            for (int j = text2.length()-1;j>=0;j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    mem[i][j] = mem[i+1][j+1] + 1;
                } else{
                    mem[i][j] = Math.max(mem[i][j+1],mem[i+1][j]);
                }
            }
        }
        return mem[0][0];
    }
}