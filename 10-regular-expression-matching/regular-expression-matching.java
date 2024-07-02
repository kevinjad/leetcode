class Solution {
    public boolean isMatch(String a, String b){
        return reghelp(0,0,a,b);
    }

    private boolean reghelp(int i, int j, String a, String b) { // aab a*b
        if(i >= a.length() && j >= b.length()) return true;
        if(j >= b.length())return false;

        boolean match = i<a.length() && (a.charAt(i) == b.charAt(j) || b.charAt(j) == '.');
        if (j+1<b.length() && b.charAt(j+1) == '*'){
            return (reghelp(i,j+2,a,b) || (match && reghelp(i+1,j,a,b)));
        }
        if(match) {
            return reghelp(i+1,j+1, a, b);
        } else {
            return false;
        }
    }
}