class Solution {
    public boolean isMatch(String a, String b){
        Boolean[][] mem = new Boolean[a.length()+1][b.length()+1];
        return reghelp(0,0,a,b, mem);
    }

    private boolean reghelp(int i, int j, String a, String b, Boolean[][] mem) { // aab a*b
        if(i >= a.length() && j >= b.length()) return true;
        if(j >= b.length())return false;

        if(mem[i][j] != null) return mem[i][j]==true;
        Boolean result;
        boolean match = i<a.length() && (a.charAt(i) == b.charAt(j) || b.charAt(j) == '.');
        if (j+1<b.length() && b.charAt(j+1) == '*'){
            result= (reghelp(i,j+2,a,b, mem) || (match && reghelp(i+1,j,a,b, mem)));
            mem[i][j] = result;
            return result==true;
        }
        if(match) {
            result= reghelp(i+1,j+1, a, b, mem);
        } else {
            result= false;
        }
        mem[i][j] = result;
        return result==true;
    }
}