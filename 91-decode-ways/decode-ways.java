class Solution {
    public int numDecodings(String s) {
        int[] mem = new int[s.length()];
        Arrays.fill(mem, -1);
        return numDecodingsHelper(s,0, mem);
    }

    public int numDecodingsHelper(String s, int i, int[] mem){
        if(i >= s.length()) return 1;
        if(mem[i] != -1) return mem[i];
        int a = 0;
        if(s.charAt(i) != '0'){
            a = numDecodingsHelper(s,i+1,mem);
        }
        int b = 0;
        if(i+1 < s.length() && ((s.charAt(i) == '1') || (s.charAt(i) == '2' && "0123456".contains(String.valueOf(s.charAt(i+1)))))){
            b = numDecodingsHelper(s, i+2, mem);
        }
        mem[i] = a+b;
        return mem[i];
    }
}