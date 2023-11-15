class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int[][] mem = new int[n][n];
        for(int i = 0;i<n;i++){
            mem[i][i] = 1;
            count++;
        }
        for(int i = 0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                mem[i][i+1] = 1;
                count++;
            }
        }
        for(int j = 2;j<n;j++){
            for(int i = 0; i+j<n;i++){
                if(s.charAt(i) == s.charAt(i+j) && mem[i+1][i+j-1] == 1){
                    mem[i][i+j] = 1;
                    count++;
                }
            }
        }
        return count;
    }
}