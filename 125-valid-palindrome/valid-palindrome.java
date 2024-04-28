class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start <= end){
            char a = s.charAt(start);
            char b = s.charAt(end);
            if(!Character.isLetterOrDigit(a)) start++;
            else if(!Character.isLetterOrDigit(b)) end--;
            else {
                if(Character.toLowerCase(a) != Character.toLowerCase(b)) return false;
                start++;
                end--;
            }
        }
        return true;
    }
}