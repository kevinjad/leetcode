class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        return rle(countAndSay(n-1));
    }

    public String rle(String s){
        int curc = 1;
        char c = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<s.length();i++){
            if(c == s.charAt(i)){
                curc++;
            } else {
                String topush = Character.toString((char)(curc+'0')) + Character.toString(c);
                sb.append(topush);
                curc = 1;
                c = s.charAt(i);
            }
        }
        String topush = Character.toString((char)(curc+'0')) + Character.toString(c);
        sb.append(topush);
        return sb.toString();
    }
}