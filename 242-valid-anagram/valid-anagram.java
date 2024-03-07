class Solution {
    public boolean isAnagram(String s, String t) {
        // int[] footPrint = new int[26]; //[0 0 0 0 .. 0 0]
        // for(char c : s.toCharArray()){
        //     footPrint[c-'a']++; // [ 1 0 1 2 0 0..]
        // }

        // for(char c : t.toCharArray()){
        //     footPrint[c-'a']--;
        // }
        // for(int i = 0;i<26;i++){
        //     if(footPrint[i] != 0) return false;
        // }
        // return true;

        if(s.length() != t.length()) return false;
        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        char[] tt = t.toCharArray();
        Arrays.sort(tt);
        for(int i = 0;i<ss.length;i++){
            if(tt[i] != ss[i]) return false;
        }
        return true;
    }
}