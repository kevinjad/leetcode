class Solution {
    public int reverse(int x) {
        int result = 0;
        int newResult = 0;
        while(x != 0){
            int rem = x % 10;
            newResult = result*10 + rem;
            if(result != (newResult-rem)/10) return 0;
            result = newResult;
            x = x/10;
        }
        return result;
    }
}