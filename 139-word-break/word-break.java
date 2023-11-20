class Solution {
   public static boolean wordBreak(String s, List<String> wordDict) {
        int[] mem = new int[s.length()+1];
        Arrays.fill(mem,-1);
        return wordBreakHelper(s,new HashSet<>(wordDict),0, mem);
    }

    public static boolean wordBreakHelper(String s, Set<String> wordDict, int p, int[] mem){
        String tmp="";
        if(p >= s.length()) return true;
        if(mem[p] != -1) return mem[p] == 1;
        for(int i = p;i<s.length();i++){
            tmp += s.charAt(i);
            if(wordDict.contains(tmp)){
                if(wordBreakHelper(s, wordDict, i + 1, mem)){
                    mem[i] = 1;
                    return true;
                }
            }
        }
        mem[p] =0;
        return false;
    }
}