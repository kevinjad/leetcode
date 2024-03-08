class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        for(String s : strs){
            char[] footPrint = new char[26];
            for(char c : s.toCharArray()){
                footPrint[c-'a']++;
            }
            String footPrintString = String.valueOf(footPrint);
            ans.putIfAbsent(footPrintString, new ArrayList<>());
            ans.get(footPrintString).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}