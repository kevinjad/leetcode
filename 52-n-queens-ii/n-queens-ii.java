class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        count=0;
        boolean [] columns = new boolean[n];
        boolean[] d1 = new boolean[2*n];
        boolean[] d2 = new boolean[2*n];

        helper(columns, d1, d2, 0, n);
        return count;
    }

    public void helper(boolean[] columns, boolean[] d1, boolean[] d2, int i, int n){
        if(i==n){
            count++;
            return;
        }
        for(int j = 0;j<n;j++){
            int ii = j-i+n;
            int jj = i+j;
            if((columns[j] || d1[ii] || d2[jj])){
                continue;
            }
            columns[j] = true;
                d1[ii] = true;
                d2[jj] = true;
                helper(columns, d1, d2, i+1, n);
                columns[j] = false;
                d1[ii] = false;
                d2[jj] = false;
        }
    }
}