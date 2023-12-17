class Solution {
   public int minDistance(String word1, String word2) {
        int[][] mem = new int[word1.length()][word2.length()];
        for(int[] m : mem){
            Arrays.fill(m,-1);
        }
        return minDistanceHelper(word1.toCharArray(),word2.toCharArray(),0,0, mem);
    }

    public int minDistanceHelper(char[] word1, char[] word2, int i, int j, int[][] mem){
        if(i>=word1.length && j >= word2.length) return 0;
        if(j>= word2.length){
            if(i<word1.length) return word1.length-i;
        }
        if(i>=word1.length) {
            if(j<word2.length) {
                return minDistanceHelper(word1,word2,i,j+1, mem)+1;
            }
        }
        if(mem[i][j] != -1) return mem[i][j];
        int ans = 0;
        if(word1[i] == word2[j]) {
            ans =  minDistanceHelper(word1,word2,i+1,j+1, mem);
        } else{
            int a = minDistanceHelper(word1, word2, i, j+1, mem);
            //replace
            int b = minDistanceHelper(word1, word2, i+1, j+1, mem);
            //remove
            int c = minDistanceHelper(word1,word2,i+1,j, mem);

            ans = Math.min(Math.min(a,b),c)+1;
        }
        mem[i][j] = ans;
        return ans;
        //insert
    }
}