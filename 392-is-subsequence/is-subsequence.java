class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        if(s.length()>t.length()) return false;
        while(i<s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            } 
                j++;
            
        }
        return i == s.length();
    }

    // public boolean isSubsequence(String s, String t) {
    //     List<Integer>[] map = new List[256];
    //     for(int i = 0;i<t.length();i++){
    //         if(map[t.charAt(i)] == null){
    //             map[t.charAt(i)] = new ArrayList<>();
    //         }
    //         map[t.charAt(i)].add(i);
    //     }
    //     int p = 0;
    //     for (int i = 0;i<s.length();i++){
    //         if(map[s.charAt(i)] == null) return false;
    //         int l = Collections.binarySearch(map[s.charAt(i)],p);
    //         if(l<0)l = -l -1;
    //         if(l == map[s.charAt(i)].size()) return false;
    //         p = map[s.charAt(i)].get(l)+1;
    //     }
    //     return true;
    // }
}