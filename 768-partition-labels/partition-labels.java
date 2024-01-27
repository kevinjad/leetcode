class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int max = 0;
        int prev = -1;
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            map.put(c, i);
        }

        for(int i = 0;i<s.length();i++){
            max = Math.max(max, map.get(s.charAt(i)));
            if(max == i){
                result.add(max-prev);
                prev = max;
            }
        }
        return result;
    }
}