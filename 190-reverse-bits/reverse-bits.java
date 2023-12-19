public class Solution {
    // you need treat n as an unsigned value

    //Yes, it will add an extra left shift. You must keep in mind that the left shift on result is making room for the one's place computation. If you left shift in the last iteration, it preps result for the next computation, although there would be none. So, it is better to prep the result before the check so that there is no extra left shift.
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0;i<32;i++){
            result <<= 1;
            if((n & 1) == 1) result ++;
            n >>= 1;
        }  
        return result;
    }
}