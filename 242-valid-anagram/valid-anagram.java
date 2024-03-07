class Solution {
    public boolean isAnagram(String s, String t) {
        int[] footPrint = new int[26];
        for(char c : s.toCharArray()){
            footPrint[c-'a']++;
        }
        for(char c : t.toCharArray()){
            footPrint[c-'a']--;
        }
        for(int i = 0;i<26;i++){
            if(footPrint[i] != 0) return false;
        }
        return true;
    }
}