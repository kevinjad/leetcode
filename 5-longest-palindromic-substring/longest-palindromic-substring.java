class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int currentMax = 0;
        int[][] mem = new int[s.length()][s.length()];
        for(int i = 0; i<s.length();i++){
            mem[i][i] = 1;
        }
        for(int i = 0;i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                mem[i][i+1] = 1;
                start = i;
                end = i+1;
            }
        }
        for(int j = 2;j<s.length();j++){
            for(int i = 0;i+j<s.length();i++){
                if(s.charAt(i) == s.charAt(i+j)){
                    if(mem[i+1][i+j-1] == 1){
                        mem[i][i+j] = 1;
                        start = i;
                        end = i+j;
                    }
                }
            }
        }


        return s.substring(start,end+1);
    }
//    public String longestPalindrome(String s) {
//         int start = 0;
//         int end = 0;
//         int currentMax = 0;
//         int[][] mem = new int[s.length()][s.length()];
//         for(int i = 0; i<s.length();i++){
//             for(int j = i; j<s.length();j++){
//                 if(isPalindrome(i,j,s, mem)){
//                     if(currentMax < (j-i+1)){
//                         currentMax = j-i+1;
//                         start = i;
//                         end = j;
//                     }
//                 }
//             }
//         }
//         return s.substring(start,end+1);
//     }

//     private boolean isPalindrome(int i, int j, String s, int[][] mem) {
//         if(i>=s.length() || j <0 || j<i) return false;
//         if(i == j) return true;
//         if(i+1 == j) return s.charAt(i) == s.charAt(j);
        
//         if(mem[i][j] != 0){
//             return mem[i][j] ==1;
//         }

//         if(s.charAt(i) == s.charAt(j)){
//             if(isPalindrome(i+1,j-1,s,mem)){
//                 mem[i][j] = 1;
//                 return true;
//             } else {
//                 mem[i][j] = 2;
//                 return false;
//             }
//         } else {
//             mem[i][j] = 2;
//             return false;
//         }
//     }
}