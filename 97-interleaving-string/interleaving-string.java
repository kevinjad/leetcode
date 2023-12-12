class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s2.length()+s1.length()) return false;
        return isInterleaveHelper(s1.toCharArray(),s2.toCharArray(),s3.toCharArray(),0,0,0,new int[s1.length()][s2.length()]);
    }

    public boolean isInterleaveHelper(char[] s1, char[] s2, char[] s3, int i, int p, int q, int[][] mem){
        if(i>=s3.length && p>=s1.length && q>=s2.length) return true;
        boolean answer=false;
        if(p<s1.length && s3[i] == s1[p] && q<s2.length && s3[i] == s2[q]){
            if(mem[p][q] != 0) return mem[p][q] == 1;
            answer = isInterleaveHelper(s1, s2, s3, i+1, p+1, q, mem) || isInterleaveHelper(s1, s2, s3, i+1, p, q+1, mem);
            mem[p][q] = answer ? 1 : -1;
        } else if (p<s1.length && s3[i] == s1[p]){
            answer = isInterleaveHelper(s1, s2, s3, i+1, p+1, q, mem);
        } else if(q<s2.length && s3[i] == s2[q]){
            answer = isInterleaveHelper(s1, s2, s3, i+1, p, q+1, mem);
        }
        return answer;
    }
}