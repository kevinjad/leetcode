class Solution {
    public int longestValidParentheses(String s) {
        int left = 0; int right = 0;
        int max = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                left++;
            } else {
                right++;
            }
            if(left<right){
                left = 0; right = 0;
            }
            if(left == right){
                max = Math.max(left+right, max);
            }
        }

        left = 0;right=0;
    for(int i = s.length()-1;i>=0;i--){
        if(s.charAt(i) == '('){
                left++;
            } else {
                right++;
            }

            if(left>right){
                left = 0; right = 0;
            }
            if(left == right){
                max = Math.max(left+right, max);
            }
    }
        return max;
    }
}