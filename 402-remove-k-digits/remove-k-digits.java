class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();
        for(char c : num.toCharArray()){
            while(!s.isEmpty() && s.peek() > c && k>0){
                s.pop();
                k--;
            }
            if(!(s.isEmpty() && c == '0')) s.add(c);
        }
        while(!s.isEmpty() && k>0){
            s.pop();
            k--;
        }
        StringBuilder builder = new StringBuilder(s.size());
        for(Character c : s){
            builder.append(c);
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }
}