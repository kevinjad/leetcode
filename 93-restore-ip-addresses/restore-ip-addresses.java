class Solution {
   public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        helper(result, s, 0, "");
        return result;
    }

    public static void helper(List<String> result, String s, int i, String cur){
        if(i == s.length()){
            if(cur.split("\\.").length == 4){
                result.add(cur);
            }
            return;
        }
        if(cur.split("\\.").length > 4 ) return;
        String[] dotsplit = cur.split("\\.");
        if(!(dotsplit.length == 0)){
            String dots = dotsplit[dotsplit.length-1];
            if(checkValidIPNumIndot(dots+s.charAt(i))){
                if(dots.isEmpty()){
                    helper(result, s, i+1, cur+s.charAt(i));
                } else {
                    helper(result, s, i+1, cur+"."+s.charAt(i));
                    helper(result, s, i+1, cur+s.charAt(i));
                }
            } else {
                helper(result, s, i+1, cur+"."+s.charAt(i));
            }
        }
    }

    public static boolean checkValidIPNumIndot(String s){
        if(255 < Integer.parseInt(s)) return false;
        return !(s.startsWith("0") && s.length() > 1);
    }
}