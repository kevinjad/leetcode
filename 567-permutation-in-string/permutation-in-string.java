class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        int s1len = s1.length();
        for(char c : s1.toCharArray()){
            map[c-'a']++;
        }
        char[] s2arr = s2.toCharArray();
        for(int i = 0;i<s2.length();i++){
            map[s2arr[i]-'a']--;
            if(i-s1len >= 0){
                map[s2arr[i-s1len]-'a']++;
            }
            if(checkAllZero(map)) return true;
        }
        return false;
    }

    public static boolean checkAllZero(int[] map){
        for(int i : map){
            if(i != 0) return false;
        }
        return true;
    }
}