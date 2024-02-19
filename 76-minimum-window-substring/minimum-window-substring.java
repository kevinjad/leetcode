class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128]; // 
        for(char c : t.toCharArray()) map[c]++; //000000000100000100000
        
        int start = 0, end = 0, minlen = s.length()+1, startIndex = 0, count=0;
        for(;end<s.length();end++){
            map[s.charAt(end)]--;
            if(map[s.charAt(end)] >= 0) count++;
            while(count == t.length() && start <= end){
                if(end-start < minlen){
                    startIndex = start;
                    minlen = end-start;
                }
                map[s.charAt(start)]++; // bobyy boy
                if(start <= end && map[s.charAt(start)] > 0){
                    count--;
                }
                start++;
                
            }
        }
        return minlen == s.length()+1 ? "" : s.substring(startIndex,startIndex+minlen+1);
    }
}