class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        // for(String s : strs){
        //     char[] footPrint = new char[26];
        //     for(char c : s.toCharArray()){
        //         footPrint[c-'a']++;
        //     }
        //     String footPrintString = String.valueOf(footPrint);
        //     ans.putIfAbsent(footPrintString, new ArrayList<>());
        //     ans.get(footPrintString).add(s);
        // }
        // return new ArrayList<>(ans.values());

        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedShit = String.valueOf(c);
            ans.putIfAbsent(sortedShit, new ArrayList<>());
            ans.get(sortedShit).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}